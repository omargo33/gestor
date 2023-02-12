/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.worksheet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;

import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;

import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.DateTime;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase para motor de creacion de paginas ods.
 *
 * @author omargo33@gmail.com
 *
 */
@Slf4j
public class HojaCalculoEngine {

    private OutputStream outputStream;
    private WritableWorkbook workbook;
    private String nombreHojaActiva;
    private WritableCellFormat formatoH1;
    private WritableCellFormat formatoH2;
    private WritableCellFormat formatoH2Left;
    private WritableCellFormat formatoH3;
    private WritableCellFormat formatoP;
    private WritableCellFormat formatoPEntero;
    private WritableCellFormat formatoPDecimal;
    private WritableCellFormat formatoPFecha;
    private WritableCellFormat formatoPWrap;
    private WritableCellFormat formatoPStrong;
    private WritableCellFormat formatoPStrongEntero;
    private WritableCellFormat formatoPStrongDecimal;
    private WritableCellFormat formatoPStrongFecha;

    /**
     * Titulo
     */
    public static final int H1 = 0;
    /**
     * Sub Titulo
     */
    public static final int H2 = 1;
    
    /**
     * Sub Titulo
     */
    public static final int H2_LEFT = 101;   
    
    /**
     * Sub Titulo formulario
     */
    public static final int H2_FORMUAL = 10;
    /**
     * Sub Titulo formulario
     */
    public static final int H3 = 11;
    /**
     * Parrafo
     */
    public static final int P = 2;
    /**
     * Parrafo entero
     */
    public static final int P_ENTERO = 21;
    /**
     * Parrafo decimal
     */
    public static final int P_DECIMAL = 22;
    /**
     * Parrafo fecha
     */
    public static final int P_FECHA = 23;
    /**
     * Parrafo formula
     */
    public static final int P_FORMULA = 24;
    /**
     * Parrafo wrap
     */
    public static final int P_WRAP = 25;
    /**
     * Parrafo negrito
     */
    public static final int P_STRONG = 3;
    /**
     * Parrafo negrito entero
     */
    public static final int P_STRONG_ENTERO = 31;
    /**
     * Parrafo negrito decimal
     */
    public static final int P_STRONG_DECIMAL = 32;
    /**
     * Parrafo negrito fecha
     */
    public static final int P_STRONG_FECHA = 33;
    /**
     * Parrafo negrito formula
     */
    public static final int P_STRONG_FORMULA = 34;

    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

    /**
     * Metodo para crear el objeto.
     *
     * @param outputStream
     */
    public HojaCalculoEngine(OutputStream outputStream) {
        WorkbookSettings workbookSettings = new WorkbookSettings();
        workbookSettings.setLocale(new Locale("es", "ES"));
        this.outputStream = outputStream;
        try {
            this.workbook = Workbook.createWorkbook(this.outputStream, workbookSettings);
        } catch (IOException e) {
            log.error(".HojaCalculo() {}",e);
        }
        inicializarFormatos();
    }

    /**
     * Agrega una hoja.
     *
     * @param nombreHoja
     */
    public void addSheet(String nombreHoja) {
        getWorkbook().createSheet(nombreHoja, getWorkbook().getNumberOfSheets());
        setNombreHojaActiva(nombreHoja);
    }

    /**
     * Metodo para agregar espacios en blanco.
     *
     * @param mensaje
     * @param espaciosIzquerda
     * @param espaciosDerecha
     * @return
     */
    public static String agregaEspaciosBlanco(String mensaje, int espaciosIzquerda, int espaciosDerecha) {
        if ((mensaje == null) || mensaje.isEmpty()) {
            return "";
        }

        String formatoIzquierda = "%" + espaciosIzquerda + "s%s";
        String formatoDerecha = "%s%" + espaciosDerecha + "s";
        mensaje = mensaje.trim();
        mensaje = String.format(formatoIzquierda, " ", mensaje);
        mensaje = String.format(formatoDerecha, mensaje, " ");
        return mensaje;
    }

    /**
     * Convierte fecha.
     * 
     * @param fecha
     * @return 
     */
    private Date dateConvert(String fecha) {
        Date date = new Date();        
        try {
            date = new SimpleDateFormat(DATE_FORMAT).parse(fecha);
        } catch (ParseException ex) {
            log.error(".dateConvert() {}",ex);            
        }
        return date;
    }

    /**
     * Metodo para iniciarlizar formatos.
     *
     */
    private void inicializarFormatos() {
        WritableFont wfh1 = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
        WritableFont wfh2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableFont wfh3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableFont wfp = new WritableFont(WritableFont.ARIAL, 9);
        WritableFont wfpStrong = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD);
        NumberFormat numberFormatDecimal = new NumberFormat("#,##0.00");
        NumberFormat numberFormatEntera = new NumberFormat("#");
        DateFormat fechaFormat = new DateFormat(DATE_FORMAT);

        try {
            formatoH1 = new WritableCellFormat(wfh1);
            formatoH1.setAlignment(Alignment.CENTRE);
            formatoH1.setVerticalAlignment(VerticalAlignment.CENTRE);

            wfh2.setColour(Colour.WHITE);
            formatoH2 = new WritableCellFormat(wfh2);
            formatoH2.setAlignment(Alignment.CENTRE);
            formatoH2.setVerticalAlignment(VerticalAlignment.CENTRE);
            formatoH2.setBackground(Colour.GREEN);
            
            
            formatoH2Left = new WritableCellFormat(wfh2);
            formatoH2Left.setAlignment(Alignment.LEFT);
            formatoH2Left.setVerticalAlignment(VerticalAlignment.CENTRE);
            formatoH2Left.setBackground(Colour.GREEN);

            formatoH3 = new WritableCellFormat(wfh3);
            formatoH3.setAlignment(Alignment.CENTRE);
            formatoH3.setVerticalAlignment(VerticalAlignment.CENTRE);

            formatoP = new WritableCellFormat(wfp);
            formatoP.setVerticalAlignment(VerticalAlignment.TOP);

            formatoPEntero = new WritableCellFormat(wfp, numberFormatEntera);
            formatoPEntero.setVerticalAlignment(VerticalAlignment.TOP);
            formatoPDecimal = new WritableCellFormat(wfp, numberFormatDecimal);
            formatoPDecimal.setVerticalAlignment(VerticalAlignment.TOP);
            formatoPFecha = new WritableCellFormat(wfp, fechaFormat);
            formatoPFecha.setVerticalAlignment(VerticalAlignment.TOP);
            formatoPFecha.setAlignment(Alignment.LEFT);

            formatoPWrap = new WritableCellFormat(wfp);
            formatoPWrap.setVerticalAlignment(VerticalAlignment.TOP);
            formatoPWrap.setWrap(true);

            formatoPStrong = new WritableCellFormat(wfpStrong);
            formatoPStrong.setVerticalAlignment(VerticalAlignment.TOP);

            formatoPStrongEntero = new WritableCellFormat(wfpStrong, numberFormatEntera);
            formatoPStrongEntero.setVerticalAlignment(VerticalAlignment.TOP);

            formatoPStrongDecimal = new WritableCellFormat(wfpStrong, numberFormatDecimal);
            formatoPStrongDecimal.setVerticalAlignment(VerticalAlignment.TOP);

            formatoPStrongFecha = new WritableCellFormat(wfpStrong, fechaFormat);
            formatoPStrongFecha.setVerticalAlignment(VerticalAlignment.TOP);
        } catch (WriteException e) {
            log.error(".inicializarFormatos() {}", e.toString());
        }
    }

    /**
     * Metodo para agregar un valor a una celda, conformato.
     *
     * @param column
     * @param row
     * @param valor
     * @param formato
     */
    public void addValorCelda(int column, int row, Object valor, int formato) {
        try {
            valor = valor == null ? "" : valor;
            switch (formato) {
                case H1:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoH1));
                    break;
                case H2:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoH2));
                    break;                    
                case H2_LEFT:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoH2Left));
                    break;                   
                    
                case H3:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoH3));
                    break;
                case P:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoP));
                    break;
                case P_ENTERO:
                    getHojaActual().addCell(new Number(column, row, Integer.parseInt(valor.toString()), formatoPEntero));
                    break;
                case P_DECIMAL:
                    getHojaActual().addCell(new Number(column, row, Double.parseDouble(valor.toString()), formatoPDecimal));
                    break;
                case P_FECHA:
                    getHojaActual().addCell(new DateTime(column, row, dateConvert(valor.toString()), formatoPFecha));
                    break;
                case P_WRAP:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoPWrap));
                    break;
                case P_FORMULA:
                    getHojaActual().addCell(new Formula(column, row, valor.toString(), formatoP));
                    break;
                case P_STRONG:
                    getHojaActual().addCell(new Label(column, row, valor.toString(), formatoPStrong));
                    break;
                case P_STRONG_ENTERO:
                    getHojaActual().addCell(new Number(column, row, Integer.parseInt(valor.toString()), formatoPStrongEntero));
                    break;
                case P_STRONG_DECIMAL:
                    getHojaActual().addCell(new Number(column, row, Double.parseDouble(valor.toString()), formatoPStrongDecimal));
                    break;
                case P_STRONG_FECHA:
                    getHojaActual().addCell(new DateTime(column, row, dateConvert(valor.toString()), formatoPStrongFecha));
                    break;
                case P_STRONG_FORMULA:
                    getHojaActual().addCell(new Formula(column, row, valor.toString(), formatoPStrong));
                    break;

                default:
                log.error(".addValorCelda() {}{}", "No existe el formato",formato);
                    break;
            }
        } catch (WriteException e) {
            log.error(".addValorCelda() {}{}", e.toString(), valor);
        }
    }

    /**
     * Metodos para poner espacios a las celdas.
     *
     * @param columnaInicial
     * @param columnaFinal
     */
    public void espaciosCeldas(int columnaInicial, int columnaFinal) {
        for (int x = columnaInicial; x < columnaFinal; x++) {
            CellView cell = getHojaActual().getColumnView(x);
            cell.setAutosize(true);
            getHojaActual().setColumnView(x, cell);
        }
    }

    /**
     * Metodo para combinar celdas.
     *
     * @param x
     * @param y
     * @param x1
     * @param y1
     */
    public void combinarCeldas(int x, int y, int x1, int y1) {
        try {
            getHojaActual().mergeCells(x, y, x1, y1);
        } catch (WriteException e) {
            log.error(".combinarCeldas() {}", e.toString());
        }
    }

    /**
     * Metodo de ancho de fila.
     *
     * @param fila
     * @param formato
     */
    public void anchoFila(int fila, int formato) {
        int alto = 20 * 20;

        switch (formato) {
            case H1:
                alto = 26 * 20;
                break;
            case H2:
                alto = 24 * 20;
                break;

            default:
                log.error(".anchoFila() {}{}", "No existe el formato",formato);
                break;
        }

        try {
            getHojaActual().setRowView(fila, alto);
        } catch (WriteException e) {
            log.error(".anchoFila()", e.toString());
        }
    }

    /**
     * Metodo para cerrar el libro.
     *
     */
    public void cerrarLibro() {
        try {
            getWorkbook().write();
            getWorkbook().close();
        } catch (IOException | WriteException ex) {
            log.error("cerrarLibro()", ex);
        }
    }

    /**
     * Obtiene la hoja de calculo actual.
     * 
     * @return 
     */
    public WritableSheet getHojaActual() {
        return getWorkbook().getSheet(getNombreHojaActiva());
    }

    public String getNombreHojaActiva() {
        return nombreHojaActiva == null ? "" : nombreHojaActiva;
    }

    public void setNombreHojaActiva(String nombreHojaActiva) {
        this.nombreHojaActiva = nombreHojaActiva;
    }

    public WritableWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(WritableWorkbook workbook) {
        this.workbook = workbook;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
