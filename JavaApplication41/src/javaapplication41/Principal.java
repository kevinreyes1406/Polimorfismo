package javaapplication41;

public class Principal {
Interface in;
Interface in2;
    public static void main(String[] args) {
        
        Principal p = new Principal();
        p.metodo();
    }
    public void metodo(){
        in = new Implementadora();
        
        in2 = new Implementadora2();
        
        System.out.println(in.op(3, 2));
        System.out.println(in2.op(3, 2));
    }
    
}
