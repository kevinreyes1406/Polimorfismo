package javaapplication51;
  
import java.util.*;
public class TablitaHash { 
    public static void main(String[] args) { 

	Hashtable donald  = new Hashtable();

	donald.put("Nombre","Donald");
	donald.put ("ciudad","Patolandia");

	System.out.println("Personaje : " + donald.get("Nombre"));
	System.out.println("Vive en: " + donald.get("ciudad"));
    }
}	
