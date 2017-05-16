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
public class ListaCircularEnlazadaDoble implements Lista {

    private Nodo inicio, fin;//Representa el inicio de la lista, si se pierde se elimina la pila

    public ListaCircularEnlazadaDoble() {
        this.inicio = this.fin = null;
    }

    @Override
    public void insertar(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);

        if (inicio == null) {
            inicio = fin = new Nodo(elemento);
        } else {
            Nodo aux = inicio;
            while (aux != fin) {
                aux = aux.sgte;//mueve aux al siguiente nodo 
            }//Se sale cuando estamos en el último Nodo
            aux.sgte = nuevoNodo;
            nuevoNodo.ant = aux; // Hacemos el doble enlace
            fin = nuevoNodo; // Hacer que fin apunte al nuevo Nodo
            fin.sgte = inicio;//Hacemos el enlace al inicio
            inicio.ant = fin;
        }//else
    }

    @Override
    public void anular() {
        this.inicio = this.fin = null;
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
        while (aux != fin) {
            contador++;
            aux = aux.sgte;
        }
        return contador + 1; // Cuando alcanza el último Nodo se sale
    }

    @Override
    public int getPosicion(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        int posicion = 1;
        while (aux != fin) {
            if (aux.elemento.equals(elemento)) {
                return posicion;
            }
            posicion++;
            aux = aux.sgte;
        } // se sale cuando está en el último Nodo
        if (aux.elemento.equals(elemento)) {
            return posicion;
        }

        return -1;

    }

    @Override
    public void insertarOrdenado(Object elemento) {
        if (isEmpty()) {
            inicio = new Nodo(elemento);
        } else {
            Nodo aux = inicio;

            while (aux.sgte != null) {
                if ((aux.elemento.toString().compareTo(elemento.toString())) >= 0) {

                    Nodo burbuja = aux;
                    aux = new Nodo(elemento);

                    while (burbuja.sgte != null) {
                        aux.sgte = burbuja;
                        burbuja = burbuja.sgte;
                    }
                    aux.sgte = null;

                } else {
                    aux = aux.sgte;
                }

            }
        }
    }

    @Override
    public void suprimir(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        if (inicio.elemento.equals(elemento)) {// si el elemento es el primero
            inicio = inicio.sgte;
        } else {
            Nodo aux = inicio;
            Nodo auxAnterior = null;
            while (aux != fin && !aux.elemento.equals(elemento)) {
                auxAnterior = aux;
                aux = aux.sgte;
            }//Se sale cuando alcanza el Nodo apuntado por fin

            if (aux.elemento.equals(elemento)) {
                auxAnterior.sgte = aux.sgte;//Saltamos el nodo con el elemento a eliminar
                aux.sgte.ant = auxAnterior;//Hacemos el doble enlace
            }
            //Debo asegurarme que fin apunte al último nodo de la lista
            if (aux == fin) {//estamos en el último Nodo
                fin = auxAnterior; //queda apuntando al último Nodo
            }
        }//else
        //mantengo el enlace circular y doble
        fin.sgte = inicio;
        inicio.ant = fin;

        //Si solo queda un nodo y se quiere eliminar
        if (inicio == fin && inicio.elemento.equals(elemento)) {
            anular();
        }
    }

    @Override
    public boolean existe(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        while (aux != fin) {
            if (aux.elemento.equals(elemento)) {
                return true;
            }
            aux = aux.sgte;
        }//Se sale cuando apunta al último Nodo
        return aux.elemento.equals(elemento);
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

        Nodo aux = inicio.sgte;
        while (aux != fin) {
            if (aux.elemento.equals(elemento)) {
                return aux.ant.elemento;
            }
            aux = aux.sgte;
        } // Se sale cuando estamos en el último Nodo
        if (aux.elemento.equals(elemento)) {
            return aux.ant.elemento;
        }
        return "no tiene";
    }

    @Override
    public Object posterior(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        while (aux != fin) {
            if (aux.elemento.equals(elemento)) {
                return aux.sgte.elemento;
            }
            aux = aux.sgte;
        }
        if (aux.elemento.equals(elemento)) {
            return aux.sgte.elemento;
        }
        return "No tiene";
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La lista esta vacia.";
        }
        String result = "LISTA CIRCULAR DOBLE\n\n";
        Nodo aux = inicio;
        while (aux != fin) {
            result += aux.elemento + "\n";
            aux = aux.sgte;
        }
        return result + "" + fin.elemento;
    }

    @Override
    public Nodo getNodo(int posicion) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista está vacía");
        }
        Nodo aux = inicio;
        int posicionActual = 1;
        while (aux != fin) {
            if (posicion == posicionActual) {
                return aux;
            }
            posicionActual++;
            aux = aux.sgte;
        }//Se sale cuando está en el último Nodo
        if (posicion == posicionActual) {
            return aux;
        }
        return null;//La posición no existe
    }

}
