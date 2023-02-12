package com.aplicaciones13.pdf.impresion.itext;

import com.aplicaciones13.pdf.impresion.itext.compuestos.Form;
import com.aplicaciones13.pdf.impresion.itext.compuestos.Panel;
import com.aplicaciones13.pdf.impresion.itext.compuestos.Tabla;
import com.aplicaciones13.pdf.impresion.itext.imagen.Imagen;
import com.aplicaciones13.pdf.impresion.itext.imagen.ImagenCodigoQR;
import com.aplicaciones13.pdf.impresion.itext.presentacion.Espacio;
import com.aplicaciones13.pdf.impresion.itext.presentacion.Linea;
import com.aplicaciones13.pdf.impresion.itext.texto.Elemento;
import com.aplicaciones13.pdf.impresion.itext.texto.P;
import com.aplicaciones13.pdf.impresion.itext.texto.Titulo;
import com.aplicaciones13.pdf.utilidades.Mensaje;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import com.itextpdf.layout.element.Table;

/**
 * Clase base para la generación de elementos.
 *
 *
 * @author omargo33@gmail.com
 *
 */
@Slf4j
public class ImpresionBaseElementos {

    /**
     * Nombre aplicacion.
     */
    public static final String NOMBRE_APLICACION = "pi16001-front";
    /**
     * Elemento para generar los mensajes.
     */
    protected Mensaje mensajes = new Mensaje(NOMBRE_APLICACION);

    private float margenSuperiorOriginal;
    private int[] ordenElementos;
    private Map<String, String> parametrosBusqueda;
    private Document documento;
    private Espacio espacio;
    private Form form;
    private Titulo h1;
    private Titulo h2;
    private Titulo h3;
    private Imagen imagen;
    private ImagenCodigoQR imagenCodigoQR;
    private Linea lineaSolida;
    private Linea lineaPunteada;
    private P p;
    private P nota;
    private P texto;
    private Tabla tabla;    
    private PdfWriter pdfWriter;
    private Panel panel;

    /**
     * Metodo para crear el objeto.
     *
     */
    public ImpresionBaseElementos() {
        
        init();
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init() {
        setMargenSuperiorOriginal(0f);
        setEspacio(new Espacio() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setP(new P(P.PARRAFO) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setTexto(new P(P.TEXTO) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setNota(new P(P.NOTA) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setH1(new Titulo(Titulo.H1) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setH2(new Titulo(Titulo.H2) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setH3(new Titulo(Titulo.H3) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setLineaSolida(new Linea(Linea.LINEA_SOLIDA) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setLineaPunteada(new Linea(Linea.LINEA_PUNTEADA) {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setImagen(new Imagen() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setImagenCodigoQR(new ImagenCodigoQR() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setForm(new Form() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setTabla(new Tabla() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setPanel(new Panel() {
            @Override
            public Document getDocumento() {
                return getDocumentoPadre();
            }
        });

        setParametrosBusqueda(new HashMap<>());
        setPdfWriter(null);
    }

    /**
     * Escribir los datos en el documento.
     *
     * Fija los tamaños de la hoja Fija los marjenes de la hoja Fija el
     * encabezado y pie de pagina membretado. Pone el titulo del documento.
     *
     * Lla los elementos a ser impresos.
     *
     */
    public void escribir() {
        for (int i = 0; i < ordenElementos.length; i++) {
            imprimirElemento(ordenElementos[i]);
        }
    }

    /**
     * Metod para imprimir los elementos en el orden solicitado.
     *
     * @param valor
     */
    public void imprimirElemento(int valor) {

        switch (valor) {
            case 0:
                elemento0();
                break;
            case 1:
                elemento1();
                break;

            case 2:
                elemento2();
                break;

            case 3:
                elemento3();
                break;
                
              case 30:
                elemento30();
                break;

            case 4:
                elemento4();
                break;

            case 5:
                elemento5();
                break;
            case 6:
                elemento6();
                break;
           case 7:
                elemento7();
                break;
            default:
                log.error(".imprimirElemento() {}{}", "elemento no exite ", valor);
        }
    }

    /**
     * Metodo para imprimir el elemento 0.
     *
     * El elemento 0 es para calcular el espacio de firma y un salto de pagina
     * para que se ve en espacio correcto.
     *
     */
    public synchronized void elemento0() {
        if (getCurrentPosition().getY() < 120) {
            getDocumento().add(new AreaBreak());
        }
        getLineaSolida().escribir();
        getH3().setTexto(mensajes.obtenerMensaje("txt_000_01"));
        getH3().escribir();
    }

    /**
     * Metodo para imprimir el elemento 1.
     *
     * Datos de scaneo y documentacion electronica.
     *
     */
    public synchronized void elemento1() {
        if (getCurrentPosition().getY() < 150) {
            getDocumento().add(new AreaBreak());
        }
        getH3().setTexto(mensajes.obtenerMensaje("txt_000_02"));
        getH3().escribir();

        getForm().setListaTitulos(
                mensajes.obtenerMensaje("txt_000_03"),
                mensajes.obtenerMensaje("txt_000_04"),
                mensajes.obtenerMensaje("txt_000_05"));
        getForm().setListaValores(getParametrosBusqueda().get("documentoCodigo"), getParametrosBusqueda().get("sitioWeb"), mensajes.obtenerMensajeParametros("txt_000_07", getParametrosBusqueda().get("documentoValidez")));

        getForm().setListaDimensiones(10f, 90f);
        getForm().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getForm().procesar();

        escribirQR(getForm().getTabla());
    }

    /**
     * Metodo para escribir codigo QR
     *
     * @param table
     */
    public void escribirQR(Table table) {
        getImagenCodigoQR().setAncho(55f);
        getImagenCodigoQR().getTexto().setText((String) getParametrosBusqueda().get("documentoURL"));
        getImagenCodigoQR().procesar();

        Cell cell = new Cell();
        Border bol = new SolidBorder(30f);
        cell.setBorder(bol);
        cell.add(getImagenCodigoQR().getImagen());

        getPanel().setListaDimensiones(10f, 90f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.CENTER);
        getPanel().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getPanel().setListaCeldas(cell, table);
        getPanel().procesarEscribir();
    }

    /**
     * Metodo para imprimier mensaje de atentamente.
     *
     */
    public void imprimirAtentamente() {
        if (getCurrentPosition().getY() < 280) {
            getDocumento().add(new AreaBreak());
        }
        getEspacio().escribir(3);
        getP().setTexto(mensajes.obtenerMensajeParametros("txt_001_05",
                getParametrosBusqueda().get("documentoSucursal"),
                getParametrosBusqueda().get("fechaEmision")));
        getP().escribir();

        getEspacio().escribir(4);
        getP().setTexto(mensajes.obtenerMensaje("txt_001_06"));
        getP().escribir();

        getP().setTexto(mensajes.obtenerMensaje("txt_001_07"));
        getP().escribir();

        getEspacio().escribir(2);
        getLineaSolida().escribir();
    }

    /**
     * Metodo para imprimir el elemento 2.
     *
     */
    public synchronized void elemento2() {
        log.error(".elemento2()");
    }

    /**
     * Metodo para imprimir el elemento 3.
     *
     */
    public synchronized void elemento3() {
        log.error(".elemento2()");
    }
    
    /**
     * Metodo para imprimir el elemento 3.
     *
     */
    public synchronized void elemento30() {
        log.error(".elemento30()");
    }

    /**
     * Metodo para imprimir el elemento 4.
     *
     */
    public synchronized void elemento4() {
        log.error(".elemento4()");
    }

    /**
     * Metodo para imprimir el elemento 5.
     *
     */
    public synchronized void elemento5() {
        log.error(".elemento5()");
    }

    /**
     * Metodo para imprimir el elemento 6.
     *
     */
    public synchronized void elemento6() {
        log.error(".elemento6()");
    }
    
    
    /**
     * Metodo para imprimir el elemento 6.
     *
     */
    public synchronized void elemento7() {
        log.error(".elemento7()");
    }
    
    // Propiedades
    /**
     * @return
     */
    public Document getDocumento() {
        return this.documento;
    }

    /**
     * @return
     */
    public Document getDocumentoPadre() {
        return this.documento;
    }

    /**
     * @param documento
     */
    public void setDocumento(Document documento) {
        this.documento = documento;
        init();
    }

    /**
     * @return
     */
    public Map<String, String> getParametrosBusqueda() {
        return this.parametrosBusqueda;
    }

    /**
     * @param codigosConsulta
     */
    public void setParametrosBusqueda(Map<String, String> codigosConsulta) {
        this.parametrosBusqueda = codigosConsulta;
    }

    /**
     * @return
     */
    public Espacio getEspacio() {
        return this.espacio;
    }

    /**
     * @param espacio
     */
    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    /**
     * @return
     */
    public P getP() {
        return this.p;
    }

    /**
     * @param p
     */
    public void setP(P p) {
        this.p = p;
    }

    /**
     * @return
     */
    public PdfWriter getPdfWriter() {
        return this.pdfWriter;
    }

    /**
     * @param pdfWriter
     */
    public void setPdfWriter(PdfWriter pdfWriter) {
        this.pdfWriter = pdfWriter;
    }

    /**
     * @param ordenElementos the ordenElementos to set
     */
    public void setOrdenElementos(int[] ordenElementos) {
        this.ordenElementos = ordenElementos;
    }

    /**
     * @return the h1
     */
    public Titulo getH1() {
        return h1;
    }

    /**
     * @param h1 the h1 to set
     */
    public void setH1(Titulo h1) {
        this.h1 = h1;
    }

    /**
     * @return the h2
     */
    public Titulo getH2() {
        return h2;
    }

    /**
     * @param h2 the h2 to set
     */
    public void setH2(Titulo h2) {
        this.h2 = h2;
    }

    /**
     * @return the h3
     */
    public Titulo getH3() {
        return h3;
    }

    /**
     * @param h3 the h3 to set
     */
    public void setH3(Titulo h3) {
        this.h3 = h3;
    }

    /**
     * @return the imagen
     */
    public Imagen getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the form
     */
    public Form getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(Form form) {
        this.form = form;
    }

    /**
     * @return the tabla
     */
    public Tabla getTabla() {
        return tabla;
    }

    /**
     * @param tabla the tabla to set
     */
    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    /**
     * @return the imagenCodigoQR
     */
    public ImagenCodigoQR getImagenCodigoQR() {
        return imagenCodigoQR;
    }

    /**
     * @param imagenCodigoQR the imagenCodigoQR to set
     */
    public void setImagenCodigoQR(ImagenCodigoQR imagenCodigoQR) {
        this.imagenCodigoQR = imagenCodigoQR;
    }

    /**
     * @return the lineaSolida
     */
    public Linea getLineaSolida() {
        return lineaSolida;
    }

    /**
     * @param lineaSolida the lineaSolida to set
     */
    public void setLineaSolida(Linea lineaSolida) {
        this.lineaSolida = lineaSolida;
    }

    /**
     * @return the lineaPunteada
     */
    public Linea getLineaPunteada() {
        return lineaPunteada;
    }

    /**
     * @param lineaPunteada the lineaPunteada to set
     */
    public void setLineaPunteada(Linea lineaPunteada) {
        this.lineaPunteada = lineaPunteada;
    }

    /**
     * @return the panel
     */
    public Panel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public CurrentPosition getCurrentPosition() {
        return new CurrentPosition();
    }

    /**
     * Clase para contener la posicion current dentro de la escritura del
     * sistema.
     *
     *
     *
     * @author omargo33@gmail.com
     *
     */
    protected class CurrentPosition {

        private final float x;
        private final float y;
        private final int pagina;
        private final float ancho;

        /**
         * Metodo para crear la posicion inicial.
         * 
         */
        public CurrentPosition() {
            x = getDocumento().getRenderer().getCurrentArea().getBBox().getX();
            float yAreaEscribible = getDocumento().getRenderer().getCurrentArea().getBBox().getY();
            float topMargenEncabezado = getDocumento().getRenderer().getCurrentArea().getBBox().getTop();
            y = topMargenEncabezado - yAreaEscribible + margenSuperiorOriginal;
            pagina = getDocumento().getRenderer().getCurrentArea().getPageNumber();
            ancho = 500f;
        }

        /**
         * @return the x
         */
        public float getX() {
            return x;
        }

        /**
         * @return the y
         */
        public float getY() {
            return y;
        }

        /**
         * @return the pagina
         */
        public int getPagina() {
            return pagina;
        }

        @Override
        public String toString() {
            return "CurrentPosition{" + "x=" + x + ", y=" + y + ", pagina=" + pagina + '}';
        }

        /**
         * @return the ancho
         */
        public float getAncho() {
            return ancho;
        }
    }

    /**
     * @return the nota
     */
    public P getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(P nota) {
        this.nota = nota;
    }

    /**
     * @return the texto
     */
    public P getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(P texto) {
        this.texto = texto;
    }

    /**
     * @param margenSuperiorOriginal the margenSuperiorOriginal to set
     */
    public void setMargenSuperiorOriginal(float margenSuperiorOriginal) {
        this.margenSuperiorOriginal = margenSuperiorOriginal;
    }
}
