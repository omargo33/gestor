package com.aplicaciones13.pdf.impresion.itext;

import com.aplicaciones13.pdf.impresion.itext.presentacion.Cenefa;
import com.aplicaciones13.pdf.impresion.itext.presentacion.CenefaEstructura;
import com.aplicaciones13.pdf.utilidades.Mensaje;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * String strQuery="select * from MiTabla"; Query query =
 * em.createQuery(strQuery); query.setHint("eclipselink.result-type", "Map");
 * query.setHint("eclipselink.cursor.scrollable", true);
 *
 * ScrollableCursor cursor = (ScrollableCursor) query.getSingleResult(); while
 * (cursor.hasNext()) { DatabaseRecord record = (DatabaseRecord) cursor.next();
 * Vector<DatabaseField> fields = record.getFields();
 *
 * for(DatabaseField field : fields) { String name = field.getName(); Object
 * value = record.getValues(field); } }
 */
/**
 * Objeto con los datos de impresiones base de itext.
 *
 * @author omargo33@gmail.com
 *
 */
@Slf4j
public class ImpresionBaseIText {

    /**
     * Manejo de mensajes.
     */
    Mensaje mensajes = new Mensaje(ImpresionBaseElementos.NOMBRE_APLICACION);

    Cenefa cenefaSuperior;
    Cenefa cenefaInferior;
    Document document;
    PageSize pageSize;
    PdfDocument pdfDocument;

    SecureRandom random = new SecureRandom();
    int i = random.nextInt();

    private final String pahtTemporal = System.getProperty("user.home") + System.getProperty("file.separator") + new Date().getTime() + i;
    private CenefaEstructura cenefaEstructuraSuperior;
    private CenefaEstructura cenefaEstructuraInferior;
    private ImpresionBaseElementos impresionBaseElementos;
    private ByteArrayOutputStream byteArrayOutputStream;

    /**
     * Metodo para crear el objeto.
     *
     * @param impresionBaseElementos
     */
    public ImpresionBaseIText(ImpresionBaseElementos impresionBaseElementos) {
        init(impresionBaseElementos);
    }

    /**
     * Metodo para inicialiar el objeto.
     *
     */
    private void init(ImpresionBaseElementos impresionBaseElementos) {
        this.impresionBaseElementos = impresionBaseElementos;
        setByteArrayOutputStream(new ByteArrayOutputStream());
        cenefaEstructuraSuperior = new CenefaEstructura(false, false, false, false, false, null);
        cenefaEstructuraInferior = new CenefaEstructura(false, false, false, false, false, null);
        pageSize = PageSize.A4;

        cenefaSuperior = new Cenefa(true, pageSize) {
            @Override
            public Document getDocumentoPadre() {
                return document;
            }

            @Override
            public PdfDocument getPdfDocument() {
                return pdfDocument;
            }
        };

        cenefaInferior = new Cenefa(false, pageSize) {
            @Override
            public Document getDocumentoPadre() {
                return document;
            }

            @Override
            public PdfDocument getPdfDocument() {
                return pdfDocument;
            }
        };
    }

    /**
     * Metodo para crear un path temporal.
     *
     * @return
     */
    private OutputStream crearFilePathTemporal() {
        try {
            return new FileOutputStream(pahtTemporal);
        } catch (FileNotFoundException ex) {
            log.error(".crearFilePathTemporal() {}", ex.toString());
        }
        return null;
    }

    /**
     * Metodo para crear un FileImput.
     *
     * @param mapaParametros
     * @return
     */
    private InputStream crearFileInputArchivo12(Map<String, String> mapaParametros) {
        try {
            return new FileInputStream(mapaParametros.get("documentoArchivoP12"));
        } catch (FileNotFoundException ex) {
            log.error(".crearFileInputArchivo12() {}", ex.toString());
        }
        return null;
    }

    /**
     * Metodo para guardar agregando una firma electronica.
     *
     * @param currentPosition
     * @param mapaParametros
     */
    public void guardar(ImpresionBaseElementos.CurrentPosition currentPosition, Map<String, String> mapaParametros) {
        try {
            String alias = "";
            String clave = mapaParametros.get("documentoArchivoP12Clave");
            PrivateKey pk = null;

            //Proveedor de seguridades
            BouncyCastleProvider provider = new BouncyCastleProvider();
            Security.addProvider(provider);

            //Certificado del archivo p12
            KeyStore ks = KeyStore.getInstance("pkcs12", provider.getName());
            ks.load(crearFileInputArchivo12(mapaParametros), clave.toCharArray());

            for (String str : Collections.list(ks.aliases())) {
                pk = (PrivateKey) ks.getKey(str, clave.toCharArray());                
                if (pk != null) {
                    alias = str;
                    break;
                }
            }

            Certificate[] chain = ks.getCertificateChain(alias);

            //Firma del documento digital
            InputStream inputStream = new ByteArrayInputStream(getByteArrayOutputStream().toByteArray());
            PdfReader pdfReader = new PdfReader(inputStream);
            PdfSigner signer = new PdfSigner(pdfReader, crearFilePathTemporal(), new StampingProperties());
            signer.setFieldName("Firma");

            //Asentar la firma en el archivo
            firmarArchivo(provider, pk, chain, currentPosition, mapaParametros, signer);
        } catch (IOException | GeneralSecurityException e) {
            log.error(".guardar() {}", e);
            guardar();
        }
    }

    /**
     * Metodo para firmar el archivo.
     *
     * @param provider
     * @param pk
     * @param chain
     * @param currentPosition
     * @param mapaParametros
     * @param signer
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private void firmarArchivo(BouncyCastleProvider provider, PrivateKey pk, Certificate[] chain, ImpresionBaseElementos.CurrentPosition currentPosition, Map<String, String> mapaParametros, PdfSigner signer) throws IOException, GeneralSecurityException {
        //Presentacion de la firma electrionica 
        PdfSignatureAppearance pdfSignatureAppearance = signer.getSignatureAppearance();
        pdfSignatureAppearance.setReason(getNombreDocumento(mapaParametros));
        pdfSignatureAppearance.setLocation((String) mapaParametros.get("documentoSucursal"));
        pdfSignatureAppearance.setReuseAppearance(false);
        pdfSignatureAppearance.setPageRect(new Rectangle(currentPosition.getX(), currentPosition.getY(), currentPosition.getAncho(), 60));
        pdfSignatureAppearance.setPageNumber(currentPosition.getPagina());
        pdfSignatureAppearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.DESCRIPTION);
        pdfSignatureAppearance.setLayer2Font(impresionBaseElementos.getP().getFontTitulos());
        pdfSignatureAppearance.setLayer2FontSize(8);

        //Firma
        IExternalSignature iExternalSignature = new PrivateKeySignature(pk, DigestAlgorithms.SHA256, provider.getName());
        IExternalDigest iExternalDigest = new BouncyCastleDigest();
        signer.signDetached(iExternalDigest, iExternalSignature, chain, null, null, null, 0, PdfSigner.CryptoStandard.CMS);
    }

    /**
     * Metodo para guardar el documento del sistema.
     *
     */
    public void guardar() {
        try {
            try ( OutputStream outputStream = new FileOutputStream(pahtTemporal)) {
                getByteArrayOutputStream().writeTo(outputStream);
            }
        } catch (IOException e) {
            log.error(".guardar() {}", e);
        }
    }

    /**
     * Metodo para realizar la impresion de cualquier documento o orden del
     * mismo.Sole ejecuta si hay datos a imprimir Configura la pagina Prepara
     * documento sobre el Sream de salida Abre el documento De acuerdo al tipo
     * de impresion ejecuta Cierra el documento (contiene el Stream).
     *
     *
     *
     * @param margenSuperior
     * @param margenDerecho
     * @param margenInferior
     * @param margenIzquierdo
     * @param mapaParametros
     */
    public void ejecutar(float margenSuperior, float margenDerecho, float margenInferior, float margenIzquierdo, Map<String, String> mapaParametros) {
        try {
            PdfWriter pdfWriter = new PdfWriter(getByteArrayOutputStream(), new WriterProperties().setPdfVersion(PdfVersion.PDF_2_0));
            pdfDocument = new PdfDocument(pdfWriter);
            document = new Document(pdfDocument, pageSize, false);
            document.setMargins(margenSuperior, margenDerecho, margenInferior, margenIzquierdo);
            impresionBaseElementos.setDocumento(document);
            impresionBaseElementos.setMargenSuperiorOriginal(margenSuperior);
            getCenefaEstructuraSuperior().setNombreDocumento(getNombreDocumento(mapaParametros));
            cenefaSuperior.setCenefaEstructura(getCenefaEstructuraSuperior());
            cenefaSuperior.calibrarHoja();

            getCenefaEstructuraInferior().setNombreDocumento(getNombreDocumento(mapaParametros));

            cenefaInferior.setCenefaEstructura(getCenefaEstructuraInferior());
            cenefaInferior.calibrarHoja();
            impresionBaseElementos.setParametrosBusqueda(mapaParametros);
            impresionBaseElementos.escribir();
            cenefaSuperior.procesar();
            cenefaInferior.procesar();

            document.flush();
            document.close();
            if (mapaParametros.get("documentoArchivoP12") == null) {
                guardar();
            } else {
                guardar(impresionBaseElementos.getCurrentPosition(), mapaParametros);
            }
            encriptar(mapaParametros);
        } catch (Exception e) {
            log.error(".ejecutar() {}", e);
        }
    }

    /**
     * Metodo para obtener el nombre del documento para la firma
     *
     * @param mapaParametros
     * @return
     */
    private String getNombreDocumento(Map<String, String> mapaParametros) {
        return mensajes.obtenerMensajeParametros("txt_000_06",
                (String) mapaParametros.get("documentoNombre"),
                (String) mapaParametros.get("documentoCodigo")
        );
    }

    /**
     * Metodo para encritar los archivos PDF.
     *
     * @throws IOException
     */
    private void encriptar(Map<String, String> mapaParametros) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(pahtTemporal),
                new PdfWriter((String) mapaParametros.get("documentoDestino"), new WriterProperties().setStandardEncryption(
                        null,
                        pahtTemporal.getBytes(),
                        EncryptionConstants.ALLOW_PRINTING,
                        EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA))
        );
        pdfDoc.close();

        Path pathAbsolute = Paths.get(pahtTemporal);
        Files.deleteIfExists(pathAbsolute);
    }

    /**
     * @return
     */
    public ByteArrayOutputStream getByteArrayOutputStream() {
        return this.byteArrayOutputStream;
    }

    /**
     * @param byteArrayOutputStream
     */
    public void setByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    /**
     * @return the cenefaEstructuraSuperior
     */
    public CenefaEstructura getCenefaEstructuraSuperior() {
        return cenefaEstructuraSuperior;
    }

    /**
     * @param cenefaEstructuraSuperior the cenefaEstructuraSuperior to set
     */
    public void setCenefaEstructuraSuperior(CenefaEstructura cenefaEstructuraSuperior) {
        this.cenefaEstructuraSuperior = cenefaEstructuraSuperior;
    }

    /**
     * @return the cenefaEstructuraInferior
     */
    public CenefaEstructura getCenefaEstructuraInferior() {
        return cenefaEstructuraInferior;
    }

    /**
     * @param cenefaEstructuraInferior the cenefaEstructuraInferior to set
     */
    public void setCenefaEstructuraInferior(CenefaEstructura cenefaEstructuraInferior) {
        this.cenefaEstructuraInferior = cenefaEstructuraInferior;
    }

    public PdfDocument getPdfDocument() {
        return this.pdfDocument;
    }
}
