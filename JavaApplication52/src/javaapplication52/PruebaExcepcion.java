package javaapplication52;

import java.util.Scanner;

public class PruebaExcepcion{  
	
public static void main(String args[]){
   
    formatoNumero2();
    desborde();
    aritmetico();
    ejercicio();
}   

//excepción tratada
public static void formatoNumero2(){
 
 int numero;   
 String cadena="  1";   
 	try{   
    		numero = Integer.parseInt(cadena);   
 	}   
 catch(NumberFormatException ex){   
 System.out.println("No es un número, es una cadena de texto."+ex.getMessage());   
    
 	}   
                 }
public static void desborde(){
 
 int v[]= new int[3]; 
 try{
		for(int i =0; i<5;i++){
		v[i]=i;
                }
 }
                catch(ArrayIndexOutOfBoundsException ex){   
 System.out.println("el for es mas grande que el vector"+ex.getMessage());
                        }
}                  
 	
public static void aritmetico(){
 
int numero=5, resultado;
try{
resultado= numero/0;
}
 catch(ArithmeticException ex){   
 System.out.println("el resultado es "+ex.getMessage());

 	}

}

    public static void ejercicio() {
        int a, b;
        double div;
        Scanner bot1= new Scanner(System.in);
        System.out.println("digite un numero entero");
        a=bot1.nextInt();
        System.out.println("digite un numero entero");
        b=bot1.nextInt();
       try{
        div=a/b;
        System.out.println(div);
       }
       catch(ArithmeticException | Hija ex ){
 System.out.println("el resultado es "+ex.getMessage());
    }
       if (a!=b){
throw new NumberFormatException();

        }
}
}
