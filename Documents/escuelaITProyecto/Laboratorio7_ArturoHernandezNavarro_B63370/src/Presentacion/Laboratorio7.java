/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ColaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo
 */
public class Laboratorio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Prueba pruebas = new Prueba();
            pruebas.pruebaColaArreglo();
            pruebas.pruebaColaEnlazada();
            pruebas.pruebaColaEnlazadaHeader();
            
            
        } catch (ColaException ex) {
            Logger.getLogger(Laboratorio7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
