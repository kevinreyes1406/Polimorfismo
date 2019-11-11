package parqueadero.mundo;

/**
 * Esta clase representa un puesto en el parqueadero
 */
public class Puesto
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /** Eventual carro en el puesto. Si no hay ninguno, carro == null */

    /** Numero del puesto dentro del parqueadero */
	public int nPuesto = 0;
	
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	Carro carro = new Carro(null, 0);
	
	Carro puesto;
    /**
     * Crea un puesto vacío <br>
     * <b>post: </b>Se creó un puesto vacío
     * @param nPuestoP - Número de puesto
     */
    public Puesto( int nPuestoP )
    {
    	
    	nPuestoP = 0;
    	
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Retorna el carro del puesto. Si no hay ningún carro retorna null.
     * @return carro
     */
    public Carro darCarro( )
    {
    	if(carro == null)
    	{
    		return null;
    	}
    	else
    	{
    		return carro;
    	}
    	
    }

    /**
     * Indica si el puesto está ocupado.
     * @return Retorna true si el puesto está ocupado. Retorna false en caso contrario.
     */
    public boolean estaOcupado( )
    {
        return carro != null;
    }

    /**
     * Parquea un carro en el puesto <br>
     * <b>pre: </b>El puesto está vacío <br>
     * <b>post: </b> El puesto ahora está ocupado por el carro carroP
     * @param carroP - Carro que se está parqueando - carroP != null
     */
    public void parquearCarro( Carro carroP )
    {
        carro = carroP;
    }

    /**
     * Saca el carro del puesto. <br>
     * <b>post: </b>El puesto está vacío
     */
    public void sacarCarro( )
    {
        carro = null;
    }

    /**
     * Retorna el número del puesto
     * @return nPuesto
     */
    public int darNumeroPuesto()
    {
    	
		return nPuesto;
    
    }

    /**
     * Indica si el carro tiene la placa recibida
     * @param placa
     * @return true si tiene la placa, false de lo contrario
     */
    public boolean tieneCarroConPlaca( String placa )
    {
        if( carro == null )
            return false;
        else if( carro.tienePlaca( placa ) )
            return true;
        else
            return false;
    }

}