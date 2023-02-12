package com.aplicaciones13.pdf.impresion.itext.texto;

import com.aplicaciones13.pdf.impresion.itext.ImpresionBaseElementos;

import com.aplicaciones13.pdf.utilidades.Mensaje;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.swing.text.InternationalFormatter;

/**
 * Clase con los datos esenciales para la escritura del archivo PDF.
 *
 * @author omargo33@gmail.com
 *
 *
 */
@Slf4j
public class Elemento {

    /**
     * Manejo de mensajes.
     */
    Mensaje mensajes = new Mensaje(ImpresionBaseElementos.NOMBRE_APLICACION);

    public static final String FORMATO_STRING = "1"; //Formato String
    public static final String FORMATO_FECHA = "2"; //Formato fecha
    public static final String FORMATO_MONEDA = "3"; //Formato moneda 
    public static final String FORMATO_MONEDA_SIGNO = "4"; //Formato moneda
    public static final String FORMATO_DOUBLE = "5";//Formato double
    public static final String FORMATO_FECHA_HORA = "6"; //Formato fecha y hora
    public static final String FORMATO_ENTERO = "7"; // Formato entero

    private PdfFont fontTitulos;
    private PdfFont fontDatos;
    private Text texto;
    private Paragraph paragraph;

    public static final String REGULAR
            = "LiberationSans-Regular.ttf";
    public static final String ITALIC
            = "LiberationSans-Italic.ttf";
    public static final String BOLDITALIC
            = "LiberationSans-BoldItalic.ttf";
    public static final String BOLD
            = "LiberationSans-Bold.ttf";

    /**
     * Metodo para crear el objeto.
     *
     */
    public Elemento() {
        initBase();
    }

    /**
     * Metodo para inicializar los objetos utilizados.
     *
     */
    private void initBase() {
        try {
            FontProgram fontProgram = FontProgramFactory.createFont(REGULAR);
            PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.PDF_DOC_ENCODING, false);
            setFontDatos(pdfFont);
        } catch (IOException ex) {
            log.error(".init() 1  {}", ex);
        }
        try {
            FontProgram fontProgram = FontProgramFactory.createFont(BOLD);
            PdfFont pdfFont = PdfFontFactory.createFont(fontProgram, PdfEncodings.PDF_DOC_ENCODING, false);
            setFontTitulos(pdfFont);
        } catch (IOException ex) {            
            log.error(".init() 2  {}", ex);
        }
        setParagraph(new Paragraph(""));
        getParagraph().setFont(getFontDatos());
        setTexto(new Text(""));
    }

    /**
     * Metodo para dar formato de muestra a los datos basicos que el sistema
     * utiliza.
     *
     * @param value
     * @param tipoFormato
     * @return
     */
    public static String datoFormatoManual(Object value, String tipoFormato) {
        String respuesta = "";

        if (value == null) {
            return respuesta;
        }

        switch (tipoFormato) {
            case FORMATO_ENTERO:
                try {
                Double doubleTemp = Double.valueOf(value.toString());
                respuesta = formatearInt(doubleTemp);
            } catch (NumberFormatException e) {
                respuesta = formatearInt(0f);
            }
            break;
            case FORMATO_DOUBLE:
          try {
                Double doubleTemp = Double.valueOf(value.toString());
                respuesta = formatearDouble(doubleTemp);
            } catch (NumberFormatException e) {
                respuesta = formatearDouble(0f);
            }
            break;
            case FORMATO_FECHA:
                respuesta = fechaFormateada("yyyy-MM-dd", (java.util.Date) value);
                break;
            case FORMATO_FECHA_HORA:
                respuesta = fechaFormateada("yyyy-MM-dd HH:mm:ss", (java.util.Date) value);
                break;
            case FORMATO_MONEDA:
                try {
                Double doubleTemp = Double.valueOf(value.toString());
                respuesta = formatearDinero(doubleTemp);
            } catch (NumberFormatException e) {
                respuesta = formatearDinero(0f);
            }
            break;

            case FORMATO_MONEDA_SIGNO:
                try {
                Double doubleTemp = Double.valueOf(value.toString());
                respuesta = formatearDineroSigno(doubleTemp);
            } catch (NumberFormatException e) {
                respuesta = formatearDineroSigno(0f);
            }

            break;

            case FORMATO_STRING:
                respuesta = value.toString();
                break;

            default:
                respuesta = "";

        }
        return respuesta;
    }

    /**
     * Formato para las fechas.
     *
     * @param formato
     * @param fecha
     * @return
     */
    public static String fechaFormateada(String formato, Date fecha) {
        SimpleDateFormat miFechaFormato = new SimpleDateFormat(formato);
        return miFechaFormato.format(fecha);
    }

    /**
     * Formato del dinero o moneda que se esta utilizando.
     *
     * @param importe
     * @return
     */
    protected static String formatearDinero(double importe) {
        DecimalFormat df2
                = new DecimalFormat("###,##0.00;(###,##0.00)", new DecimalFormatSymbols(new Locale("US")));
        return df2.format(importe);
    }

    /**
     *
     * @param importe
     * @return
     */
    protected static String formatearDineroSigno(double importe) {
        DecimalFormat df2
                = new DecimalFormat("'$' ###,##0.00;('$' ###,##0.00)",
                        new DecimalFormatSymbols(new Locale("US")));
        return df2.format(importe);

    }

    /**
     * Formato de un valor decimal que se este utilizando.
     *
     * @param importe
     * @return
     */
    protected static String formatearDouble(double importe) {
        String respuesta = null;
        InternationalFormatter format
                = new InternationalFormatter(new java.text.DecimalFormat("##0.00"));
        try {
            respuesta = format.valueToString(importe);
        } catch (ParseException e) {            
            log.error("ec.fin.jardinazuayo.pi16001.impresion.itext.texto.formatearDouble()", e);
        }
        return respuesta;
    }

    /**
     * Formato de un valor decimal que se este utilizando.
     *
     * @param importe
     * @return
     */
    protected static String formatearInt(double importe) {
        String respuesta = null;
        InternationalFormatter format
                = new InternationalFormatter(new java.text.DecimalFormat("###"));
        try {
            respuesta = format.valueToString(importe);
        } catch (ParseException e) {            
            log.error("formatearInt() {}", e);
        }
        return respuesta;
    }

    /**
     * @return
     */
    public Document getDocumento() {
        return null;
    }

    /**
     * @return
     */
    public PdfFont getFontTitulos() {
        return this.fontTitulos;
    }

    /**
     * @param fontTitulos
     */
    public void setFontTitulos(PdfFont fontTitulos) {
        this.fontTitulos = fontTitulos;
    }

    /**
     * @return
     */
    public PdfFont getFontDatos() {
        return this.fontDatos;
    }

    /**
     * @param fontDatos
     */
    public void setFontDatos(PdfFont fontDatos) {
        this.fontDatos = fontDatos;
    }

    /**
     * @return
     */
    public Paragraph getParagraph() {
        return this.paragraph;
    }

    /**
     * @param paragraph
     */
    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    /**
     * @param texto
     * @param font
     */
    public void setParagraph(String texto, PdfFont font) {
        this.paragraph = new Paragraph(texto);
        this.paragraph.setFont(font);
    }

    /**
     * @param texto
     * @param font
     */
    public void setParagraph(Text texto, PdfFont font) {
        this.paragraph = new Paragraph(texto);
        this.paragraph.setFont(font);
    }

    /**
     * @param texto
     *
     */
    public void setParagraph(Text texto) {
        this.paragraph = new Paragraph(texto);
    }

    /**
     * @param texto
     *
     */
    public void setParagraph(String texto) {
        this.paragraph = new Paragraph(texto);
    }

    /**
     * @param texto
     * @param font
     */
    public void setParagraphCapital(String texto, PdfFont font) {
        this.paragraph = new Paragraph(titulo(texto));
        this.paragraph.setFont(font);

    }

    /**
     * Metodo para convertir JUAN PEREZ a Juan Perez y/o Juan_perez a Juan
     * Perez.
     *
     * @param nombre
     * @return
     */
    private static String titulo(String nombre) {

        if (nombre != null && nombre.trim().length() > 1) {
            String respuesta = "";
            nombre = nombre.replaceAll("\\_{1}", " ").trim();

            if (nombre.startsWith("@")) {
                return nombre.replaceFirst("@", "");
            }

            StringTokenizer tokens = new StringTokenizer(nombre);
            while (tokens.hasMoreTokens()) {
                String dataTemp = tokens.nextToken();
                respuesta
                        = respuesta.concat(" " + dataTemp.substring(0, 1).toUpperCase()
                                + dataTemp.substring(1,
                                        dataTemp.length()).toLowerCase());
            }
            return respuesta.trim();
        }
        return (nombre == null) ? "." : nombre.trim().toUpperCase();
    }

    /**
     * @return the texto
     */
    public Text getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(Text texto) {
        this.texto = texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto.setText(texto);
    }

    /**
     * Escribir objeto.
     *
     */
    public void escribir() {
        getDocumento().add(getParagraph());
    }
}
