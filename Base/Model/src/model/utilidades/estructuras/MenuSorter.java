package model.utilidades.estructuras;import java.util.Comparator;/** * Metodo para ordenar los menus. * * @author omargo33@hotmail.com */public class MenuSorter implements Comparator<Menu> {    public MenuSorter() {        super();    }    @Override    public int compare(Menu m1, Menu m2) {        return ("" + m1.getOrden()).compareToIgnoreCase("" + m2.getOrden());    }}