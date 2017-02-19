package coinpurse;
/**
 * a coin with a monetary value and currency.
 * @author Charin Tantrakul
 */

public class Coin implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
        this.value=value;
        this.currency=DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	this.value=value;
    	this.currency = currency;
    }
    
    /**
     * Get value of coin.
     * @return values as double.
     */
    public double getValue( ) { 
    	return this.value;
    } 

    /**
     * Get currency of coin.
     * @return currency of coin.
     */
    public String getCurrency() {
    	return this.currency;
    }
    
    /**
     * Compare coins and other coin
     * @param obj is other coin that user input to compare
     * @return true if other equal with that's coin. 
     */
    public boolean equals(Object obj) {
    	if(obj==null)return false;
    	if(this.getClass()!=obj.getClass())return false;
    	Coin other = (Coin) obj;
    	if(this.currency.equalsIgnoreCase(other.currency)&&this.value==other.value)return true;
    	return false;
    }
    
    /**
     * Compare this coin and other coin.
     * Which coin that have  least  value will come first.
     * @return 1 if this coin greater. -1 if this coin less than. and 0 if two coins are equal.  
     */
    public int compareTo(Valuable c){
    	if(c==null)return -1;
    	if(this.value<c.getValue())return -1;
    	else if(this.value==c.getValue())return 0;
    	else return 1; 
    }
    
    /**
     * Get teh informations of this coin.
     */
    public String toString() { 
    	return this.value+"-"+this.currency;
    }
    

    
}


