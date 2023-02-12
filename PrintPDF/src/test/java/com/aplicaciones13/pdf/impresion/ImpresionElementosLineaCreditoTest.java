package com.aplicaciones13.pdf.impresion;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.aplicaciones13.pdf.impresion.itext.ImpresionBaseIText;
import com.aplicaciones13.pdf.impresion.itext.presentacion.CenefaEstructura;

import static org.junit.jupiter.api.Assertions.*;

/** 
 * Objeto de entidad Auditoria.
 *
 * @author omargo33@gmail.com
 * @created 2022-07-05
 */
public class ImpresionElementosLineaCreditoTest {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ImpresionElementosLineaCreditoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of elemento1 method, of class ImpresionElementoLineaCredito.
     */
    @Test
    public void testElemento1() {
        LOGGER.info("ImpresionElementosLineaCredito elemento1");

        try {
            Map<String, String> mapa = new HashMap<>();
            //Datos socios
            mapa.put("numeroLineaCredito", "0001");
            mapa.put("documentoDestino", "/home/colaborador/test.pdf");
            mapa.put("documentoPie", "/mnt/documentos/logosCooperativa/membreteInferior_2239x209.png");
            mapa.put("documentoEncabezado", "/mnt/documentos/logosCooperativa/membreteSuperior_2239x209.png");

            mapa.put("montoAprobado", "101");
            mapa.put("montoUtilizado", "102");
            mapa.put("montoDisponible", "103");

            CenefaEstructura cenefaEstructuraSuperior = new CenefaEstructura(false, true, false, false, false, mapa.get("documentoEncabezado"));
            CenefaEstructura cenefaEstructuraInferior = new CenefaEstructura(false, true, false, false, false, mapa.get("documentoPie"));

            ImpresionElementosLineaCredito impresionLineaCredito = new ImpresionElementosLineaCredito();
            impresionLineaCredito.setOrdenElementos(new int[]{1, 2, 3, 6, 7});

            ImpresionBaseIText impresionBaseIText = new ImpresionBaseIText(impresionLineaCredito);
            impresionBaseIText.setCenefaEstructuraSuperior(cenefaEstructuraSuperior);
            impresionBaseIText.setCenefaEstructuraInferior(cenefaEstructuraInferior);
            impresionBaseIText.ejecutar(18, 36, 30, 36, mapa);
        } catch (Exception e) {
            fail("ImpresionElementosLineaCredito The test case is a prototype." + e.toString());
        }
    }
}