package parqueadero.test;

import junit.framework.TestCase;
import parqueadero.mundo.Parqueadero;

/**
 * Clase de prueba para el Parqueadero
 */
public class ParqueaderoTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Parqueadero para el escenario 1
     */
    private Parqueadero parqueadero1;

    /**
     * Parqueadero para el escenario 2
     */
    private Parqueadero parqueadero2;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Construir el escenario 1
     */
    private void setupEscenario1( )
    {
        parqueadero1 = new Parqueadero( 1000 );
    }

    /**
     * Construir el escenario 2
     */
    private void setupEscenario2( )
    {
        parqueadero2 = new Parqueadero( 1000 );
        parqueadero2.entrarCarro( "111" );
        parqueadero2.entrarCarro( "222" );
    }

    /**
     * Verificar que la hora avance correctamente
     */
    public void testAvanzarHora( )
    {
        setupEscenario1( );

        int horaActual1 = parqueadero1.darHoraActual( );
        parqueadero1.avanzarHora( );
        int horaActual2 = parqueadero1.darHoraActual( );
        assertEquals( "La hora no avanza correctamente", horaActual1 + 1, horaActual2 );
    }

    /**
     * Verificar que el número de puestos libres se calcule correctamente
     */
    public void testCalcularPuestosLibres( )
    {
        setupEscenario1( );
        setupEscenario2( );

        assertEquals( "El parqueadero vacío no tiene el número correcto de puestos libres", Parqueadero.TAMANO, parqueadero1.calcularPuestosLibres(0 ) );

        assertEquals( "El parqueadero no-vacío no tiene el número correcto de puestos libres", Parqueadero.TAMANO - 2, parqueadero2.calcularPuestosLibres(0 ) );

        // Llenar el parqueadero
        for( int i = 3; i < Parqueadero.TAMANO; i++ )
        {
            parqueadero2.entrarCarro( "" + i + "" + i + "" + i );
            assertEquals( "El parqueadero no-vacío no tiene el número correcto de puestos libres", Parqueadero.TAMANO - i, parqueadero2.calcularPuestosLibres(0 ) );
        }

        // Verificar que despues de lleno el parqueadero no recibe más carros ni cambia el
        // número de puestos disponibles
        for( int i = 0; i < 10; i++ )
        {
            parqueadero2.entrarCarro( "aaa" + i + "" + i + "" + i );
            assertEquals( "El parqueadero lleno no tiene el número correcto de puestos libres", 0, parqueadero2.calcularPuestosLibres(i ) );
        }
    }

    /**
     * Verificar que la tarifa se pueda cambiar
     *  
     */
    public void testCambiarTarifa( )
    {
        setupEscenario1( );

        int viejaTarifa = parqueadero1.darTarifa( );
        int nuevaTarifa = 2000;

        parqueadero1.cambiarTarifa( nuevaTarifa );
        assertTrue( "La tarifa no fue modificada", viejaTarifa != nuevaTarifa && parqueadero1.darTarifa( ) == nuevaTarifa );
    }

    /**
     * Verificar que el monto en caja se calcule correctamente
     */
    public void testDarMontoCaja( )
    {
        setupEscenario1( );

        int tarifa = parqueadero1.darTarifa( );
        int montoEsperado = 0;
        assertEquals( "El monto inicial debería ser 0", montoEsperado, parqueadero1.darMontoCaja( ) );

        // Carro que entra y sale
        parqueadero1.entrarCarro( "111" );
        parqueadero1.sacarCarro( "111" );
        montoEsperado += tarifa;
        assertEquals( "Un carro durante una hora debería representar 1000", montoEsperado, parqueadero1.darMontoCaja( ) );

        // Carro que se demora una hora
        parqueadero1.entrarCarro( "222" );
        parqueadero1.avanzarHora( );
        parqueadero1.sacarCarro( "222" );
        montoEsperado += tarifa * 2;
        assertEquals( "Un carro durante dos horas debería representar 2000 más", montoEsperado, parqueadero1.darMontoCaja( ) );
    }

    /**
     * Verifica la entrada normal de carros
     */
    public void testEntrarCarro1( )
    {
        setupEscenario1( );

        // Parquear un carro
        int pos1 = parqueadero1.entrarCarro( "111" );
        assertFalse( "No se puedo parquear un carro en el parqueadero vacio", pos1 == Parqueadero.NO_HAY_PUESTO );
        assertFalse( "No se puedo parquear un carro en el parqueadero abierto", pos1 == Parqueadero.PARQUEADERO_CERRADO );
        assertTrue( "El puesto que se le asignó al carro aparece como no ocupado", parqueadero1.estaOcupado( pos1 ) );
        assertFalse( "No se puede sacar el carro", parqueadero1.sacarCarro( "111" ) == Parqueadero.CARRO_NO_EXISTE );
    }

    /**
     * Verifica que durante la entrada de carros a ninguno se le asigna un puesto que ya se había asignado
     */
    public void testEntrarCarro2( )
    {
        setupEscenario1( );

        // Verificar que a ningún otro carro se le asigna la misma posición de un carro ya
        // parqueado
        boolean[] vacios = new boolean[Parqueadero.TAMANO];

        for( int i = 0; i < Parqueadero.TAMANO * 2; i++ )
        {
            int posC = parqueadero1.entrarCarro( "ppp" + i );
            if( posC != Parqueadero.NO_HAY_PUESTO && posC != Parqueadero.PARQUEADERO_CERRADO )
            {
                assertFalse( "El nuevo carro se parqueó en la posición del otro carro", vacios[ posC ] );
                vacios[ posC ] = true;
            }
        }
    }

    /**
     * Verifica que durante la entrada de carros si el parqueadero está lleno siempre se informa de esto y que si hay un carro que sale entonces el siguiente carro que llegue
     * puede parquear
     */
    public void testEntrarCarro3( )
    {
        setupEscenario1( );

        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO * 2; i++ )
        {
            int posC = parqueadero1.entrarCarro( "ppp" + i );
            if( i > Parqueadero.TAMANO )
            {
                assertEquals( "Debe advertir que el parqueadero está lleno", posC, Parqueadero.NO_HAY_PUESTO );
            }
        }

        parqueadero1.sacarCarro( "ppp0" );
        int posNueva = parqueadero1.entrarCarro( "nuevo" );
        assertFalse( "El nuevo carro debería tener un puesto asignado", posNueva == Parqueadero.NO_HAY_PUESTO );
    }

    /**
     * Verifica que no se puede entrar carros cuando el parqueadero está cerrado
     */
    public void testEntrarCarro4( )
    {
        setupEscenario1( );

        while( parqueadero1.estaAbierto( ) )
            parqueadero1.avanzarHora( );

        int posC = parqueadero1.entrarCarro( "placa" );
        assertEquals( "Un carro entró al parqueadero cuando ya estaba cerrado", Parqueadero.PARQUEADERO_CERRADO, posC );
    }

    /**
     * Verifica que no se puede parquear dos carros con la misma placa en el parqueadero
     */
    public void testEntrarCarro5( )
    {
        setupEscenario1( );

        // Parquear un carro
        parqueadero1.entrarCarro( "111" );
        
        int posCarro2 = parqueadero1.entrarCarro( "111" );
        assertFalse( "Se parquearon dos carros con la misma placa", posCarro2 != Parqueadero.CARRO_YA_EXISTE );
    }
    
    /**
     * Verifica el método estaAbierto
     */
    public void testEstaAbierto( )
    {
        setupEscenario1( );

        for( int i = parqueadero1.darHoraActual( ); i < Parqueadero.HORA_CIERRE + 2; i++ )
        {
            int actual = parqueadero1.darHoraActual( );
            if( actual >= Parqueadero.HORA_INICIAL && actual < Parqueadero.HORA_CIERRE )
            {
                assertTrue( "El parqueadero está cerrado durante el tiempo que debería esta abierto", parqueadero1.estaAbierto( ) );
            }
            else
            {
                assertFalse( "El parqueadero está abierto en una hora en la que debería esta cerrado", parqueadero1.estaAbierto( ) );
            }

            parqueadero1.avanzarHora( );
        }
    }

    /**
     * Verificar que el estado ocupado o no de cada puesto se maneja correctamente
     */
    public void testEstaOcupado( )
    {
        setupEscenario1( );

        // Verificar que las posiciones que se asignan quedan marcadas como ocupadas
        int[] posiciones = new int[Parqueadero.TAMANO];

        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            posiciones[ i ] = parqueadero1.entrarCarro( "ppp" + i );
            assertTrue( "La posición del nuevo carro no aparece marcada como ocupada", parqueadero1.estaOcupado( posiciones[ i ] ) );
        }

        // Sacar todos los carros del parqueadero y verificar que todas las posiciones
        // quedaron marcadas como vacias
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            parqueadero1.sacarCarro( "ppp" + i );
            assertFalse( "La posición del carro que salió no aparece marcada como vacía", parqueadero1.estaOcupado( posiciones[ i ] ) );
        }
    }

    /**
     * Verificar sacarCarro
     *  
     */
    public void testSacarCarro1( )
    {
        setupEscenario1( );
        int tarifa = parqueadero1.darTarifa( );

        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            parqueadero1.entrarCarro( "ppp" + i );
        }

        // Sacar todos los carros del parqueadero en la misma hora
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            int valor = parqueadero1.sacarCarro( "ppp" + i );

            assertFalse( "No se encontró un carro que estaba parqueado", valor == Parqueadero.CARRO_NO_EXISTE );
            assertEquals( "La tarifa cobrada es incorrecta", tarifa, valor );
        }

        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            parqueadero1.entrarCarro( "ppp" + i );
        }

        parqueadero1.avanzarHora( );

        // Sacar todos los carros del parqueadero después de una hora
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            int valor = parqueadero1.sacarCarro( "ppp" + i );

            assertFalse( "No se encontró un carro que estaba parqueado", valor == Parqueadero.CARRO_NO_EXISTE );
            assertEquals( "La tarifa cobrada es incorrecta", tarifa * 2, valor );
        }
    }

    /**
     * Verificar sacarCarro con carros que no estaban en el parqueadero
     */
    public void testSacarCarro2( )
    {
        setupEscenario1( );

        // Sacar carros del parqueadero que no estaban parqueados
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            int valor = parqueadero1.sacarCarro( "ppp" + i );
            assertTrue( "Se encontró un carro que no estaba parqueado", valor == Parqueadero.CARRO_NO_EXISTE );
        }
    }

    /**
     * Verifica que no se puede sacar carros cuando el parqueadero está cerrado
     */
    public void testSacarCarro4( )
    {
        setupEscenario2( );

        while( parqueadero2.estaAbierto( ) )
            parqueadero2.avanzarHora( );

        int posC = parqueadero2.sacarCarro( "111" );
        assertEquals( "Un carro entró al parqueadero cuando ya estaba cerrado", Parqueadero.PARQUEADERO_CERRADO, posC );
    }

}
