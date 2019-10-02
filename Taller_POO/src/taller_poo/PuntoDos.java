package taller_poo;

import javax.swing.JOptionPane;

public class PuntoDos {
    
    public PuntoDos() {
             
    }    
    
    private int numViaje;
    private int costo;
    private String fecha;
    private String hora;
    private String nombrePasajero;
    private int total;

    
    public int getNumViaje() {
        return numViaje;
    }
    public void setNumViaje(int numViaje) {
        this.numViaje = numViaje;
    }

   
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    
   
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }


    public String getNombrePasajero() {
        return nombrePasajero;
    }
    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }
    
     public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    
   public void pedir(){
          
        PuntoDos c = new PuntoDos();
        c.setNumViaje(Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de viaje")));
        c.setNombrePasajero(JOptionPane.showInputDialog("Digite su nombre"));
        c.setFecha(JOptionPane.showInputDialog("Digite la fecha"));
        c.setHora(JOptionPane.showInputDialog("Digite la hora"));
        c.setCosto(Integer.parseInt(JOptionPane.showInputDialog("Digite el costo")));
        JOptionPane.showMessageDialog(null, "Nombre: "+ c.getNombrePasajero()
                                         +"\nNum Viaje: "+c.getNumViaje()
                                         +"\nFecha: "+c.getFecha()
                                         +"\nHora: "+c.getHora()
                                         +"\nTotal: "+c.getCosto());
        c.setCosto(Integer.parseInt(JOptionPane.showInputDialog("Digite el costo")));
        JOptionPane.showMessageDialog(null, c.getCosto());
     
}

   
    
}
