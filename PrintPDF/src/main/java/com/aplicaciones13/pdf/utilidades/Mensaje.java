/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.pdf.utilidades;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Objeto para personalizar los mensajes del aplicativo.
 *
 * @author omargo33@gmail.com
 * @date 2023-02-01
 * 
 */
public class Mensaje {    
    private static final String APPLICATION_BUNDLE_BASENAME = "basenameapplication";
    private String bundleSeleccionado;

    /**
     * Metodo para crear el objeto.
     *
     * @param applicationBundle
     *
     */
    public Mensaje(String applicationBundle) {
        super();
        setBundleSeleccionado(getApplicationBundle(applicationBundle));
    }

    /**
     * Metodo para inicializar el metodo.
     *
     * @return
     */
    private String getApplicationBundle(String applicationBundle) {
        return messageResourceString(applicationBundle, APPLICATION_BUNDLE_BASENAME);
    }

    /**
     * Obtiene un mensaje del archivo de propiedades
     *
     * @param keyBundle
     * @param bundle
     * @return
     */
    public String obtenerMensaje(String keyBundle) {
        return messageResourceString(bundleSeleccionado, keyBundle);
    }

    /**
     * Metodo para obtener una mensaje del archivo de propiedades, a partir de
     * los par�metros de entrada.
     *
     * @param keyBundle     
     * @param params
     * @return
     */
    public String obtenerMensajeParametros(String keyBundle, Object... params) {
        return messageResourceString(bundleSeleccionado, keyBundle, params);
    }

    /**
     * Obtiene la informacion del archivo de propiedades
     *
     * @param bundleName
     * @param key
     * @return
     */
    public String messageResourceString(String bundleName, String key) {
        String text;
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
        try {
            text = bundle.getString(key);
        } catch (MissingResourceException e) {
            text = "?? key " + key + " not found ??";
        }
        return text;
    }

    /**
     * Metodo para recuperar la cadena del bundle, a partir de los par�metros de
     * entrada.
     *
     * @param bundleName
     * @param key
     * @param params
     * @return
     */
    public String messageResourceString(String bundleName, String key, Object... params) {
        String text;
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
        try {
            text = MessageFormat.format(bundle.getString(key), params);
        } catch (MissingResourceException e) {
            text = "?? key " + key + " not found ??";
        }
        return text;
    }

    public String getBundleSeleccionado() {
        return bundleSeleccionado;
    }

    public void setBundleSeleccionado(String bundleSeleccionado) {
        this.bundleSeleccionado = bundleSeleccionado;
    }

}
