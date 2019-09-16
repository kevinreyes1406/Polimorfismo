package herencia;
import javax.swing.JOptionPane;
/**
* Clase Java para implementar una superclase padre
* que maneja los datos de un objeto de tipo persona
* de forma genérica
*/
public class Persona
{
/************************************/
/************************************/
//Atributos de la clase
protected String nombre;
protected String apellido;
protected int edad;
protected double peso;
/************************************/
/************************************/
/************************************/
//Constructor de la clase
public Persona() {
// TODO Auto-generated constructor stub
}
/************************************/
/************************************/
/************************************/
//Constructor sobrecargado
public Persona (String nombre, String apellido, int edad, double
peso)
{
this.nombre = nombre;
this.apellido = apellido;
this.edad = edad;
this.peso = peso;
}
/************************************/
/************************************/
/************************************/
//Métodos de Encapsulamiento
public String getNombre() {
return nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public String getApellido() {
return apellido;
}
public void setApellido(String apellido) {
this.apellido = apellido;
}
public int getEdad() {
return edad;
}
public void setEdad(int edad) {
this.edad = edad;
}
public double getPeso() {
return peso;
}
public void setPeso(double peso) {
this.peso = peso;
}
/************************************/
/************************************/
/************************************/
//Métodos genéricos para un objeto de tipo persona
//Método para mostrar los datos de identificación de la persona
public void imprimirDatosPersona ()
{
String datosPersona = "";
datosPersona = "Nombre " + nombre + "\n"
+ "Apellido: " + apellido + "\n" +
"Edad: " + edad + "\n" +
"Peso: " + peso;
JOptionPane.showMessageDialog(null,datosPersona);
definirEstadoPersona(edad);
}
//Método para definir el estado de la persona
public void definirEstadoPersona (int edad)
{
String estado = "";
if (edad < 18)
{
estado = "Menor de edad";
}
else
{
estado = "Mayor de edad";
}
JOptionPane.showMessageDialog(null,"La persona" + nombre
+ " " + apellido + " es " + estado);
}
//Método para leer un entero (int)
public int leerDatoTipoEntero (String mensaje)
{
int valor = 0;
try
{
valor =
Integer.parseInt(JOptionPane.showInputDialog
(null,mensaje));
return (valor);
}
catch (Exception errorIngreso)
{
errorIngreso.printStackTrace();
return (0);
}
}
//Método para leer un double
public double leerDatoTipoReal (String mensaje)
{
double valor = 0.0;
valor =
Double.parseDouble
(JOptionPane.showInputDialog(null,mensaje));
return (valor);
}
//Método para leer un booleano
public boolean leerDatoTipoBooleano (String mensaje)
{
boolean valor = false;
valor =
Boolean.parseBoolean
(JOptionPane.showInputDialog(null,mensaje));
return (valor);
}
public String leerDatoTipoCadena (String mensaje)
{
String valor = "";
valor = JOptionPane.showInputDialog(null,mensaje);
return (valor);
}
/************************************/
}
