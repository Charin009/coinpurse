package coinpurse;

public class BankNote implements Valuable{
	private static long nextSerialNumber=1000000;
	public static final String DEFAULT_CURRENCY = "Baht";
	private double value;
	private String currency;
	private long serialNumber;
	
	public BankNote(double value){
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}
	public BankNote(double value,String currency){
		this.value = value;
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
     * Compare BankNote and other BankNote
     * @param obj is other BankNote that user input to compare
     * @return true if other equal with that's BankNote. 
     */
    public boolean equals(Object obj) {
    	if(obj==null)return false;
    	if(this.getClass()!=obj.getClass())return false;
    	BankNote other = (BankNote) obj;
    	if(this.currency.equalsIgnoreCase(other.currency)&&this.value==other.value)return true;
    	return false;
    }
    
    /**
     * Compare this BankNote and other BankNote.
     * Which BankNote that have  least  value will come first.
     * @return 1 if this BankNote greater. -1 if this BankNote less than. and 0 if two BankNote are equal.  
     */
    @Override
    public int compareTo(Valuable c){
    	if(c==null)return -1;
    	if(this.value<c.getValue())return -1;
    	else if(this.value==c.getValue())return 0;
    	else return 1; 
    }
    
    /**
     * Get the informations of this banknote.
     */
    public String toString() { 
    	return this.value+"-"+this.currency+" ["+this.serialNumber+"]";
    }
}
