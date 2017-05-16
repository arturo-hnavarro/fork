/** 
 * File     : ColaEnlazada.java
 * @author  : Prof. Gilberth Chaves Avila
 * Date     : 2017-05-09
 */

package Logica;
public class ColaEnlazada implements Cola {
    //Atributos
    private Nodo anterior, posterior; //dos apuntadores del TDA Cola
    private int contador; //lleva el control de los elementos encolados

    //Constructor
    public ColaEnlazada() {
        this.anterior=this.posterior=null;
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
        this.anterior=this.posterior=null;
        this.contador = 0;
    }

    @Override
    public boolean isEmpty() {
        return anterior==null;
    }

    @Override
    public int getPosicion(Object elemento) throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        Nodo aux=anterior;  //para recorrer con el principio de colas
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
        if(this.isEmpty()){ //si la cola no existe
            posterior = new Nodo(elemento);
            anterior=posterior; //garantiza q anterior quede apuntado al 1er nodo
        }//if
        else{ //si ya existe al menos un elemento encolado
            posterior.sgte = new Nodo(elemento);
            posterior = posterior.sgte;//lo movemos al final (queda apuntando al ultimo nodo)
        }//else
        this.contador++; //aumenta el num de elementos encolados
    }

    @Override
    public Object desencolar() throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        //elemento a desencolar
        Object elemento = anterior.elemento;

        //CASO 1: SOLO SE TIENE UN ELEMENTO ENCOLADO
        if(anterior==posterior){
            this.anular(); //elimina la cola
        }//if
        //CASO 2: EXISTEN VARIOS ELEMENTOS ENCOLADOS, AL MENOS 2
        else{ 
            anterior=anterior.sgte;
        }
        this.contador--; //para actualizar la cantidad de elementos
        return elemento;
     }

    @Override
    public boolean existe(Object elemento) throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        Nodo aux=anterior;  //para recorrer con el principio de colas
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
        return anterior.elemento;
    }

    @Override
    public String toString() {
        String result="";
        try {
            if(this.isEmpty())
                throw new ColaException("La cola esta vacia");

            result="COLA ENLAZADA SIN NODO CABECERA\n";
            Nodo aux=anterior;  //para recorrer con el principio de colas
            int i=0;//contador para salto de linea
            while(aux!=null){
                result+=aux.elemento+" ";
                aux=aux.sgte; //lo movemos al sgte nodo
                if (++i%10 == 0) {
                    result+="\n"; //Salto de linea
                }
            }
            
        } catch (ColaException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public Nodo getNodo(Object elemento) throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        Nodo aux=anterior;  //para recorrer con el principio de colas
        while(aux!=null){
            if(aux.elemento.equals(elemento))
                return aux;
            aux=aux.sgte; //lo movemos al sgte nodo enlazado
        }//while
        return null; //el elemento no existe en la cola enlazada
    }
    
    public Nodo getNodo(int posicion) throws ColaException {
        if(this.isEmpty())
            throw new ColaException("La cola esta vacia");
        Nodo aux=anterior;  //para recorrer con el principio de colas
        int cont=1; //la primera posicion de la lista enlazada
        while(aux!=null){
            if(cont==posicion)
                return aux;
            cont++;
            aux=aux.sgte; //lo movemos al sgte nodo enlazado
        }//while
        return null; //el elemento no existe en la cola enlazada
    }
    
    
}//fin de la clase ColaEnlazada
