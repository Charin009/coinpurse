package coinpurse;

/**
 * AbstractValuable make subclass have same behavior with this
 * @author Charin Tantrakul
 *
 */
public abstract class AbstractValuable implements Valuable{
	protected double value ;
	protected String currency;
	public static final String DEFAULT_CURRENCY = "Baht";
	
	/**
	 * Constructor to initialize value
	 * @param value is value of valuable object
	 */
	public AbstractValuable (double value){
		this.value = value;
		this.currency=DEFAULT_CURRENCY;
	}
	
	/**
	 * Constructor to initialize value and currency
	 * @param value is value of valuable object
	 * @param currency is currency of valuable object
	 */
	public AbstractValuable (double value , String currency){
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * compare this Valuable and other Valuable are less,greater than or equal.
	 * @return positive integer if this object is greater than other, negative if less than, otherwise zero.
	 */
	public int compareTo(Valuable valuable){
		if (valuable==null) return -1;
		if (this.value<valuable.getValue()) return -1;
		else if (this.value==valuable.getValue()) return 0;
		else return 1; 
	}
	
	/**
	 * Check this Valuable and other Valuable are same or not
	 */
	public boolean equals(Object obj){
		if(obj==null)return false;
    	if(this.getClass()!=obj.getClass())return false;
    	Valuable other = (Valuable) obj;
    	if(this.currency.equalsIgnoreCase(other.getCurrency())&&this.value==other.getValue())return true;
    	return false;
	}
	
	/**
	 * Get value of this Valuable
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * Get currency of this Valuable
	 */
	public String getCurrency(){
		return this.currency;
	}
}
