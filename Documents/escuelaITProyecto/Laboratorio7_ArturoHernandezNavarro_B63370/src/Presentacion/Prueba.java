package Presentacion;

import Logica.ColaArreglo;
import Logica.ColaEnlazada;
import Logica.ColaEnlazadaHeader;
import Logica.ColaException;
import Logica.Listas.ListaCircular;
import Logica.Listas.ListaCircularEnlazadaDoble;
import Logica.Listas.ListaEnlazada;
import Logica.Listas.ListaEnlazadaDoble;
import Logica.Nodo;
import Logica.Utilidades;

/**
 *
 * @author Arturo
 */
public class Prueba {

    public Prueba() {
    }

    public void pruebaColaArreglo() throws ColaException {
        System.out.println("\n\n"
                          +"********************************************************\n"
                          +"****************  PRUEBAS COLA ARREGLO  ****************\n"
                          +"********************************************************\n");
        ColaArreglo colaArreglo = new ColaArreglo(50);
        //Inserto 50 caracteres
        for (int i = 0; i < 50; i++) {
            colaArreglo.encolar(Utilidades.obtenerLetraAleatorio());
        }
        //Muestro el contenido de la cola
        System.out.println(colaArreglo.toString());
        System.out.println("\nEl tamaño de la cola es: " + colaArreglo.getSize());
        System.out.println("\n\n-- PROBAMOS EXISTE() --");

        for (int i = 0; i < 22; i++) {
            char elemento = Utilidades.obtenerLetraAleatorio();
            System.out.println("El elemento " + elemento + (colaArreglo.existe(elemento) ? " Si existe en la cola" : " No existe en la cola"));
        }

        //Probar getPosicion()
        System.out.println("\n\n-- PROBAMOS GETPOSICION() --");
        for (int i = 0; i < 22; i++) {
            char elemento = Utilidades.obtenerLetraAleatorio();
            System.out.println("El elemento " + elemento + (colaArreglo.getPosicion(elemento) != -1 ? " Se encuentra en la posición " + colaArreglo.getPosicion(elemento)
                    : " NO existe en la cola"));
        }

        System.out.println("\nEL ELEMENTO EN FRENTE DE LA COLA ES: " + colaArreglo.frente() + "\n");

        //DESENCOLAR 10 ELEMENTOS
        for (int i = 0; i < 10; i++) {
            System.out.println("Se desencoló el elemento: " + colaArreglo.frente());
            colaArreglo.desencolar();
        }
        System.out.println("\n" + colaArreglo.toString());
        System.out.println("El nuevo tamaño de la cola es: " + colaArreglo.getSize());
    }//pruebaColaArreglo()

    public void pruebaColaEnlazada() throws ColaException {
          System.out.println("\n\n"
                            +"********************************************************\n"
                            +"***************  PRUEBAS COLA ENLAZADA  ****************\n"
                            +"********************************************************\n");
        
        ColaEnlazada cola1, cola2;
        cola1 = cola2 = new ColaEnlazada();

        for (int i = 0; i < 100; i++) {
            cola1.encolar(Utilidades.obtenerNumeroAleatorio());
        }

        System.out.println(cola1.toString());//Muestro el contenido de cola1
        //4. Encole 10 objetos tipo nodo (nodo1, nodo2, …., nodo10) y la cola1 en la cola2

        cola2.encolar(new Nodo(1));
        cola2.encolar(new Nodo(3435));
        cola2.encolar(new Nodo("Arturo"));
        cola2.encolar(new Nodo("Denise"));
        cola2.encolar(new Nodo(42534));
        cola2.encolar(new Nodo("Aerosmith"));
        cola2.encolar(new Nodo("Radio Head"));
        cola2.encolar(new Nodo("R.E.M"));
        cola2.encolar(new Nodo("Cold Play"));
        cola2.encolar(new Nodo(123));
        cola2.encolar(new Nodo(19877));
        cola2.encolar(cola1);

        for (int i = 1; i <= 10; i++) {
            System.out.println("El elemento de la posición " + cola2.getPosicion(cola2.getNodo(i).elemento) + " es: "
                    + cola2.getNodo(i).elemento.toString());
        }

    }//método pruebaColaEnlazada()

    public void pruebaColaEnlazadaHeader() throws ColaException {
          System.out.println("\n\n"
                            +"********************************************************\n"
                            +"************  PRUEBAS COLA ENLAZADA HEADER  ************\n"
                            +"********************************************************\n");
        
        ColaEnlazadaHeader cola1 = new ColaEnlazadaHeader();
        ColaEnlazadaHeader cola2 = new ColaEnlazadaHeader();
        ColaEnlazadaHeader cola3 = new ColaEnlazadaHeader();
        
        ListaCircular listaCircular = new ListaCircular();
        ListaEnlazada listaEnlazada = new ListaEnlazada();
        ListaEnlazadaDoble listaEnlazadaDoble = new ListaEnlazadaDoble();
        ListaCircularEnlazadaDoble listaCircularEnlazadaDoble = new ListaCircularEnlazadaDoble();

        //Encole en cola1 10 objetos tipo ListaCircular. Cada lista deberá tener al menos 20 elementos
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 20; j++) { //agregamos elementos a las listas
                listaCircular.anular();
                listaCircular.insertar(Utilidades.obtenerLetraAleatorio());
            }
            cola1.encolar(listaCircular);//Agregar las listas a cola1
        }

        //Encole en cola2 4 objetos tipo ListaEnlazada, ListaEnlazadaDoble, ListaCircular, 
        //ListaCircularEnlazadaDoble. Cada lista deberá tener al menos 10 elementos
        listaCircular.anular();
        for (int j = 1; j <= 10; j++) { //agregamos elementos a las listas
            listaEnlazada.insertar(Utilidades.obtenerLetraAleatorio());
            listaEnlazadaDoble.insertar(Utilidades.obtenerNumeroAleatorio());
            listaCircular.insertar(Utilidades.obtenerLetraAleatorio());
            listaCircularEnlazadaDoble.insertar(Utilidades.obtenerNumeroAleatorio() * 3);
        }

        //Encolar las listas en cola2
        cola2.encolar(listaEnlazada);
        cola2.encolar(listaEnlazadaDoble);
        cola2.encolar(listaCircular);
        cola2.encolar(listaCircularEnlazadaDoble);

        //Encolo las colas 1 y 2 en cola3
        cola3.encolar(cola1);
        cola3.encolar(cola2);

        //Muestro el contenido de cola3
        ColaEnlazadaHeader colaAux = new ColaEnlazadaHeader();
        while (!cola3.isEmpty()) {
            System.out.println(cola3.frente().toString());
            colaAux.encolar(cola3.desencolar());
        }

        cola3 = colaAux;
        //Compruebo que cola3 tome el contenido de cola auxiliar
        System.out.println("Contenido de cola3\n\n" + cola3.toString());

    } //pruebaColaEnlazadaHeader()

}
