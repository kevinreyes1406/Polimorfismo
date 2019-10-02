package javaapplication52;

/**
 *
 * @author kevin
 */
public class Hija extends RuntimeException {
    protected int valorInvalido;
public Hija(int valorInvalido) {
this.valorInvalido = valorInvalido;
}
public int getValorInvalido() {
return valorInvalido;
}

}
