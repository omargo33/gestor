/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.worksheet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

import com.aplicaciones13.pdf.impresion.itext.ImpresionBaseElementos;
import com.aplicaciones13.pdf.utilidades.Mensaje;

import jxl.CellView;
import jxl.write.WritableImage;
import lombok.extern.slf4j.Slf4j;

/**
 * Objeto con los datos de creacion de una hoja de calculo.
 *
 * @author omargo33@gmail.com
 *
 */
@Slf4j
public class WorksheetEstadoCuenta {
    
    /**
     * Manejo de mensajes.
     */
    Mensaje mensajes = new Mensaje(ImpresionBaseElementos.NOMBRE_APLICACION);
    private HojaCalculoEngine hce;

    private List<Object[]> valores;
    private Map<String, String> parametrosBusqueda;

    public OutputStream ejecutar(Map<String, String> mapa) {
        parametrosBusqueda = mapa;
        try {
            File file = new File(String.valueOf(getParametrosBusqueda().get("documentoDestino")));
            FileOutputStream outputStream = new FileOutputStream(file);
            this.hce = new HojaCalculoEngine(outputStream);

            if (getParametrosBusqueda().get("documentoCosede") == null) {
                escribeTitulos(String.valueOf(getParametrosBusqueda().get("nombre")),
                        String.valueOf(getParametrosBusqueda().get("noCuenta")),
                        String.valueOf(getParametrosBusqueda().get("fechaPeriodo")),
                        String.valueOf(getParametrosBusqueda().get("saldoDisponible")),
                        String.valueOf(getParametrosBusqueda().get("saldoBloqueado")),
                        String.valueOf(getParametrosBusqueda().get("saldoTotal")));
            } else {
                escribeTitulos(String.valueOf(getParametrosBusqueda().get("nombre")),
                        String.valueOf(getParametrosBusqueda().get("noCuenta")),
                        String.valueOf(getParametrosBusqueda().get("fechaPeriodo")),
                        String.valueOf(getParametrosBusqueda().get("saldoDisponible")),
                        String.valueOf(getParametrosBusqueda().get("saldoBloqueado")),
                        String.valueOf(getParametrosBusqueda().get("saldoTotal")),
                        String.valueOf(getParametrosBusqueda().get("documentoCosede"))
                );
            }

            escribirContenido(valores);

            this.hce.espaciosCeldas(2, 5);

            this.hce.cerrarLibro();
            return this.hce.getOutputStream();
        } catch (IOException e) {
            log.error(".ejecutar()", e.toString());
        }
        return null;
    }

    /**
     * Metodo para escribir el contenido.
     *
     * @param lista
     */
    private void escribirContenido(List<Object[]> lista) {
        int i = 0;
        int j = 15;

        if (!lista.isEmpty()) {
            CellView cellView = this.hce.getHojaActual().getColumnView(10);
            cellView.setSize(8000);
            this.hce.getHojaActual().setColumnView(10, cellView);

            CellView cellViewFecha = this.hce.getHojaActual().getColumnView(1);
            cellViewFecha.setSize(4000);
            this.hce.getHojaActual().setColumnView(1, cellViewFecha);

            CellView cellViewOrden = this.hce.getHojaActual().getColumnView(0);
            cellViewOrden.setSize(1500);
            this.hce.getHojaActual().setColumnView(0, cellViewOrden);
        }

        for (Object[] l : lista) {
            this.hce.addValorCelda(0, j, ++i, HojaCalculoEngine.P_ENTERO);
            this.hce.addValorCelda(1, j, l[0], HojaCalculoEngine.P_FECHA);
            this.hce.addValorCelda(2, j, l[1], HojaCalculoEngine.P);
            this.hce.addValorCelda(3, j, l[2], HojaCalculoEngine.P);
            this.hce.addValorCelda(4, j, l[3], HojaCalculoEngine.P_DECIMAL);
            this.hce.addValorCelda(5, j, l[4], HojaCalculoEngine.P_DECIMAL);
            this.hce.addValorCelda(6, j, l[5], HojaCalculoEngine.P_DECIMAL);
            this.hce.addValorCelda(7, j, l[6], HojaCalculoEngine.P_DECIMAL);
            this.hce.addValorCelda(8, j, l[7], HojaCalculoEngine.P_DECIMAL);
            this.hce.addValorCelda(9, j, l[8], HojaCalculoEngine.P_STRONG_DECIMAL);
            this.hce.addValorCelda(10, j, l[9], HojaCalculoEngine.P_WRAP);

            if (String.valueOf(l[9]).length() > 30) {
                this.hce.anchoFila(j, HojaCalculoEngine.H1);
            }
            j++;
        }
    }

    /**
     * Metodo para agregar imagen de COSEDE.
     * 
     * @param nombreSocio
     * @param noCuenta
     * @param periodo
     * @param saldoDisponible
     * @param saldoBloquead
     * @param saldoTotal
     * @param pathCosede 
     */
    private void escribeTitulos(String nombreSocio, String noCuenta, String periodo, String saldoDisponible, String saldoBloquead, String saldoTotal, String pathCosede) {
        escribeTitulos(nombreSocio, noCuenta, periodo, saldoDisponible, saldoBloquead, saldoTotal);
        
        try {
            java.io.File imageFile = new java.io.File(pathCosede);
            BufferedImage input = ImageIO.read(imageFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(input, "PNG", baos);
            this.hce.getHojaActual().addImage(new WritableImage(9, 5, 2, 4, baos.toByteArray()));
        } catch (IOException e) {
            log.error("Escribir titulos", e);
        }
    }

    /**
     * Metodo para escribir los titulos de la hoja de calculo.
     *
     * Combinacion de celdas Anchos de filas Titulos
     *
     * @param tituloHoja
     */
    private void escribeTitulos(String nombreSocio, String noCuenta, String periodo, String saldoDisponible, String saldoBloquead, String saldoTotal) {
        this.hce.addSheet("Cta_" + noCuenta);
        this.hce.combinarCeldas(0, 0, 10, 0);
        this.hce.combinarCeldas(0, 1, 10, 1);
        this.hce.combinarCeldas(0, 3, 10, 3);
        this.hce.combinarCeldas(0, 5, 1, 5);
        this.hce.combinarCeldas(0, 6, 1, 6);
        this.hce.combinarCeldas(0, 7, 1, 7);
        this.hce.combinarCeldas(0, 8, 1, 8);
        this.hce.combinarCeldas(0, 9, 1, 9);
        this.hce.combinarCeldas(0, 10, 1, 10);
        this.hce.combinarCeldas(0, 11, 1, 11);
        this.hce.combinarCeldas(2, 5, 8, 5);
        this.hce.combinarCeldas(2, 6, 8, 6);
        this.hce.combinarCeldas(2, 7, 8, 7);
        //this.hce.combinarCeldas(2, 8, 8, 8);
        
        this.hce.combinarCeldas(9, 5, 10, 7);
        this.hce.combinarCeldas(2, 11, 10, 11);
        this.hce.combinarCeldas(4, 13, 5, 13);
        this.hce.combinarCeldas(6, 13, 7, 13);
        this.hce.anchoFila(0, HojaCalculoEngine.H1);
        this.hce.anchoFila(3, HojaCalculoEngine.H1);
        this.hce.anchoFila(5, HojaCalculoEngine.H2);
        this.hce.anchoFila(6, HojaCalculoEngine.H2);
        this.hce.anchoFila(7, HojaCalculoEngine.H2);
        this.hce.anchoFila(8, HojaCalculoEngine.H2);
        this.hce.anchoFila(9, HojaCalculoEngine.H2);
        this.hce.anchoFila(10, HojaCalculoEngine.H2);
        this.hce.anchoFila(11, HojaCalculoEngine.H2);
        this.hce.anchoFila(14, HojaCalculoEngine.H2);
        this.hce.anchoFila(13, HojaCalculoEngine.H2);
        
        this.hce.addValorCelda(0, 0, mensajes.obtenerMensaje("txt_001_01"), HojaCalculoEngine.H1);
        this.hce.addValorCelda(0, 1, mensajes.obtenerMensaje("txt_001_08"), HojaCalculoEngine.H3);
        this.hce.addValorCelda(0, 3, mensajes.obtenerMensaje("txt_001_09"), HojaCalculoEngine.H1);

        this.hce.addValorCelda(0, 5, mensajes.obtenerMensaje("txt_001_10"), HojaCalculoEngine.H2_LEFT);
        this.hce.addValorCelda(0, 6, mensajes.obtenerMensaje("txt_001_11"), HojaCalculoEngine.H2_LEFT);
        this.hce.addValorCelda(0, 7, mensajes.obtenerMensaje("txt_001_12"), HojaCalculoEngine.H2_LEFT);

        this.hce.addValorCelda(0, 8, mensajes.obtenerMensaje("txt_001_28"), HojaCalculoEngine.H2_LEFT);
        this.hce.addValorCelda(0, 9, mensajes.obtenerMensaje("txt_001_29"), HojaCalculoEngine.H2_LEFT);
        this.hce.addValorCelda(0, 10, mensajes.obtenerMensaje("txt_001_30"), HojaCalculoEngine.H2_LEFT);
        this.hce.addValorCelda(0, 11, mensajes.obtenerMensaje("txt_001_27"), HojaCalculoEngine.H2_LEFT);

        this.hce.addValorCelda(2, 5, nombreSocio, HojaCalculoEngine.P_STRONG);
        this.hce.addValorCelda(2, 6, mensajes.obtenerMensaje("txt_001_13"), HojaCalculoEngine.P_STRONG);
        this.hce.addValorCelda(2, 7, noCuenta, HojaCalculoEngine.P_STRONG);

        this.hce.addValorCelda(2, 8, saldoDisponible, HojaCalculoEngine.P_DECIMAL);
        this.hce.addValorCelda(2, 9, saldoBloquead, HojaCalculoEngine.P_DECIMAL);
        this.hce.addValorCelda(2, 10, saldoTotal, HojaCalculoEngine.P_STRONG_DECIMAL);
        this.hce.addValorCelda(2, 11, periodo, HojaCalculoEngine.P_STRONG);

        this.hce.addValorCelda(4, 13, mensajes.obtenerMensaje("txt_001_14"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(6, 13, mensajes.obtenerMensaje("txt_001_15"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(0, 14, mensajes.obtenerMensaje("txt_001_16"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(1, 14, mensajes.obtenerMensaje("txt_001_17"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(2, 14, mensajes.obtenerMensaje("txt_001_18"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(3, 14, mensajes.obtenerMensaje("txt_001_19"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(4, 14, mensajes.obtenerMensaje("txt_001_20"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(5, 14, mensajes.obtenerMensaje("txt_001_21"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(6, 14, mensajes.obtenerMensaje("txt_001_22"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(7, 14, mensajes.obtenerMensaje("txt_001_23"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(8, 14, mensajes.obtenerMensaje("txt_001_24"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(9, 14, mensajes.obtenerMensaje("txt_001_25"), HojaCalculoEngine.H2);
        this.hce.addValorCelda(10, 14, mensajes.obtenerMensaje("txt_001_26"), HojaCalculoEngine.H2);
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(List<Object[]> valores) {
        this.valores = valores;
    }

    /**
     * @return the parametrosBusqueda
     */
    public Map<String, String> getParametrosBusqueda() {
        return parametrosBusqueda;
    }
}
