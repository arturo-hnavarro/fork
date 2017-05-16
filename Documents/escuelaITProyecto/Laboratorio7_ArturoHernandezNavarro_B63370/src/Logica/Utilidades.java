/**
 * File     : ListaEnlazadaDoble.java
 *
 * @author : Prof. Gilberth Chaves Avila Date : 2017-04-26
 */
package Logica;

/**
 *
 * @author Profesor Gilberth Chaves Avila
 */
public class Utilidades {

    public static boolean esMayorQ(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "entero":
                int x = (int) a;
                int y = (int) b;
                return x > y;
            case "string":
                String p = (String) a;
                String q = (String) b;
                return p.compareToIgnoreCase(q) > 0;
            case "char":
                Character t = (Character) a;
                Character u = (Character) b;
                return t.compareTo(u) > 0;
        }//switch
        return false;
    }

    //Este metodo devuelve el tipo almacenado en la lista enlazada
    private static String instanceOf(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return "entero";
        }
        if (a instanceof String && b instanceof String) {
            return "string";
        }
        if (a instanceof Character && b instanceof Character) {
            return "char";
        }
        return "desconocido";
    }

    public static char obtenerLetraAleatorio() {
        int caracter = (int) Math.floor(Math.random() * (65 - 122 + 1) + 122);
        //Genero un valor para los caracteres correspondientes al ASCII
        if (caracter >= 91 && caracter < 97) {
            return obtenerLetraAleatorio(); //Si es un caracter especial genero una nueva letra
        } else {
            return (char) caracter;
        }
    }
    public static int obtenerNumeroAleatorio(){
        return (int)( (Math.random()*1000));
    }

}
