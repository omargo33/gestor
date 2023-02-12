/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.impresion;

import com.aplicaciones13.pdf.impresion.itext.ImpresionBaseElementos;
import com.aplicaciones13.pdf.impresion.itext.texto.Elemento;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.util.List;

/**
 * Objeto con los datos de impresiones certificado de socio.
 *
 * @author omargo33@gmail.com
 *
 */
public class ImpresionElementosEstadoCuenta extends ImpresionBaseElementos {

    private List<Object[]> valores;
    private final String SALTO_PAGINA = "\n";

    /**
     * Metodo para imprimir el elemento 1.
     *
     * Datos de scaneo y documentacion electronica.
     *
     */
    @Override
    public synchronized void elemento1() {
        if (getCurrentPosition().getY() < 130) {
            getDocumento().add(new AreaBreak());
        }
        getH3().setTexto(mensajes.obtenerMensaje("txt_000_02"));
        getH3().escribir();

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_000_03"),
                mensajes.obtenerMensaje("txt_000_04"));
        getForm().setListaValores(getParametrosBusqueda().get("documentoCodigo"), getParametrosBusqueda().get("sitioWeb"));
        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().setListaDimensiones(10f, 90f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        
        
        getForm().procesar();
        escribirQR(getForm().getTabla());
    }

    /**
     * Imprime el primer elemento 2.
     *
     * Espacio del la cooperativa y titulo del documento
     *
     */
    @Override
    public synchronized void elemento2() {
        getLineaSolida().escribir();
        getEspacio().escribir(4);

        getH1().setTextoCentro(mensajes.obtenerMensaje("txt_001_01"));
        getH1().escribir();
        getEspacio().escribir(4);

        getH2().setTextoCentro(mensajes.obtenerMensaje("txt_001_09"));
        getH2().escribir();
        getEspacio().escribir(2);

    }

    /**
     * Imprime el primer elemento 3.
     *
     * Espacio del socio
     *
     */
    @Override
    public synchronized void elemento3() {
        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_001_10"),
                mensajes.obtenerMensaje("txt_001_11"),
                mensajes.obtenerMensaje("txt_001_12")
        );
        getForm().setListaValores(
                getParametrosBusqueda().get("nombre"),
                mensajes.obtenerMensaje("txt_001_13"),
                getParametrosBusqueda().get("noCuenta")
        );
        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.LEFT);
        getForm().setListaDimensiones(15f, 85f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().procesarEscribir();

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_001_28"),
                mensajes.obtenerMensaje("txt_001_29"),
                mensajes.obtenerMensaje("txt_001_30")
        );
        getForm().setListaValores(
                getParametrosBusqueda().get("saldoDisponible"),
                getParametrosBusqueda().get("saldoBloqueado"),
                getParametrosBusqueda().get("saldoTotal")
        );
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getForm().setListaDimensiones(18f, 12f);
        getForm().setListaFormatos(Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO);
        getForm().procesarEscribir();

        getForm().setListaTitulos(mensajes.obtenerMensaje("txt_001_27"));
        getForm().setListaValores(getParametrosBusqueda().get("fechaPeriodo"));
        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().setListaDimensiones(20f, 70f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().procesarEscribir();
    }

    /**
     * Imprime el primer elemento 30.
     *
     * Espacio del socio + COSEDE
     *
     */
    @Override
    public synchronized void elemento30() {
        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_001_10"),
                mensajes.obtenerMensaje("txt_001_11"),
                mensajes.obtenerMensaje("txt_001_12")
        );
        getForm().setListaValores(
                getParametrosBusqueda().get("nombre"),
                mensajes.obtenerMensaje("txt_001_13"),
                getParametrosBusqueda().get("noCuenta")
        );
        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.LEFT);
        getForm().setListaDimensiones(15f, 55f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().procesar();

        Cell cellSocio = new Cell();        
        cellSocio.setBorder(Border.NO_BORDER);
        cellSocio.add(getForm().getTabla());

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_001_28"),
                mensajes.obtenerMensaje("txt_001_29"),
                mensajes.obtenerMensaje("txt_001_30")
        );
        getForm().setListaValores(
                getParametrosBusqueda().get("saldoDisponible"),
                getParametrosBusqueda().get("saldoBloqueado"),
                getParametrosBusqueda().get("saldoTotal")
        );
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getForm().setListaDimensiones(18f, 18f);
        getForm().setListaFormatos(Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO);
        getForm().procesar();

        Cell cellSaldos = new Cell();
        cellSaldos.setBorder(Border.NO_BORDER);
        cellSaldos.add(getForm().getTabla());

        getForm().setListaTitulos(mensajes.obtenerMensaje("txt_001_27"));
        getForm().setListaValores(getParametrosBusqueda().get("fechaPeriodo"));
        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().setListaDimensiones(20f, 40f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING);
        getForm().procesar();

        Cell cellFecha = new Cell();
        cellFecha.setBorder(Border.NO_BORDER);
        cellFecha.add(getForm().getTabla());

        Table tablaInformacion = new Table(1);
        tablaInformacion.setBorder(Border.NO_BORDER);
        tablaInformacion.addCell(cellSocio);
        tablaInformacion.addCell(cellSaldos);
        tablaInformacion.addCell(cellFecha);
        getImagen().setPathImagen(getParametrosBusqueda().get("documentoCosede"));

        float total = getDocumento().getPdfDocument().getDefaultPageSize().getWidth();
        getImagen().setMaximoAncho(Math.round(30f / 100 * total));
        getImagen().procesar();

        Cell cellImagen = new Cell();
        cellFecha.setBorder(Border.NO_BORDER);
        cellImagen.add(getImagen().getImagen());

        getPanel().setListaDimensiones(70f, 30f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getPanel().getMapaAlineamiento().put(2, TextAlignment.CENTER);
        getPanel().setListaCeldas(tablaInformacion, cellImagen);
        getPanel().procesarEscribir();

    }

    /**
     * Imprime el primer elemento 3.
     *
     * Espacio del los movimientos
     *
     */
    @Override
    public synchronized void elemento4() {
        getTabla().setListaTitulos("",mensajes.obtenerMensaje("txt_001_14"),
                mensajes.obtenerMensaje("txt_001_15"),"");
        getTabla().setListaDimensiones(46f, 16f, 16f, 22f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().procesarEscribir();
        
        
        
        getTabla().setListaTitulos(
                mensajes.obtenerMensaje("txt_001_17"),
                mensajes.obtenerMensaje("txt_001_18"),
                mensajes.obtenerMensaje("txt_001_19"),
                mensajes.obtenerMensaje("txt_001_20"),
                mensajes.obtenerMensaje("txt_001_21"),
                mensajes.obtenerMensaje("txt_001_22"),
                mensajes.obtenerMensaje("txt_001_23"),
                mensajes.obtenerMensaje("txt_001_24"),
                mensajes.obtenerMensaje("txt_001_25")
        );
        
        getTabla().setListaValores(valores);
        
        
        getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(5, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(6, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(7, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(8, TextAlignment.RIGHT);
        
        
        
        getTabla().setListaDimensiones(13f, 25f, 8f, 8f, 8f, 8f, 8f, 10f, 12f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_ENTERO, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA_SIGNO);
        getTabla().procesarEscribir();
    }

    /**
     * Metodo para incluir notas del certificado.
     *
     */
    @Override
    public synchronized void elemento5() {
        String cuerpo = String.valueOf(getParametrosBusqueda().get("cuerpo"));
        String[] lineas = cuerpo.split(SALTO_PAGINA);
        for (String linea : lineas) {
            getP().setTexto(linea);
            getP().escribir();
        }
        getEspacio().escribir(3);
    }

    /**
     * Espacio para el atentamente
     *
     */
    @Override
    public synchronized void elemento6() {
        imprimirAtentamente();
    }
   

    /**
     * @param valores the valores to set
     */
    public void setValores(List<Object[]> valores) {
        this.valores = valores;
    }
}
