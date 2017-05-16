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
//La simple solo tiene siguiente y la doble anterior y siguiente
public class ListaEnlazadaDoble implements Lista {

    private Nodo inicio;//Representa el inicio de la lista, si se pierde se elimina la pila

    public ListaEnlazadaDoble() {
        this.inicio = null;
    }
    //Hacer insertar y ordenar en ListaEnlazada(burbuja)

    @Override
    public void insertar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);

        if (inicio == null) {
            inicio = new Nodo(elemento);
        } else {
            Nodo aux = inicio;
            while (aux.sgte != null) {
                aux = aux.sgte;//mueve aux al siguiente nodo 
            }
            aux.sgte = nuevoNodo;
            //hago el doble enlace
            nuevoNodo.ant = aux;
        }//else
    }

    @Override
    public void anular() {
        this.inicio = null;
    }

    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public int getSize() throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        int contador = 0;
        while (aux != null) {
            contador++;
            aux = aux.sgte;
        }
        return contador;
    }

    @Override
    public int getPosicion(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        int posicion = 1;
        while (aux != null) {
            if (aux.elemento.equals(elemento)) {
                return posicion;
            }
            posicion++;
            aux = aux.sgte;
        }
        return -1;
    }

    @Override
    public void insertarOrdenado(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suprimir(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        if (inicio.elemento.equals(elemento)) {// si el elemento es el primero
            inicio = inicio.sgte;
            inicio.ant = null;
        } else {
            Nodo aux = inicio;
            Nodo auxAnterior = null;
            while (aux.sgte != null && !aux.elemento.equals(elemento)) {
                auxAnterior = aux;
                aux = aux.sgte;
            }
            if (aux.elemento.equals(elemento)) {
                auxAnterior.sgte = aux.sgte;//Saltamos el nodo con el elemento a eliminar
                aux.sgte.ant = aux.ant;
            }
        }
    }

    @Override
    public boolean existe(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.elemento.equals(elemento)) {
                return true;
            }
            aux = aux.sgte;
        }
        return false;
    }

    @Override
    public Object primero() throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        return inicio.elemento;
    }

    @Override
    public Object ultimo() throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        while (aux.sgte != null) {
            aux = aux.sgte;
        }
        return aux.elemento;

    }

    @Override
    public void ordenar() throws ListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object anterior(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        if (inicio.elemento.equals(elemento)) {
            return "No tiene (es el inicio).";
        }
        Nodo aux = inicio.sgte;//apunta al nodo anterior al aux

        while (aux != null) {
            if (aux.elemento.equals(elemento)) {
                return aux.ant.elemento;
            }
            aux = aux.sgte;
        }
        return "El elemento no existe.";
    }

    @Override
    public Object posterior(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        Nodo auxPosterior = inicio.sgte;
        while (aux != null) {
            if (aux.elemento.equals(elemento)) {
                if (auxPosterior != null) {
                    return aux.sgte.elemento;
                }
            }
            aux = aux.sgte;
            if (aux != null) {
                auxPosterior = aux.sgte;
            }
        }
        return "no tiene";
    }

    public String toString() {
        if (isEmpty()) {
            return "La lista esta vacia.";
        }
        String result = "LISTA ENLAZADA DOBLE\n\n";
        Nodo aux = inicio;
        while (aux != null) {
            result += aux.elemento + "\n";
            aux = aux.sgte;
        }
        return result;
    }

    @Override
    public Nodo getNodo(int posicion) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        int posicionActual = 1;
        while (aux != null) {
            if (posicion == posicionActual) {
                return aux;
            }
            posicionActual++;
            aux = aux.sgte;
        }
        return null;//La posición no existe
    }


}
