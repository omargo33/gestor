package com.aplicaciones13.reporte.pdf.itext.compuestos;

import com.aplicaciones13.reporte.pdf.itext.texto.Elemento;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Objeto para crear componentes con tablas de presentacion.
 *
 * @author omargo33@gmail.com
 *  
 *
 *
 */
public class Conjunto extends Elemento implements ConjuntoInterface {

    private Table tabla;
    private Map<Integer, TextAlignment> mapaAlineamiento;
    private List<Float> listaDimensiones;
    private List<String> listaFormatos;
    private List<String> listaTitulos;

    /**
     * Metodo para crear el objeto.
     *
     */
    public Conjunto() {
        super();
        initConjunto();

    }

    /**
     * Metodo para inicializar el objeto.
     *
     */
    private void initConjunto() {
        setMapaAlineamiento(new HashMap<>());
        this.listaTitulos = new ArrayList<>();
        setTabla(new Table(1));
    }

    /**
     * @return
     */
    public List<String> getListaFormatos() {
        return listaFormatos;
    }

    /**
     * @param formatos
     */
    public void setListaFormatos(String... formatos) {
        listaFormatos = new ArrayList<>();
        listaFormatos.addAll(Arrays.asList(formatos));
    }

    /**
     * @return
     */
    public List<Float> getListaDimensiones() {
        return listaDimensiones;
    }

    /**
     * @return
     */
    /**
     * Metodo para proporcionar de dimesiones a las tablas con valores
     * porcentuales contra la dimension de la pagina.
     *
     * @return
     */
    public float[] getArrayDimensiones() {
        float total = getDocumento().getPdfDocument().getDefaultPageSize().getWidth();
        float[] arreglo = new float[this.listaDimensiones.size()];
        for (int i = 0; i < this.listaDimensiones.size(); i++) {
            arreglo[i] =total  / 100 * this.listaDimensiones.get(i);            
        }       
        return arreglo;
    }

    /**
     * Metododo para asignar las dimensiones.
     *
     * @param dimensiones
     */
    public void setListaDimensiones(Float... dimensiones) {
        this.listaDimensiones = new ArrayList<>();
        this.listaDimensiones.addAll(Arrays.asList(dimensiones));
    }

    /**
     * @return
     */
    public List<String> getListaTitulos() {
        return listaTitulos;
    }

    /**
     * Metodo para asignar numeros de columanas.
     *
     * @param columnas
     */
    public void setListaTitulos(String... columnas) {
        this.listaTitulos = new ArrayList<>();
        this.listaTitulos.addAll(Arrays.asList(columnas));
    }

    /**
     * Metodo para obtener la informacion de alineamiento y valores por defecto.
     *
     * @param columna
     * @param textAlignmentNull
     * @return
     */
    public TextAlignment getAlineamientoColumna(int columna, TextAlignment textAlignmentNull) {
        TextAlignment textAlignmentTemp = this.mapaAlineamiento.get(columna);
        if (textAlignmentTemp == null) {
            textAlignmentTemp = textAlignmentNull;
        }
        return textAlignmentTemp;
    }

    /**
     * @return the mapaAlineamiento
     */
    public Map<Integer, TextAlignment> getMapaAlineamiento() {
        return mapaAlineamiento;
    }

    /**
     * @param mapaAlineamiento the mapaAlineamiento to set
     */
    public void setMapaAlineamiento(Map<Integer, TextAlignment> mapaAlineamiento) {
        this.mapaAlineamiento = (mapaAlineamiento == null) ? new HashMap<>() : mapaAlineamiento;
    }

    /**
     * @return
     */
    public float getLargo() {
        return this.tabla.getHeight().getValue();
    }

    /**
     * @return
     */
    public float getAncho() {
        return this.tabla.getWidth().getValue();
    }

    /**
     * @return the table
     */
    public Table getTabla() {
        return tabla;
    }

    /**
     * @param tabla the table to set
     */
    public void setTabla(Table tabla) {
        this.tabla = tabla;
    }

    /**
     * Metodo que escribe en el documento la form o su conjunto.
     *
     * Si hay tabla la escribe.
     *
     * Reinicia los valores de paneles y alineamiento.
     *
     */
    @Override
    public void escribir() {
        getDocumento().add(getTabla());
    }

    /**
     * Metodo para procesar y escribir en el pdf.
     * 
     */
    public void procesarEscribir() {
        procesar();
        getDocumento().add(getTabla());
    }

    @Override
    public void procesar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
