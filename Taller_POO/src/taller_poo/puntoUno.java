package taller_poo;

import javax.swing.JOptionPane;

public class puntoUno {
    
    int radio;
    
    public void area(){   
        
        double area;
        radio=Integer.parseInt(JOptionPane.showInputDialog("Digite el radio de la esfera"));
        
        area=4*Math.PI*Math.pow(radio, 2);
        
        JOptionPane.showMessageDialog(null, "El area de la esfera es: "+ area);
        
    }
    
    public void volumen(){
        double volumen;
        
        volumen=4*Math.PI*Math.pow(radio, 3)/3;
        
        JOptionPane.showMessageDialog(null, "El volumen de la esfera es: "+ volumen);
        
    }
        
}
