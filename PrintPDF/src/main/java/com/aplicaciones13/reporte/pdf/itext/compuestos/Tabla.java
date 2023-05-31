package com.aplicaciones13.reporte.pdf.itext.compuestos;

import com.aplicaciones13.reporte.pdf.itext.texto.P;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import java.util.List;

/**
 * Objeto presentar una tabla.
 *
 * @author omargo33@gmail.com
 *
 */
@Slf4j
public class Tabla extends Conjunto {

    private List<Object[]> listaValores;
    private boolean sumatoria=false;

    /**
     * Metodo para crear la clase. Inicializa SQLBase Limpia datos de la tabla.
     */
    public Tabla() {
        super();
        init();
    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void init() {
        this.listaValores = new ArrayList<>();
    }

    /**
     * Metodo de escritura de una tabla.Obtiene en numero de columnas Si no
     * estan formateadas todas las columnas Notifica Retorna Si no estan
     * dimensionadas todas las columnas Notifica Retorna Si no hay datos Retorna
     * Se agrega las columnas que puede totalizar Se crea la tabla, se pone
     * dimesiones, alineamiento y encabezado Se verifica si hay encabezados De
     * haber encabezados se los escribe Se llena los datos de las tablas Si hay
     * sumatorias se las realiza.
     *
     * Se muestra las sumatorias de haberlas
     *
     */
    @Override
    public void procesar() {
        if (getListaDimensiones().size() != getListaFormatos().size()) {
            log.info("No estan formateadas todas las columnas");
            return;
        }

        setTabla(new Table(getArrayDimensiones()));

        for (String a : getListaTitulos()) {
            P pTitulo = new P(a, P.TEXTO);
            pTitulo.negrita();
            Cell cell = new Cell();
            cell.add(pTitulo.getParagraph());
            cell.setTextAlignment(TextAlignment.CENTER);
            cell.setBorderLeft(Border.NO_BORDER);
            cell.setBorderRight(Border.NO_BORDER);
            cell.setBorderTop(Border.NO_BORDER);
            getTabla().addHeaderCell(cell);
        }

        for (Object[] fila : listaValores) {
            int columna = 0;
            for (Object celda : fila) {
                P pValor = new P(datoFormatoManual(celda, getListaFormatos().get(columna)), P.TEXTO);
                if (isSumatoria()) {
                    pValor.negrita();
                }
                Cell cell = new Cell();
                cell.add(pValor.getParagraph());
                cell.setBorder(Border.NO_BORDER);
                cell.setTextAlignment(getAlineamientoColumna(columna, TextAlignment.LEFT));
                getTabla().addCell(cell);
                columna++;
            }
        }
    }

    /**
     * Metodo para procesar con margenes de la tabla.
     * 
     */
    private void procesarMargenes() {
        if (getListaDimensiones().size() != getListaFormatos().size()) {
            log.error(".tabla()");
            return;
        }

        setTabla(new Table(getArrayDimensiones()));

        for (String a : getListaTitulos()) {
            P pTitulo = new P(a, P.TEXTO);
            pTitulo.negrita();
            Cell cell = new Cell();
            cell.add(pTitulo.getParagraph());
            cell.setTextAlignment(TextAlignment.LEFT);
            /*cell.setBorderLeft(Border.SOLID);
            cell.setBorderRight(Border.SOLID);
            cell.setBorderTop(Border.SOLID);*/
            getTabla().addHeaderCell(cell);
        }

        for (Object[] fila : listaValores) {
            int columna = 0;
            for (Object celda : fila) {
                P pValor = new P(datoFormatoManual(celda, getListaFormatos().get(columna)), P.TEXTO);
                if (isSumatoria()) {
                    pValor.negrita();
                }
                Cell cell = new Cell();
                cell.add(pValor.getParagraph());
                //cell.setBorder(Border.SOLID);
                cell.setTextAlignment(getAlineamientoColumna(columna, TextAlignment.LEFT));
                getTabla().addCell(cell);
                columna++;
            }
        }
    }

    /**
     * Metodo para procesar y escribir en el pdf.
     * 
     */
    public void procesarMargenesEscribir() {
        procesarMargenes();
        getDocumento().add(getTabla());
    }

    /**
     * @param listaValores the listaValores to set
     */
    public void setListaValores(List<Object[]> listaValores) {
        this.listaValores = listaValores;
    }

    /**
     * @return the sumatoria
     */
    public boolean isSumatoria() {
        return sumatoria;
    }

    /**
     * @param sumatoria the sumatoria to set
     */
    public void setSumatoria(boolean sumatoria) {
        this.sumatoria = sumatoria;
    }
}
