/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Listas;

/**
 *
 * @author Equipo
 */
public class Nodo {
    public Object elemento;
    public Nodo ant, sgte;

    public Nodo(Object elemento) {
        this.elemento = elemento;
        this.ant = this.sgte = null; // Evita basura
    }
    
}
