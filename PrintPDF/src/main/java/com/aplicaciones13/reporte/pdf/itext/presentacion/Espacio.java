package com.aplicaciones13.reporte.pdf.itext.presentacion;

import com.aplicaciones13.reporte.pdf.itext.texto.Elemento;

/**
 * Objeto para imprimir un espacio.
 *
 * @author omargo33@gmail.com
 *
 *
 */
public class Espacio extends Elemento {

    /**
     * Metodo para crear el objeto.
     *
     */
    public Espacio() {
        super();
        init();
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init() {
        setTexto("");
        getTexto().setFontSize(4);
        setParagraph(getTexto());
    }

    /** Metodo para escribir las repeticiones para escribir.
     * 
     * @param repeticiones 
     */
    public void escribir(int repeticiones) {
        for (int i = repeticiones; i > 0; i--) {
            super.escribir();
        }
    }
}
