package taller_poo;

import javax.swing.JOptionPane;

public class Principal {
    
    puntoUno esfera;
    PuntoDos tiquete,tiquete2,tiquete3,com;
    
    public Principal() {
        
        esfera = new puntoUno();
        tiquete = new PuntoDos();
        tiquete2= new PuntoDos();
        tiquete3 = new PuntoDos();
       
        
    }
    
    public static void main(String[] args) {
        
        menu();
        
    }
    
    public static void menu(){
        int rpt;
        
        Principal p = new Principal();
       
        do{
            int opc;

           opc= Integer.parseInt(JOptionPane.showInputDialog("Elija el ejercicio que desea realizar \n\n "
                                                             + "1. Area y Volumen de una esfera \n "
                                                             + "2. Tiquetes     \n"
                                                             + "3."));
           switch (opc){

               case 1:
                   
                   p.punto1();
                   
                   break;
               case 2:
                   
                   p.punto2();
                   
                   break;
               case 3:
                   break;
           }
           
          rpt=JOptionPane.showConfirmDialog(null, "Desea continuar?");
          
        }while(rpt==JOptionPane.YES_OPTION);
    }
    
    public void punto1(){
        
        esfera.area();
        esfera.volumen();
        
    }
    
    
    public void punto2(){        
        
        com = new PuntoDos();
        tiquete.pedir();
        tiquete2.pedir();
        tiquete3.pedir();
        JOptionPane.showMessageDialog(null, "El costo total de todos los tiquetes es: "+com.getTotal());
            
    }
    public void punto3(){
        
    }
    
}