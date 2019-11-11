package parqueadero.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import parqueadero.mundo.Parqueadero;
import parqueadero.mundo.Puesto;
import parqueadero.test.PuestoTest;

/**
 * Esta clase representa la ventana de interacción del Parqueadero
 */
public class InterfazParqueadero extends JFrame
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es el parqueadero que se está administrando
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
     * Es el panel que muestra información sobre el parqueadero
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
    // Métodos
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
     * Este método sirve para ingresar un carro al parqueadero. Debe preguntar la placa del carro e informar la posición donde debe estacionarse. Si no se puede parquear,
     * porque el parqueadero está cerrado o porque no hay ningún lugar disponible, entonces debe informar del error.
     */
    public void ingresar( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que está ingresando" );
        if( placa != null )
        {
            int puesto = parqueadero.entrarCarro( placa );
            switch( puesto )
            {
                case Parqueadero.NO_HAY_PUESTO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está lleno..." );
                    break;
                case Parqueadero.CARRO_YA_EXISTE:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: ya hay un carro parqueado con la misma placa..." );
                    break;                    
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está cerrado..." );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Bienvenido:\n Su carro quedó parqueado en el puesto: " + ( puesto + 1 ) + "..." );
                    break;
            }
            refrescarInformacion( );
        }
        else
            JOptionPane.showMessageDialog( this, "Placa inválida: intente de nuevo..." );

    }

    /**
     * Este método sirve para sacar un carro del parqueadero. Debe pedir la placa y luego contactar al parqueadero para sacar el carro y saber cuánto debe cancelar. Si la
     * placa no corresponde a un carro que está en el parqueadero entonces debe mostrar un error.
     */
    public void salir( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa del carro que está saliendo" );
        if( placa != null )
        {
            int valor = parqueadero.sacarCarro( placa );
            switch( valor )
            {
                case Parqueadero.PARQUEADERO_CERRADO:
                    JOptionPane.showMessageDialog( this, "Lo sentimos: el parqueadero está cerrado..." );
                    break;
                case Parqueadero.CARRO_NO_EXISTE:
                    JOptionPane.showMessageDialog( this, "El carro de placa " + placa + " no está en el parqueadero..." );
                    break;
                default:
                    JOptionPane.showMessageDialog( this, "Placa: " + placa + " debe cancelar $ " + valor );
                    break;
            }
            refrescarInformacion( );
        }
        else
            JOptionPane.showMessageDialog( this, "Placa inválida: intente de nuevo..." );
    }

    /**
     * Este método se encarga de actualizar los datos que se presentan en la interfaz
     */
    public void refrescarInformacion( )
    {
        panelParqueadero.refrescarParqueadero( );

        panelOperaciones.cambiarHora( parqueadero.darHoraActual( ) );

        int nPuestoN = 0;
		panelInformacion.actualizarDatos( parqueadero.calcularPuestosLibres(nPuestoN  ), parqueadero.darMontoCaja( ) );
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Este método ejecuta la opción 1
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = parqueadero.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Este método ejecuta la opción 1
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
     * Construye un parqueadero y ejecuta la aplicación
     * @param args Son los parámetros de ejecución de la aplicación. No es necesario usarlos.
     */
    public static void main( String[] args )
    {

        InterfazParqueadero manejador = new InterfazParqueadero( );
        manejador.setVisible( true );
    }
}