package coinpurse;
/**
 * a coin with a monetary value and currency.
 * @author Charin Tantrakul
 */

public class Coin extends AbstractValuable{
	/*
	 * Set default currency of Coin object
	 */
	public static final String DEFAULT_CURRENCY = "Baht";
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
        super(value);     
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	super(value,currency);
    }
    
    /**
     * Get the informations of this coin.
     */
    public String toString() { 
    	if(super.currency.equals("Ringgit") && super.value<1){
    		return super.value*100+"-Sen";
    	}
    	return super.value+"-"+super.currency;
    }
    

    
}


