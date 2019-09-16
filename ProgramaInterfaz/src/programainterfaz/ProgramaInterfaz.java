package programainterfaz;

public class ProgramaInterfaz{

	public static void main(String arg[]) { 
        Persona pavaroti = new Persona(); 
        hacerCantar(pavaroti); 
       
        Canario piolin = new Canario(); 
        hacerCantar(piolin); 
       
        Burro mocho = new Burro();
        hacerCantar(mocho);
    } 

    public static void hacerCantar(PuedeCantar cantor) { 
        cantor.cantar(); 
    } 
}
