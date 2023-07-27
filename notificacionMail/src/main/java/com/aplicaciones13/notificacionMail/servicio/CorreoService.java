/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.notificacionMail.servicio;

import com.aplicaciones13.notificacionMail.jpa.model.Formato;
import com.aplicaciones13.notificacionMail.jpa.model.Notificacion;
import com.aplicaciones13.notificacionMail.jpa.model.NotificacionEvento;
import com.aplicaciones13.notificacionMail.jpa.model.NotificacionParametro;
import com.aplicaciones13.notificacionMail.jpa.model.Servicio;
import com.aplicaciones13.notificacionMail.jpa.queries.FormatoRepositorio;
import com.aplicaciones13.notificacionMail.jpa.queries.NotificacionRepositorio;
import com.aplicaciones13.notificacionMail.jpa.queries.NotificacionEventoRepositorio;
import com.aplicaciones13.notificacionMail.jpa.queries.NotificacionParametroRepositorio;
import com.aplicaciones13.notificacionMail.jpa.queries.ServicioRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author omarv
 */
@Service
@Transactional
public class CorreoService {

    private final FormatoRepositorio formatoRepositorio;
    private final NotificacionEventoRepositorio notificacionEventoRepositorio;
    private final NotificacionParametroRepositorio notificacionParametroRepositorio;
    private final NotificacionRepositorio notificacionRepositorio;
    private final ServicioRepositorio servicioRepositorio;

    public CorreoService(FormatoRepositorio formatoRepositorio, NotificacionEventoRepositorio notificacionEventoRepositorio, NotificacionParametroRepositorio notificacionParametroRepositorio, NotificacionRepositorio notificacionRepositorio, ServicioRepositorio servicioRepositorio) {
        this.formatoRepositorio = formatoRepositorio;
        this.notificacionEventoRepositorio = notificacionEventoRepositorio;
        this.notificacionParametroRepositorio = notificacionParametroRepositorio;
        this.notificacionRepositorio = notificacionRepositorio;
        this.servicioRepositorio = servicioRepositorio;
    }

    public List<Notificacion> buscarNotificacionesPendientes() {
        return this.notificacionRepositorio.findByEstado("P");
    }

    public List<NotificacionParametro> buscarParametros(Long idNotificacion) {
        return this.notificacionParametroRepositorio.findByIdNotificacionAndTipo(idNotificacion, "P");
    }
    
    public List<NotificacionParametro> buscarAdjuntos(Long idNotificacion) {
        return this.notificacionParametroRepositorio.findByIdNotificacionAndTipo(idNotificacion, "ADJ");
    }

    public Notificacion actualizarNotificacion(Notificacion notificacion, String estado) {
        if (notificacion.getAnular().compareToIgnoreCase("S") == 0) {
            notificacion.setContenido("****");
        }
        notificacion.setEstado(estado);                
        return notificacionRepositorio.save(notificacion);
    }

    public Formato buscarFormato(Long idFormato){    
        return this.formatoRepositorio.findByIdFormato(idFormato);
    }
    
    public Servicio buscarServicio(Long idServicio){
        return this.servicioRepositorio.findByIdServicio(idServicio);    
    }
    
    
    /**
     * Crear evento
     * 
     * @param notificacion
     * @param informacion 
     * @param tipo IP=inicio proceso, OK=proceso terminado correctamente y KO=proceso terminado con error.
     * @param usuarioPrograma
     * @return 
     */
    public NotificacionEvento crearNotificacionEvento(Notificacion notificacion, String informacion, String tipo, String usuarioPrograma){
        NotificacionEvento notificacionEvento=new NotificacionEvento();
        
        notificacionEvento.setIdNotificacionEvento(0l);
        notificacionEvento.setIdNotificacion(notificacion.getIdNotificacion());

        // truncar a 512
        informacion=informacion.length()>512?informacion.substring(0, 512):informacion;

        notificacionEvento.setInformacion(informacion);
        notificacionEvento.setTipo(tipo);
        notificacionEvento.setUsuarioFecha(new Date());
        notificacionEvento.setUsuario(notificacion.getUsuario());
        notificacionEvento.setUsuarioPrograma(usuarioPrograma);
        return this.notificacionEventoRepositorio.save(notificacionEvento);        
    }    
    
}
