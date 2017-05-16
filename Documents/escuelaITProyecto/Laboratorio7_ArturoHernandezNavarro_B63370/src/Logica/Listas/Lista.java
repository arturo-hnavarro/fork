/** 
 * File     : Lista.java
 * @author  : Prof. Gilberth Chaves Avila
 * Date     : 2017-04-25
 */
package Logica.Listas;

import Logica.Listas.Nodo;

public interface Lista {
    	public int getSize() throws ListaException; // Devuelve el numero de elementos en la lista
	public void anular(); //Elimina toda la lista
	public boolean isEmpty(); // true si la lista esta vacia
	public int getPosicion(Object elemento) throws ListaException; //devuelve la posicion de un elemento en la lista
	public Nodo getNodo(int posicion) throws ListaException;//devuelve el nodo en la posicion indicada en la lista
        public void insertar(Object elemento); // Agrega un elemento a la lista en forma secuencial
	public void insertarOrdenado(Object elemento) ; // Agrega un elemento a la lista en forma ordenada
	public void suprimir(Object elemento)throws ListaException; //Suprime un elemento de la lista
	public boolean existe(Object elemento)throws ListaException; //true si el elemento existe en la lista
	public Object primero()throws ListaException; //Devuelve el primer elemento de la lista
	public Object ultimo()throws ListaException; //Devuelve el ultimo elemento de la lista
	
	//Metodos adicionales
	public void ordenar()throws ListaException; //Ordena los elementos de la lista
	public Object anterior(Object elemento) throws ListaException; //Devuelve el elemento anterior al actual en la lista
	public Object posterior(Object elemento) throws ListaException; //Devuelve el elemento anterior al actual en la lista
        
        
        

}//fin de Interface Lista
