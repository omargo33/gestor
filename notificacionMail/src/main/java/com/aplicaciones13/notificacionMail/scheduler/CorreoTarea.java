/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.notificacionMail.scheduler;

import com.aplicaciones13.notificacionMail.jpa.model.Formato;
import com.aplicaciones13.notificacionMail.jpa.model.Notificacion;
import com.aplicaciones13.notificacionMail.jpa.model.NotificacionParametro;
import com.aplicaciones13.notificacionMail.jpa.model.Servicio;
import com.aplicaciones13.notificacionMail.servicio.CorreoService;
import com.aplicaciones13.notificacionMail.tools.Correo;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author omarv
 */
@Component
public class CorreoTarea {
    
    private static final Logger LOG = LoggerFactory.getLogger(CorreoTarea.class);
    
    @Value("${aplicacion.nombre}")
    String nompreAplicacion;

    @Autowired
    private CorreoService correoService;

    @Scheduled(cron = "2 * * * * *", zone = "GMT-5")
    public void realizarTarea() {
        
        LOG.info("subido!!");
        
        enviarNotificaciones();
    }

    /**
     * Metodo para enviar a notificar.
     *
     */
    private void enviarNotificaciones() {
        Long idServicio = 0L;
        Long idFormato = 0L;
        List<Notificacion> listaNotificaciones = correoService.buscarNotificacionesPendientes();
        Formato formato = new Formato();
        Servicio servicio = new Servicio();
        Correo correo = new Correo();

        for (Notificacion n : listaNotificaciones) {
            correoService.crearNotificacionEvento(n, "Inicia el proceso", "IP", nompreAplicacion);
            if (idServicio != n.getIdServicio()) {
                idServicio = n.getIdServicio();
                servicio = correoService.buscarServicio(idServicio);
            }

            if (servicio.getTipo().compareToIgnoreCase("E") == 0) {
                if (idFormato != n.getIdFormato()) {
                    idFormato = n.getIdFormato();
                    formato = correoService.buscarFormato(idFormato);
                }

                correo.setCorreo(n.getDireccionEnvio());
                correo.setAsunto(n.getTitulo());
                correo.setCuerpo(ensamblarCuerpo(n.getIdNotificacion(), formato.getFormatoHtml(), n.getContenido()));
                correo.setAdjuntos(encontrarAdjuntos(n.getIdNotificacion()));
                
                LOG.info("info info "+servicio.getValor01() + " " + servicio.getValor02());
                correo.setPropiedades(servicio.getValor01() + " " + servicio.getValor02());
                
                if (correo.enviarCorreo()) {
                    correoService.crearNotificacionEvento(n, "Enviado", "OK", nompreAplicacion);
                    correoService.actualizarNotificacion(n, "OK");
                } else {
                    correoService.crearNotificacionEvento(n, correo.getDescripcionEstado(), "KO", nompreAplicacion);
                    correoService.actualizarNotificacion(n, "KO");
                }
            }
        }
    }

    /**
     * Metodo para ensamblar un cuerpo.
     *
     * @param idNotificacion
     * @param formatoHtml
     * @param contenido
     * @return
     */
    private String ensamblarCuerpo(Long idNotificacion, String formatoHtml, String contenido) {
        List<NotificacionParametro> listaParametro = correoService.buscarParametros(idNotificacion);

        for (NotificacionParametro np : listaParametro) {
            formatoHtml = formatoHtml.replace("{" + np.getLlave() + "}", np.getValor());
        }
        return formatoHtml.replace("{cuerpo}", contenido);
    }

    /**
     * Metodo para recolectar archivos adjuntos para envio.
     *
     * @param idNotificacion
     * @return
     */
    private List<String> encontrarAdjuntos(Long idNotificacion) {
        List<NotificacionParametro> listaParametro = correoService.buscarAdjuntos(idNotificacion);
        List<String> listaAdjuntos = new ArrayList<>();

        listaParametro.forEach(np -> {
            listaAdjuntos.add(np.getValor());
        });

        return listaAdjuntos;
    }
}
