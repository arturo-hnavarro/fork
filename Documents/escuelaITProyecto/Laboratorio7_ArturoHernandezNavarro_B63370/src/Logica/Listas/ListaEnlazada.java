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
public class ListaEnlazada implements Lista {

    private Nodo inicio;//Representa el inicio de la lista, si se pierde se elimina la pila

    public ListaEnlazada() {
        this.inicio = null;
    }

    @Override
    public void insertar(Object elemento) {
        if (inicio == null) {
            inicio = new Nodo(elemento);
        } else {
            Nodo aux = inicio;
            while (aux.sgte != null) {
                aux = aux.sgte;//mueve aux al siguiente nodo 
            }
            aux.sgte = new Nodo(elemento);
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
    public void suprimir(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        if (inicio.elemento.equals(elemento)) {// si el elemento es el primero
            inicio = inicio.sgte;
            System.out.println("Se eliminó el elemento");
        } else {
            Nodo aux = inicio;
            Nodo auxAnterior = null;
            while (aux.sgte != null && !aux.elemento.equals(elemento)) {
                auxAnterior = aux;
                aux = aux.sgte;
            }
            if (aux.elemento.equals(elemento)) {
                auxAnterior.sgte = aux.sgte;//Saltamos el nodo con el elemento a eliminar
                System.out.println("Se eliminó el elemento");

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
    public Object anterior(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        if (inicio.elemento.equals(elemento)) {
            return "No tiene (es el inicio).";
        }
        Nodo anterior = inicio;//apunta al nodo anterior al aux
        Nodo aux = inicio.sgte;
        while (aux != null) {
            if (aux.elemento.equals(elemento)) {
                return anterior.elemento;
            }
            anterior = aux;// dejo un ratro
            aux = aux.sgte;
        }
        return "no tiene";
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
                    return auxPosterior.elemento;
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
        String result = "LISTA ENLAZADA SIMPLE\n\n";
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

    @Override
    public void insertarOrdenado(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ordenar() throws ListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
