package parqueadero.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Este panel sirve para mostrar la hora actual y realizar las diferentes operaciones sobre el parqueadero
 */
public class PanelOperaciones extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando ingresar
     */
    private final static String INGRESAR = "INGRESAR";

    /**
     * Comando salir
     */
    private final static String SALIR = "SALIR";

    /**
     * Comando avanzar
     */
    private final static String AVANZAR = "AVANZAR";

    /**
     * Comando extensión 1
     */
    private final static String OPCION_1 = "OPCION 1";

    /**
     * Comando extensión 2
     */
    private final static String OPCION_2 = "OPCION 2";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es una referencia a la ventana principal de la aplicación
     */
    private InterfazParqueadero interfazParqueadero;

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Es el campo de texto usado para mostrar la hora
     */
    private JTextField txtHora;

    /**
     * Es el botón para ingresar un carro al parqueadero
     */
    private JButton botonEntrar;

    /**
     * Es el botón para sacar un carro del parqueadero
     */
    private JButton botonSalir;

    /**
     * Es el botón para hacer avanzar una hora el reloj del parqueadero
     */
    private JButton botonAvanzarHora;

    /**
     * Es el botón para ejecutar la opción 1
     */
    private JButton botonOpcion1;

    /**
     * Es el botón para ejecutar la opción 2
     */
    private JButton botonOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b>Se construyó el panel
     * @param iParqueadero - Es una referencia a la ventana principal de la aplicación - iParqueadero!=null
     */
    public PanelOperaciones( InterfazParqueadero iParqueadero )
    {
        interfazParqueadero = iParqueadero;
        inicializar( );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializar y Organiza los componentes del panel
     */
    private void inicializar( )
    {
        setLayout( new FlowLayout( ) );

        txtHora = new JTextField( 10 );
        txtHora.setEditable( false );
        txtHora.setForeground( Color.BLUE );
        txtHora.setBackground( getBackground( ) );
        txtHora.setBorder( new TitledBorder( "Hora Actual" ) );
        add( txtHora );

        JPanel panelBotones = new JPanel( );

        botonEntrar = new JButton( );
        botonEntrar.setText( "Ingresar" );
        botonEntrar.setActionCommand( INGRESAR );
        botonEntrar.addActionListener( this );
        panelBotones.add( botonEntrar );

        botonSalir = new JButton( );
        botonSalir.setText( "Salir" );
        botonSalir.setActionCommand( SALIR );
        botonSalir.addActionListener( this );
        panelBotones.add( botonSalir );

        botonAvanzarHora = new JButton( );
        botonAvanzarHora.setText( "Avanzar" );
        botonAvanzarHora.setActionCommand( AVANZAR );
        botonAvanzarHora.addActionListener( this );
        panelBotones.add( botonAvanzarHora );

        botonOpcion1 = new JButton( );
        botonOpcion1.setText( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        panelBotones.add( botonOpcion1 );

        botonOpcion2 = new JButton( );
        botonOpcion2.setText( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        panelBotones.add( botonOpcion2 );

        add( panelBotones );
    }

    /**
     * Cambia la hora presentada <br>
     * <b>post: </b>Se está mostrando la nueva hora
     * @param hora - Nueva hora que debe mostrarse
     */
    public void cambiarHora( int hora )
    {
        txtHora.setText( hora + ":00" );
    }

    /**
     * Este método ejecuta las acciones adecuadas según el botón que haya sido presionado
     * @param evento Es el evento del click sobre el botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String command = evento.getActionCommand( );
        if( command.equals( INGRESAR ) )
        {
            interfazParqueadero.ingresar( );
        }
        else if( command.equals( SALIR ) )
        {
            interfazParqueadero.salir( );
        }
        else if( command.equals( AVANZAR ) )
        {
            interfazParqueadero.avanzar( );
        }
        else if( command.equals( OPCION_1 ) )
        {
            interfazParqueadero.reqFuncOpcion1( );
        }
        else if( command.equals( OPCION_2 ) )
        {
            interfazParqueadero.reqFuncOpcion2( );
        }
    }
}
