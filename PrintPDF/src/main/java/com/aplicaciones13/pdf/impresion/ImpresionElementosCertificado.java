/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.impresion;

import com.aplicaciones13.pdf.impresion.itext.ImpresionBaseElementos;

/**
 * Objeto con los datos de impresiones certificado de socio.
 *
 * @author omargo33@gmail.com
 *
 */
public class ImpresionElementosCertificado extends ImpresionBaseElementos {
    private final String SALTO_PAGINA = "\n";
    /**
     * Imprime el primer elemento 2.
     *
     */
    @Override
    public synchronized void elemento2() {
        getLineaSolida().escribir();
        getEspacio().escribir(4);

        getH1().setTextoCentro(mensajes.obtenerMensaje("txt_001_01"));
        getH1().escribir();
        getEspacio().escribir(4);

        getP().setTexto(mensajes.obtenerMensaje("txt_001_02"));
        getP().escribir();
        getEspacio().escribir(2);

        getH2().setTextoCentro(mensajes.obtenerMensaje("txt_001_03"));
        getH2().escribir();        
        getEspacio().escribir(2);
        
        String cuerpo = String.valueOf(getParametrosBusqueda().get("cuerpo"));        
        String[] lineas = cuerpo.split(SALTO_PAGINA);
        for (String linea : lineas) {
            getP().setTexto(linea);
            getP().escribir();
        }        
        getEspacio().escribir(3);
        
        getP().setTexto(mensajes.obtenerMensaje("txt_001_04"));
        getP().escribir();
        
        imprimirAtentamente();
    }
}
