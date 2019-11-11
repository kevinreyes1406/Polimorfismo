package parqueadero.test;

import junit.framework.TestCase;
import parqueadero.mundo.Carro;

/**
 * Clase de prueba para el carro
 */
public class CarroTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Carro representado
     */
    private Carro carro;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Prepara los datos de prueba del escenario1
     */
    public void setupEscenario1( )
    {
        carro = new Carro( "abc123", 12);
    }

    /**
     * Prueba que los datos básicos se recuperen adecuadamente
     */
    public String testDatos( )
    {
        setupEscenario1( );
        int hora = 0;
        String placa = carro.darPlaca();
        hora = carro.darHoraLlegada(hora);
        assertEquals( "La placa retornada por el carro es incorrecta", "abc123", placa );
        assertEquals( "La hora de llegada retornada por el carro es incorrecta", 12, hora );
		return placa;
    }

    /**
     * Prueba que el carro calcule correctamente el tiempo que lleva en el parqueadero
     */
    public void testTiempoEnParqueadero( )
    {
        setupEscenario1( );

        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 1, carro.darTiempoEnParqueadero( 12 ) );
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 2, carro.darTiempoEnParqueadero( 13 ) );
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 4, carro.darTiempoEnParqueadero( 15 ) );
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 6, carro.darTiempoEnParqueadero( 17 ) );
    }

    /**
     * Prueba que el carro verifique correctamente si la placa buscada es la suya
     *  
     */
    public void testTienePlaca( )
    {
        setupEscenario1( );

        assertFalse( "El carro dice que tiene una placa diferente a la suya", carro.tienePlaca( "zzz123" ) );
        assertTrue( "El carro dice que no tiene una placa igual a la suya", carro.tienePlaca( "abc123" ) );
    }
}
