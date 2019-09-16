/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Estudiante extends Persona {

    
    
    private String carnet, nombre ;
    private double promedioNotas;
    private int numeroMaterias;

    
    public Estudiante() {
    }
    
    public Estudiante (String nombre, String apellido, int edad, int peso,
    String carnet, double promedioNotas, int numeroMaterias){
        
        super(nombre, apellido, edad, peso);
        
        this.carnet = carnet ;
        this.numeroMaterias = numeroMaterias;
        this.promedioNotas = promedioNotas;
        
    }        
            
    

    public String getCarnet() {
        return carnet;
    }
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    public double getPromedioNotas() {
        return promedioNotas;
    }
    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }
    public int getNumeroMaterias() {
        return numeroMaterias;
    }
    public void setNumeroMaterias(int numeroMaterias) {
        this.numeroMaterias = numeroMaterias;
    }
    
    public double calcularNotas (double notas, int numeroMaterias){
        
        numeroMaterias=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de materias"));
        double aux=0,aux2=0;
        for (int i = 1; i <= numeroMaterias; i++) {
            
            notas=Integer.parseInt(JOptionPane.showInputDialog("Digite la calificacion de la materia "+i));
            
           aux=notas;
           aux2=aux+notas;
           
        }
        
        
        
        
        promedioNotas=aux2/numeroMaterias;
             
        return (promedioNotas);
    }
    public void imprimirPromedioNotas (String nombre, double promedioNotas){
JOptionPane.showMessageDialog(null,"El estudiante " + nombre +" tiene un promedio de " + promedioNotas);
}
    
public Estudiante ingresarDatosEstudiante (){
Estudiante nuevoEstudiante = new Estudiante();

String apellido = "";
int edad = 0;
double peso = 0.0;
double notas;

String carnet = "";
carnet = leerDatoTipoCadena("Ingrese el código del carnet: ");
nombre = leerDatoTipoCadena("Ingrese el nombre del estudiante: ");
apellido = leerDatoTipoCadena("Ingrese el apellido del estudiante: ");
edad = leerDatoTipoEntero("Ingrese la edad del estudiante: ");
peso = leerDatoTipoReal("Ingrese el peso del estudiante: ");

//Obtenemos los datos que no hacen parte de la clase
numeroMaterias = leerDatoTipoEntero("Ingrese el número de materias ");
notas = leerDatoTipoReal("Ingrese la nota de la materia: ");


//Calculamos 
promedioNotas = calcularNotas(  notas,  numeroMaterias);
//Definimos los datos para el constructor
nuevoEstudiante.setNombre(nombre);
nuevoEstudiante.setApellido(apellido);
nuevoEstudiante.setCarnet(carnet);
nuevoEstudiante.setEdad(edad);
nuevoEstudiante.setPeso(peso);
nuevoEstudiante.setPromedioNotas(promedioNotas);


//Retornamos el objeto
return (nuevoEstudiante);
}
    //Método para imprimir el reporte de status del empleado
public void imprimirReporteEstudiante()
{
//Usamos nuevamente la herencia para llamar los métodos
//que imprimen los datos del empleado
imprimirDatosPersona();
//Ahora imprimimos los datos propios del estudiante
JOptionPane.showMessageDialog(null,"El código laboral del empleado es: " + carnet);
//Asignación del salario
imprimirPromedioNotas(nombre, promedioNotas);

}
/************************************/
/************************************/
/************************************/

/************************************/
/************************************/
/************************************/
}

    
    

