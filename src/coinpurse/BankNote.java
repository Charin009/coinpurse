package coinpurse;

public class BankNote extends AbstractValuable{
	public static final String DEFAULT_CURRENCY = "Baht";
//	private double value;
//	private String currency;
	private long serialNumber;
	
	/**
	 * new BankNote by given only value
	 * @param value is value of BanknNote object
	 */
	public BankNote(double value){
		super(value);
	}

	/**
	 * new BankNote by given value currency and serial number.
	 * @param value is value of BankNote object.
	 * @param currency is currency of BankNote object.
	 * @param serial is serial number of BankNote object.
	 */
	public BankNote(double value,String currency,long serial){
		super(value,currency);
		this.serialNumber=serial;
	}

    /**
     * Get the informations of this BankNote.
     */
    public String toString() { 
    	return super.value+"-"+super.currency+" ["+this.serialNumber+"]";
    }
}
