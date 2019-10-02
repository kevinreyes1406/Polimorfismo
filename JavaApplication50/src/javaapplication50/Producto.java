package javaapplication50;

//clase que define las características del producto

public class Producto { 
    
    private String nombre; 
    private int cantidad; 

    //constructor de la clase producto

    public Producto(String s, int i) { 
        
        nombre = s; 
        cantidad = i; 
        
    } 
    
    //método de la clase object
    
    public String toString(){ 
        
        return ("Nombre: "+getNombre()+" Cantidad: "+getCantidad()); 
        
    } 

    //métodos de encapsulamiento
    
    public String getNombre() { 
        return this.nombre; 
    } 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
} 


