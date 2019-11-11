package parqueadero.interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Este panel sirve para mostrar información sobre el estado del parqueadero
 */
public class PanelInformacion extends JPanel
{

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta para el valor de la caja
     */
    private JLabel labValorCaja;

    /**
     * Etiqueta para el número de puestos vacíos
     */
    private JLabel labVacios;

    /**
     * Es el campo donde se muestra el valor de la caja
     */
    private JTextField txtValorCaja;

    /**
     * Es el campo donde se muestra el número de puestos vacíos
     */
    private JTextField txtVacios;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b>Se construyó el panel
     */
    public PanelInformacion( )
    {
        inicializar( );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Organiza el panel para mostrar el valor de la caja y el número de puestos vacíos
     */
    private void inicializar( )
    {
        labValorCaja = new JLabel( "Valor en Caja: " );

        txtValorCaja = new JTextField( 10 );
        txtValorCaja.setEditable( false );
        txtValorCaja.setForeground( Color.BLUE );
        txtValorCaja.setBackground( Color.WHITE );

        labVacios = new JLabel( "Puestos Vacíos: " );

        txtVacios = new JTextField( 10 );
        txtVacios.setEditable( false );
        txtVacios.setForeground( Color.BLUE );
        txtVacios.setBackground( Color.WHITE );

        GridBagLayout gridbag = new GridBagLayout( );
        setLayout( gridbag );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Información" ) ) );

        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labValorCaja, gbc );

        gbc = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtValorCaja, gbc );

        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labVacios, gbc );

        gbc = new GridBagConstraints( 1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtVacios, gbc );
    }

    /**
     * Actualiza la información mostrada <br>
     * <b>post: </b>Se actualizó la información mostrada
     * @param numVacios - Número de puestos vacíos
     * @param montoCaja - Cantidad de dinero en la caja
     */
    public void actualizarDatos( int numVacios, int montoCaja )
    {
        txtVacios.setText( "" + numVacios );
        txtValorCaja.setText( "$ " + montoCaja );
    }

}
