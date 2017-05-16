/** 
 * File     : ColaArreglo.java
 * @author  : Prof. Gilberth Chaves Avila
 * Date     : 2017-05-09
 */

package Logica;
public class ColaArreglo implements Cola{
    //Atributos
    private Object cola[]; //un arreglo de objetos
    private int anterior, posterior; //para manejar los extremos de la cola

    public ColaArreglo(int n) {
        if(n<=0) System.exit(0); //se sale
        this.cola = new Object[n]; //creamos el arreglo con el tamano indicado
        this.posterior=n-1; //el indice del ultimo elemento del arreglo
        this.anterior = this.posterior;
    }
        
    @Override
    public int getSize() throws ColaException {
        return posterior-anterior;
    }

    @Override
    public void anular() {
        anterior=posterior;
    }

    @Override
    public boolean isEmpty() {
        return anterior==posterior;
    }

    private int getPosReal(int posicion){
        int i=0;
        while(cola[i]==null) i++;
        return posicion-i;
    }
    
    @Override
    public int getPosicion(Object elemento) throws ColaException {
        if(isEmpty()) throw new ColaException("La cola esta vacia");
        for(int i=anterior+1;i<=posterior;i++){
            if(cola[i].equals(elemento)){
                 return getPosReal(i);   
            }//if
        }//for
        return -1; //el elemento no existe en la cola arreglo
    }

    @Override
    public void encolar(Object elemento) throws ColaException {
        if(this.getSize()==cola.length)
          throw new ColaException("La cola esta llena. "
                  + "No se pueden encolar mas elementos");
        //cuando la cola esta vacia, no pasar por el for
        //la primera vez no pasa por el for
        for(int i=anterior;i<posterior;i++){
            cola[i] = cola[i+1];
        }//for
        
        //la primera vez encola en el extremo posterior
        //y mueve anterior una posicion a la izquierda
        cola[posterior] = elemento; //el elemento a encolar
        //anterior siempre va a quedar a la izq de posterior
        anterior--; //la idea es q anterior quede en un campo vacio del vector
    }

    @Override
    public Object desencolar() throws ColaException {
        if(this.isEmpty())
          throw new ColaException("La cola esta vacia");
        return cola[++anterior];
    }

    @Override
    public boolean existe(Object elemento) throws ColaException {
        if(isEmpty()) throw new ColaException("La cola esta vacia");
        for(int i=anterior+1;i<=posterior;i++){
            if(cola[i].equals(elemento)){
                 return true;   
            }//if
        }//for
        return false;
    }

    @Override
    public Object frente() throws ColaException {
        if(isEmpty()) throw new ColaException("La cola esta vacia");
        return cola[anterior+1];
    }

    @Override
    public String toString() {
        String result="";
        try {
            if(this.isEmpty())
                throw new ColaException("La cola esta vacia");
            result="COLA CON ARREGLOS ESTATICOS\n";
            for(int i=anterior+1;i<=posterior;i++){
                result +=cola[i]+" ";
                if ((i+1) % 10 == 0) {
                    result +="\n";
                }
            }//for
            
        } catch (ColaException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
