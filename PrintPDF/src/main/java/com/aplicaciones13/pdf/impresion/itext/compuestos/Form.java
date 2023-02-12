/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.impresion.itext.compuestos;

import com.aplicaciones13.pdf.impresion.itext.texto.P;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Objeto Para escribir en forma de un formulario.
 *
 * @author omargo33@gmail.com
 *
 *
 */
@Slf4j
public class Form extends Conjunto {

    /**
     * Lista de valores de la forma.
     */
    List<Object> listaValores;
    
    /**
     * Metodo que crea la clase.
     *
     */
    public Form() {
        super();
        init();
    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void init() {
        listaValores = new ArrayList<>();
    }

    /**
     * Metodo para generar la tabla de presentacion.
     *
     */
    public void procesar() {
        if (getListaFormatos().size() != this.listaValores.size()) {
            log.info(this.getClass().getName(),".procesar()");            
            return;
        }

        setTabla(new Table(getArrayDimensiones()));
        int i = 0;
        for (Object obj : listaValores) {
            P pTitulo = new P(getListaTitulos().get(i), P.TEXTO);            
            pTitulo.negrita();            
            Cell cellTitulo = new Cell();
            cellTitulo.add(pTitulo.getParagraph());
            cellTitulo.setBorder(Border.NO_BORDER);
            cellTitulo.setTextAlignment(TextAlignment.LEFT);
            cellTitulo.setVerticalAlignment(VerticalAlignment.MIDDLE);
            getTabla().addCell(cellTitulo);

            P pDato = new P(datoFormatoManual(obj, getListaFormatos().get(i)),P.TEXTO);
            Cell cellValor = new Cell();
            cellValor.add(pDato.getParagraph());
            cellValor.setBorder(Border.NO_BORDER);
            cellValor.setTextAlignment(getAlineamientoColumna(i+1, TextAlignment.LEFT));
            cellValor.setVerticalAlignment(VerticalAlignment.MIDDLE);
            getTabla().addCell(cellValor);
            i++;
        }        
    }

    /**
     * Metodo para ingresar los datos en la tabla correcta.
     *
     * Pone el formato al nombre del campo. Pone el alineamiento al dato. Pone
     * el formato al dato.
     *
     */
    /**
     * Metodo para asignar numeros de columanas.
     *
     * @param valor
     */
    public void setListaValores(Object... valor) {
        listaValores = new ArrayList<>();
        listaValores.addAll(Arrays.asList(valor));
    }    
}