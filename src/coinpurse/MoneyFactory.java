package coinpurse;

/**
 * MoneyFactory makes other class can create money 
 * @author Charin Tantrakul
 *
 */
public abstract class MoneyFactory {
	/**
	 * Subclass of MoneyFactory
	 */
	private static MoneyFactory instance;

	/**
	 * Get instance of MoneyFactory
	 * @return
	 */
	public static MoneyFactory getInstance(){
		if(instance == null){
			instance = new ThaiMoneyFactory();
		}
		return instance;
	}

	/**
	 * Set country of MoneyFactory 
	 * @param country is name of country that you want to create factory (contain only Thailand and Malaysia)
	 * @return getInstance()
	 */
	public static MoneyFactory setMoneyfactory(String country){
		if(country.equalsIgnoreCase("Thailand")) {
			instance = new ThaiMoneyFactory();
		}
		else if(country.equalsIgnoreCase("Malaysia")) {
			instance = new MalayMoneyFactory();
		}
		else {
			throw new IllegalArgumentException("Invalid Country");
		}
		return getInstance();
	}

	/**
	 * Create new Valueable object
	 * @param value is the value of object
	 * @return Valuable object 
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Create new Valuable object
	 * @param value is String of value
	 * @return Valuable object
	 */
	public Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
	}

}        
