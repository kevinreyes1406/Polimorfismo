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
     * Crea un puesto vac�o <br>
     * <b>post: </b>Se cre� un puesto vac�o
     * @param nPuestoP - N�mero de puesto
     */
    public Puesto( int nPuestoP )
    {
    	
    	nPuestoP = 0;
    	
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Retorna el carro del puesto. Si no hay ning�n carro retorna null.
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
     * Indica si el puesto est� ocupado.
     * @return Retorna true si el puesto est� ocupado. Retorna false en caso contrario.
     */
    public boolean estaOcupado( )
    {
        return carro != null;
    }

    /**
     * Parquea un carro en el puesto <br>
     * <b>pre: </b>El puesto est� vac�o <br>
     * <b>post: </b> El puesto ahora est� ocupado por el carro carroP
     * @param carroP - Carro que se est� parqueando - carroP != null
     */
    public void parquearCarro( Carro carroP )
    {
        carro = carroP;
    }

    /**
     * Saca el carro del puesto. <br>
     * <b>post: </b>El puesto est� vac�o
     */
    public void sacarCarro( )
    {
        carro = null;
    }

    /**
     * Retorna el n�mero del puesto
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