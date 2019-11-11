package parqueadero.test;

import junit.framework.TestCase;
import parqueadero.mundo.Carro;
import parqueadero.mundo.Puesto;

/**
 * Pruebas para la clase Puesto
 */
public class PuestoTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * El puesto para el escenario 1
     */
    private Puesto puesto1;

    /**
     * El carro para escenario 1
     */
    private Carro carro1;

    /**
     * El puesto para el escenario 2
     */
    private Puesto puesto2;

    /**
     * El carro para el escenario 2
     */
    private Carro carro2;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa el escenario 1: un puesto y un carro, pero el puesto está vacío
     */
    private void setupEscenario1( )
    {
        carro1 = new Carro( "aaa111", 6 );
        puesto1 = new Puesto( 1 );
    }

    /**
     * Inicializa el escenario 2: un puesto y un carro parqueado en el puesto
     */
    private void setupEscenario2( )
    {
        carro2 = new Carro( "bbb222", 6 );
        puesto2 = new Puesto( 2 );
        puesto2.parquearCarro( carro2 );
    }

    /**
     * Probar que el método darCarro retorna lo esperado para un puesto vacío
     */
    public void testDarCarro1( )
    {
        setupEscenario1( );

        assertNull( "El puesto1 está vacío pero darCarro no retornó null", puesto1.darCarro( ) );
    }

    /**
     * Probar que el método darCarro retorna lo esperado para un puesto ocupado
     */
    public void testDarCarro2( )
    {
        setupEscenario2( );

        assertTrue( "El puesto 2 no retornó el carro que se esperaba", carro2 == puesto2.darCarro( ) );
    }

    /**
     * Probar el método darNumeroPuesto
     */
    public void testDarNumeroPuesto( )
    {
        setupEscenario1( );

        assertEquals( "El número retornado es incorrecto", 1, puesto1.darNumeroPuesto( ) );
    }

    /**
     * Probar el método estaOcupado
     */
    public void testEstaOcupado( )
    {
        setupEscenario1( );
        setupEscenario2( );

        assertFalse( "El puesto 1 debería estar desocupado", puesto1.estaOcupado( ) );
        assertTrue( "El puesto 2 debería estar ocupado", puesto2.estaOcupado( ) );
    }

    /**
     * Probar a parquear un carro en un puesto vacío
     */
    public void testParquearCarro( )
    {
        setupEscenario1( );

        assertNull( "El puesto 1 está vacío pero darCarro no retornó null", puesto1.darCarro( ) );
        puesto1.parquearCarro( carro1 );
        assertTrue( "El puesto 1 no retornó el carro que se esperaba: el carro no quedó parqueado", carro1 == puesto1.darCarro( ) );
        assertTrue( "El puesto 1 debería estar ocupado", puesto1.estaOcupado( ) );
    }

    /**
     * Probar a sacar un carro del puesto
     *  
     */
    public void testSacarCarro( )
    {
        setupEscenario2( );

        assertTrue( "El puesto 2 no retornó el carro que se esperaba", carro2 == puesto2.darCarro( ) );
        puesto2.sacarCarro( );
        assertNull( "El puesto 2 debería estar vacío pero darCarro no retornó null", puesto2.darCarro( ) );
        assertFalse( "El puesto 2 debería estar desocupado", puesto2.estaOcupado( ) );
    }

    /**
     * Probar el método tieneCarroConPlaca
     *  
     */
    public void testTieneCarroConPlaca( )
    {
        setupEscenario2( );

        assertFalse( "El puesto encontró la placa de un carro que no está parqueado ahí", puesto2.tieneCarroConPlaca( "aaa111" ) );
        assertTrue( "El puesto no encontró la placa del carro que está parqueado ahí", puesto2.tieneCarroConPlaca( "bbb222" ) );
    }
}
