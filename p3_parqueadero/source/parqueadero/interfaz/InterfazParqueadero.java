package parqueadero.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import parqueadero.mundo.Parqueadero;
import parqueadero.mundo.Puesto;
import parqueadero.test.PuestoTest;

/**
 * Esta clase representa la ventana de interacci�n del Parqueadero
 */
public class InterfazParqueadero extends JFrame
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es el parqueadero que se est� administrando
     */
    private Parqueadero parqueadero;

    //-----------------------------------------------------------------
    // Componentes de la interfaz
    //-----------------------------------------------------------------

    /**
     * Es el panel que muestra el parqueadero
     */
    private PanelParqueadero panelParqueadero;

    /**
     * Es el panel donde se realizan las operaciones
     */
    private PanelOperaciones panelOperaciones;

    /**
     * Es el panel que muestra informaci�n sobre el parqueadero
     */
    private PanelInformacion panelInformacion;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
    
    Parqueadero parq = new Parqueadero(0);
    Puesto puesto = new Puesto(0);
    /**
     * Sirve para construir la interfaz
     */
    public InterfazParqueadero( )
    {
        // Crea el parqueadero con tarifa por hora de 1200
        parqueadero = new Parqueadero( 1200 );

        setTitle( "Parqueadero a $" + parqueadero.darTarifa( ) );

        // construir los paneles
        panelParqueadero = new PanelParqueadero( parqueadero );
        panelOperaciones = new PanelOperaciones( this );
        panelInformacion = new PanelInformacion( );

        // organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelParqueadero, BorderLayout.NORTH );
        getContentPane( ).add( panelOperaciones, BorderLayout.CENTER );
        getContentPane( ).add( panelInformacion, BorderLayout.SOUTH );

        setSize( 520, 450 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        refrescarInformacion( );

    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Sirve para hacer avanzar una hora el reloj del parqueadero.
     */
    public void avanzar( )
    {
        parqueadero.avanzarHora( );
        refrescarInformacion( );
    }

    /**
     * Este m�todo sirve para ingresar un carro al parqueadero. Debe preguntar la placa del carro e informar la posici�n donde debe estacionarse. Si no se puede parquear,
     * porque el parqueadero est� cerrado o porque no hay ning�n lugar disponible, entonces debe informar del error.
     */
    public void ingresar( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que est� ingresando" );
        if( placa != null )
        {
            int puesto = parqueadero.entrarCarro( placa );
            switch( puesto )
            {
                case Parqueadero.NO_HAY_PUESTO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero est� lleno..." );
                    break;
                case Parqueadero.CARRO_YA_EXISTE:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: ya hay un carro parqueado con la misma placa..." );
                    break;                    
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero est� cerrado..." );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Bienvenido:\n Su carro qued� parqueado en el puesto: " + ( puesto + 1 ) + "..." );
                    break;
            }
            refrescarInformacion( );
        }
        else
            JOptionPane.showMessageDialog( this, "Placa inv�lida: intente de nuevo..." );

    }

    /**
     * Este m�todo sirve para sacar un carro del parqueadero. Debe pedir la placa y luego contactar al parqueadero para sacar el carro y saber cu�nto debe cancelar. Si la
     * placa no corresponde a un carro que est� en el parqueadero entonces debe mostrar un error.
     */
    public void salir( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que est� saliendo" );
        if( placa != null )
        {
            int valor = parqueadero.sacarCarro( placa );
            switch( valor )
            {
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero est� cerrado..." );
                    break;
                case Parqueadero.CARRO_NO_EXISTE:
                    JOptionPane.showMessageDialog( this, "El carro de placa " + placa + " no est� en el parqueadero..." );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Placa: " + placa + " debe cancelar $ " + valor );
                    break;
            }
            refrescarInformacion( );
        }
        else
            JOptionPane.showMessageDialog( this, "Placa inv�lida: intente de nuevo..." );
    }

    /**
     * Este m�todo se encarga de actualizar los datos que se presentan en la interfaz
     */
    public void refrescarInformacion( )
    {
        panelParqueadero.refrescarParqueadero( );

        panelOperaciones.cambiarHora( parqueadero.darHoraActual( ) );

        int nPuestoN = 0;
		panelInformacion.actualizarDatos( parqueadero.calcularPuestosLibres(nPuestoN  ), parqueadero.darMontoCaja( ) );
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la opci�n 1
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = parqueadero.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Este m�todo ejecuta la opci�n 1
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = parqueadero.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Construye un parqueadero y ejecuta la aplicaci�n
     * @param args Son los par�metros de ejecuci�n de la aplicaci�n. No es necesario usarlos.
     */
    public static void main( String[] args )
    {

        InterfazParqueadero manejador = new InterfazParqueadero( );
        manejador.setVisible( true );
    }
}