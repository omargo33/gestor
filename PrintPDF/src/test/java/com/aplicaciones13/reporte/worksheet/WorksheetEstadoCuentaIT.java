/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.reporte.worksheet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import com.aplicaciones13.reporte.worksheet.worksheet.WorksheetEstadoCuenta;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author omarv
 */
public class WorksheetEstadoCuentaIT {

    WorksheetEstadoCuenta test;

    /**
     * Metodo iniciar test.
     */
    public WorksheetEstadoCuentaIT() {
        test = new WorksheetEstadoCuenta();
    }

    /**
     * Test of ejecutar method, of class WorksheetEstadoCuenta.
     */
    @Test
    public void testEjecutar() {
        try {
            getValores();
            test.ejecutar(getParametrosBusqueda());
        } catch (Exception e) {
            fail(" WorksheetEstadoCuentaIT The test case is a prototype. ejecutar " + e.toString());
        }
    }

    /**
     * Test of setValores method, of class WorksheetEstadoCuenta.
     */
    
    private void getValores() {

        try {
            List<Object[]> valores = new ArrayList<>();
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
            
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
            
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});
            
                    valores.add(new Object[]{"2020-06-12 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 001"});
            valores.add(new Object[]{"2020-06-13 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 002"});
            valores.add(new Object[]{"2020-06-14 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 003"});
            valores.add(new Object[]{"2020-06-15 12:12", "dos", 12346, "456", 12346, 12346, 12346, 12346, 12346, "observacion 004"});

            test.setValores(valores);
        } catch (Exception e) {
            fail("WorksheetEstadoCuentaIT The test case is a prototype. setValores " + e.toString());
        }
    }

    /**
     * Test of getParametrosBusqueda method, of class WorksheetEstadoCuenta.
     * @return 
     */    
    private Map<String, String> getParametrosBusqueda() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("nombre", "VELEZ BAYAS OMAR ANTONIO");
        mapa.put("noCuenta", "1937480");
        
        mapa.put("fechaPeriodo", "nueva fecha nueva fecha");        
        mapa.put("saldoDisponible", String.valueOf(new BigDecimal(900000000.12).doubleValue()));        
        mapa.put("saldoBloqueado", "500.23");
        mapa.put("saldoTotal", "1000.23");        
        
        mapa.put("documentoDestino", "/home/omarv/estadoCuenta.xls");
        
        mapa.put("documentoCosede", "/mnt/documentos/logos/cosede_1028x466.png");
        return mapa;
    }
}
