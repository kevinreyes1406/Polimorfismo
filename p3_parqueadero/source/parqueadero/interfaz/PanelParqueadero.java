package parqueadero.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import parqueadero.mundo.Parqueadero;

/**
 * Este panel sirve para mostrar el estado actual del parqueadero
 */
public class PanelParqueadero extends JPanel
{
    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Indicadores Puesto Parqueo
     */
    private JTextField puestos[];

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es una referencia al parqueadero que se está mostrando
     */
    private Parqueadero parqueadero;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b>Se construyó el panel
     * @param parq - Es una referencia al parqueadero que se va a mostrar
     */
    public PanelParqueadero( Parqueadero parq )
    {
        parqueadero = parq;
        inicializar( );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Organiza los componentes que se usan para representar el parqueadero
     */
    private void inicializar( )
    {
        setLayout( new GridLayout( 5, 20 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Parqueadero" ) ) );
        setPreferredSize( new Dimension( 10, 170 ) );
        puestos = new JTextField[parqueadero.calcularPuestosLibres(0)];
        for( int i = 0; i < parqueadero.calcularPuestosLibres(0); i++ )
        {
            puestos[ i ] = new JTextField( );
            puestos[ i ].setText( "" + ( i + 1 ) );
            puestos[ i ].setEnabled( false );
            puestos[ i ].setBackground( Color.BLUE );
            add( puestos[ i ] );
        }
    }

    /**
     * Este método se encarga de actualizar la representación del parqueadero <br>
     * <b>post: </b>Se actualizó la información mostrada del parqueadero
     */
    public void refrescarParqueadero( )
    {
        for( int i = 0; i < 87; i++ )
        {
            if( parqueadero.estaOcupado( i ) )
                puestos[ i ].setBackground( Color.RED );
            else
                puestos[ i ].setBackground( Color.BLUE );
        }
    }
}
