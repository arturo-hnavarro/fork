/** 
 * File     : ColaEnlazadaHeader.java
 * @author  : Prof. Gilberth Chaves Avila
 * Date     : 2017-05-09
 */

package Logica;
public class ColaEnlazadaHeader implements Cola {
    //Atributos
    private Nodo anterior, posterior; //dos apuntadores del TDA Cola
    private int contador; //lleva el control de los elementos encolados

    //Constructor
    public ColaEnlazadaHeader() {
        //inicialmente, anterior y posterior deben apuntar
        //a un nodo vacio
        this.anterior=this.posterior=new Nodo();
        this.contador = 0; //contador de elementos
    }

    @Override
    public int getSize() throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        return contador;
    }

    @Override
    public void anular() {
        //necesitamos que anterior y posterior queden apuntado
        //al nodo cabecera (al nodo vacio)
        this.anterior.sgte=null;
        this.posterior=anterior;
        this.contador = 0;//indica q ya no tiene elementos
    }

    @Override
    public boolean isEmpty() {
        //la cola esta vacia cuando anterior y posterior
        //apuntan al nodo cabecera (al nodo vacio)
        return posterior==anterior;
    }

    @Override
    public int getPosicion(Object elemento) throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        Nodo aux=anterior.sgte;  //para recorrer con el principio de colas con nodo cabecera
        int pos=1;
        while(aux!=null){
            if(aux.elemento.equals(elemento))
                return pos;
            aux=aux.sgte; //lo movemos al sgte nodo enlazado
            pos++;//incremento el contador de posiciones
        }//while
        return -1; //el elemento no existe en la cola enlazada
    }

    @Override
    public void encolar(Object elemento) throws ColaException {
        posterior.sgte = new Nodo(elemento);
        posterior = posterior.sgte; //lo muevo al nodo q acabo de enlazar
        this.contador++; //aumenta el num de elementos encolados
    }

    @Override
    public Object desencolar() throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        //elemento a desencolar
        Object elemento = anterior.sgte.elemento;

        //CASO 1: SOLO SE TIENE UN ELEMENTO ENCOLADO
        if(anterior.sgte==posterior){
            this.anular(); //elimina la cola
        }//if
        //CASO 2: EXISTEN VARIOS ELEMENTOS ENCOLADOS, AL MENOS 2
        else{ 
            anterior.sgte=anterior.sgte.sgte;
        }
        this.contador--; //para actualizar la cantidad de elementos
        return elemento;
     }

    @Override
    public boolean existe(Object elemento) throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        Nodo aux=anterior.sgte;  //para recorrer con el principio de colas
        while(aux!=null){
            if(aux.elemento.equals(elemento))
                return true;
            aux=aux.sgte; //lo movemos al sgte nodo enlazado
        }//while
        return false;
    }

    @Override
    public Object frente() throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        return anterior.sgte.elemento;
    }

    @Override
    public String toString() {
        String result="";
        try {
            if(this.isEmpty())
                throw new ColaException("La cola esta vacia");

            result="COLA ENLAZADA CON NODO CABECERA\n";
            Nodo aux=anterior.sgte;  //para recorrer con el principio de colas
            while(aux!=null){
                result+=aux.elemento+" ";
                aux=aux.sgte; //lo movemos al sgte nodo
            }
            
        } catch (ColaException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public String mostrar() {
        String result="";
        try {
            if(this.isEmpty())
                throw new ColaException("La cola esta vacia");

            Nodo aux=anterior.sgte;  //para recorrer con el principio de colas
            while(aux!=null){
                if(aux.elemento instanceof ColaEnlazadaHeader){
                    ColaEnlazadaHeader elemento = (ColaEnlazadaHeader) aux.elemento;
                    result+=elemento.mostrar();
                }else{ 
                if(aux.elemento instanceof String){
                    result+=aux.elemento+" ";
                }else
                    result+=aux.elemento;
                }
                aux=aux.sgte; //lo movemos al sgte nodo
            }
            
        } catch (ColaException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
}//fin de la clase ColaEnlazada
