/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.impresion;

import com.aplicaciones13.pdf.impresion.itext.ImpresionBaseElementos;
import com.aplicaciones13.pdf.impresion.itext.texto.Elemento;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.property.TextAlignment;

import java.util.List;

/**
 *
 * @author omarv
 */
public class ImpresionElementosLineaCredito extends ImpresionBaseElementos {

    private List<Object[]> valores;
    private List<Object[]> valoresSuma;

    private final String SALTO_PAGINA = "\n";

    /**
     * titulo
     */
    @Override
    public synchronized void elemento1() {
        getH1().setTextoCentro(mensajes.obtenerMensajeParametros("txt_002_01", getParametrosBusqueda().get("numeroLineaCredito")));
        getH1().escribir();
        getLineaSolida().escribir();
    }

    /**
     * Informacion socio
     */
    @Override
    public synchronized void elemento2() {
        getH3().setTexto(mensajes.obtenerMensaje("txt_002_02"));
        getH3().escribir();

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_002_03"),
                mensajes.obtenerMensaje("txt_002_04"),
                mensajes.obtenerMensaje("txt_002_05"),
                mensajes.obtenerMensaje("txt_002_06"),
                mensajes.obtenerMensaje("txt_002_07"),
                mensajes.obtenerMensaje("txt_002_08")
        );

        getForm().setListaValores(
                getParametrosBusqueda().get("socioNombre"),
                getParametrosBusqueda().get("socioIdentificacion"),
                getParametrosBusqueda().get("socioDireccion"),
                getParametrosBusqueda().get("socioLocalidad"),
                getParametrosBusqueda().get("socioTelefonos"),
                getParametrosBusqueda().get("socioCorreo")
        );

        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(4, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(5, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(6, TextAlignment.LEFT);
        getForm().setListaDimensiones(15f, 85f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().procesarEscribir();
        getLineaSolida().escribir();
    }

    /**
     * Informacion montos
     */
    @Override
    public synchronized void elemento3() {
        getH3().setTexto(mensajes.obtenerMensaje("txt_002_09"));
        getH3().escribir();

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_002_10"),
                mensajes.obtenerMensaje("txt_002_11"),
                mensajes.obtenerMensaje("txt_002_12")
        );

        getForm().setListaValores(
                getParametrosBusqueda().get("montoAprobado"),
                getParametrosBusqueda().get("montoUtilizado"),
                getParametrosBusqueda().get("montoDisponible")
        );

        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getForm().setListaDimensiones(18f, 15f, 18f, 15f, 15f, 18f);
        getForm().setListaFormatos(Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO);
        getForm().procesarEscribir();
        getLineaSolida().escribir();
    }

    /**
     * Informacion cortes
     */
    @Override
    public synchronized void elemento4() {
        getH3().setTexto(mensajes.obtenerMensaje("txt_002_13"));
        getH3().escribir();

        String cortePagoInmediato = getParametrosBusqueda().get("cortePagoInmediato");

        if (cortePagoInmediato != null && cortePagoInmediato.compareToIgnoreCase("true") == 0) {
            getH2().setTexto(mensajes.obtenerMensaje("txt_002_15"));
            getH2().escribir();
        }

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_002_16"),
                mensajes.obtenerMensaje("txt_002_17"),
                mensajes.obtenerMensaje("txt_002_18")
        );

        getForm().setListaValores(
                getParametrosBusqueda().get("corteFechaEmisión"),
                getParametrosBusqueda().get("corteFechaMáxima"),
                getParametrosBusqueda().get("corteTotalPagar")
        );

        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getForm().setListaDimensiones(18f, 15f, 18f, 15f, 15f, 18f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_MONEDA_SIGNO);
        getForm().procesarEscribir();

        getP().setTexto(mensajes.obtenerMensajeParametros("txt_002_19",
                getParametrosBusqueda().get("cortePeriodoInicio"),
                getParametrosBusqueda().get("cortePeriodoFin")
        ));
        getP().escribir();
        getLineaSolida().escribir();
    }

    /**
     * Elemento de detalle de la transaccion.
     *
     */
    @Override
    public synchronized void elemento5() {
        getH3().setTexto(mensajes.obtenerMensaje("txt_002_20"));
        getH3().escribir();

        if (valores != null && !valores.isEmpty()) {
            getTabla().setListaValores(valores);
            getTabla().setListaTitulos(
                    mensajes.obtenerMensaje("txt_002_21"),
                    mensajes.obtenerMensaje("txt_002_22"),
                    mensajes.obtenerMensaje("txt_002_23"),
                    mensajes.obtenerMensaje("txt_002_24"),
                    mensajes.obtenerMensaje("txt_002_25"),
                    mensajes.obtenerMensaje("txt_002_26"),
                    mensajes.obtenerMensaje("txt_002_27"),
                    mensajes.obtenerMensaje("txt_002_28"),
                    mensajes.obtenerMensaje("txt_002_95"),
                    mensajes.obtenerMensaje("txt_002_29"),
                    mensajes.obtenerMensaje("txt_002_30")
            );

            getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_ENTERO, Elemento.FORMATO_STRING,
                    Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE,
                    Elemento.FORMATO_STRING, Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE,
                    Elemento.FORMATO_DOUBLE);
            getTabla().setListaDimensiones(9f, 9f, 10f, 10f,   8f, 8f, 8f, 9f, 8f, 10f, 11f);                                          
            getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
            getTabla().getMapaAlineamiento().put(2, TextAlignment.CENTER);
            getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(5, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(6, TextAlignment.CENTER);
            getTabla().getMapaAlineamiento().put(7, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(8, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(9, TextAlignment.RIGHT);
            getTabla().getMapaAlineamiento().put(10, TextAlignment.RIGHT);
            getTabla().procesarEscribir();
            getLineaSolida().escribir();

            if (valoresSuma != null && !valoresSuma.isEmpty()) {
                getTabla().setSumatoria(true);
                getTabla().setListaTitulos();
                getTabla().setListaValores(valoresSuma);
                getTabla().setListaFormatos(Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE, Elemento.FORMATO_DOUBLE);
                getTabla().setListaDimensiones(39.6f, 41.6f, 8.5f, 10.3f);
                getTabla().getMapaAlineamiento().put(0, TextAlignment.RIGHT);
                getTabla().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
                getTabla().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
                getTabla().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
                getTabla().procesarEscribir();
                getLineaSolida().escribir();
            }
            elemento510();
        }
    }

    /**
     * Metodo para generar las sumatorias y dependen del elemento de detalle de
     * transaccion.
     */
    private void elemento510() {

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_002_31"),
                mensajes.obtenerMensaje("txt_002_32"),
                mensajes.obtenerMensaje("txt_002_33")
        );

        getForm().setListaValores(
                getParametrosBusqueda().get("totalNotificacion"),
                getParametrosBusqueda().get("totalCostosJudiciales"),
                getParametrosBusqueda().get("totalMora")
        );

        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);

        getForm().setListaFormatos(Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO, Elemento.FORMATO_MONEDA_SIGNO);
        getForm().setListaDimensiones(30f, 48f);
        getForm().procesarEscribir();

        getLineaSolida().escribir();

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_002_34"),
                mensajes.obtenerMensaje("txt_002_35"),
                mensajes.obtenerMensaje("txt_002_36")
        );

        getForm().setListaValores(
                getParametrosBusqueda().get("totalPagoExigible"),
                getParametrosBusqueda().get("totalValorRecomendado"),
                getParametrosBusqueda().get("totalPagar")
        );
        getForm().procesarEscribir();

    }

    /**
     * Metodo para escribir la nota de pagos
     */
    @Override
    public synchronized void elemento6() {
        getTexto().setTexto(mensajes.obtenerMensaje("txt_002_50"));
        getTexto().escribir();
        getTexto().setTexto(mensajes.obtenerMensaje("txt_002_51"));
        getTexto().escribir();
        getLineaSolida().escribir();
    }

    /**
     * Metodo para escribir el glosario de terminos
     */
    @Override
    public synchronized void elemento7() {
        if (getCurrentPosition().getY() <= 210) {
            getDocumento().add(new AreaBreak());
        }

        getTexto().setTexto(mensajes.obtenerMensaje("txt_002_60"));
        getTexto().escribir();
        getTexto().setTexto("");
        for (int i = 61; i <= 74; i++) {
            getTexto().addTexto(mensajes.obtenerMensaje("txt_002_" + i), mensajes.obtenerMensaje("txt_002_" + (i + 20)) + SALTO_PAGINA);
        }
        getTexto().escribir();
        getLineaSolida().escribir();
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(List<Object[]> valores) {
        this.valores = valores;
    }

    /**
     * @param valoresSuma the valores to set
     */
    public void setValoresSuma(List<Object[]> valoresSuma) {
        this.valoresSuma = valoresSuma;
    }
}
