package javaapplication50;

// Clase en la cual se almacena en un ArrayList, una lista de productos, permitiendo su manipulación.
//Se importan las librerías de java.util.* donde se concentran la mayor parte de las Clases del "Collection Framework". 

import java.util.*; 

public class Mercado { 

    public Mercado() {
    }

    public static void main(String args[]) { 

        // Se definen 5 instancias con el constructor de la clase Producto.

        Producto gaseosa = new Producto("gaseosa", 6); 
        Producto manzanas = new Producto("manzanas", 5);
        Producto paquetes = new Producto("paquetes", 2);  
        Producto lentejas = new Producto("lentejas", 2); 
        Producto aceite = new Producto("aceite", 2); 

        // Definir un ArrayList llamado lista

        ArrayList lista = new ArrayList(); 

        // Agregamos estas instancias al ArrayList con el método add 

        lista.add(gaseosa); 
        lista.add(manzanas);
        lista.add(lentejas); 
        lista.add(paquetes); 
         
        

        // Las listas inician en 0 (Cero) 
        // Indica el índice de inserción 

        lista.add(1, aceite); 
       // lista.add(aceite); 

        // Mostramos el número de objetos de la colección mediante el método size.

        System.out.println(" Lista del mercado con "+ lista.size()
                                                  +"  productos "); 

        // Se declara una instancia Iterator it la cual facilita recorrer los objetos, para extraer e imprimir sus valores 

        Iterator it = lista.iterator();

        //verifica si existe otro elemento con el método hasNext()

        while ( it.hasNext() ) { 
            Object objeto = it.next(); 
            Producto producto = (Producto)objeto; 
            System.out.println(producto); 
        } 
        
// Eliminar elemento de ArrayList. Se elimina el objeto con índice 2 con el método remove. Se muestra la nueva lista.
        
        lista.remove(1); 
        System.out.println(" Lista del mercado con " + lista.size() + " productos"); 

        // Definir Iterator para extraer e imprimir valores 

        Iterator it2 = lista.iterator(); 
        while ( it2.hasNext() ) { 
            Producto producto = (Producto)it2.next(); 
            System.out.println(producto); 
        } 
        
// Eliminar elemento de ArrayList. Se elimina el objeto con índice 2 con el método remove. Se muestra la nueva lista.
        
        lista.remove(0); 
        System.out.println(" Lista del mercado con " + lista.size() + " productos"); 

        // Definir Iterator para extraer e imprimir valores 

        Iterator it3 = lista.iterator(); 
        while ( it3.hasNext() ) { 
            Producto producto = (Producto)it3.next(); 
            System.out.println(producto); 
        } 
        
// Eliminar elemento de ArrayList. Se elimina el objeto con índice 2 con el método remove. Se muestra la nueva lista.
        
        lista.remove(0); 
        System.out.println(" Lista del mercado con " + lista.size() + " productos"); 

        // Definir Iterator para extraer e imprimir valores 

        Iterator it4 = lista.iterator(); 
        while ( it4.hasNext() ) { 
            Producto producto = (Producto)it4.next(); 
            System.out.println(producto); 
        } 

        
// Eliminar elemento de ArrayList. Se elimina el objeto con índice 2 con el método remove. Se muestra la nueva lista.
        
        lista.remove(1); 
        System.out.println(" Lista del mercado con " + lista.size() + " productos"); 

        // Definir Iterator para extraer e imprimir valores 

        Iterator it5 = lista.iterator(); 
        while ( it5.hasNext() ) { 
            Producto producto = (Producto)it5.next(); 
            System.out.println(producto); 
        } 

        // Eliminar todos los valores del ArrayList, Se eliminan todos los objetos mediante el método clear. 

        lista.clear(); 
        System.out.println(" Lista del mercado con " + lista.size() +" productos"); 
    }
    
}
