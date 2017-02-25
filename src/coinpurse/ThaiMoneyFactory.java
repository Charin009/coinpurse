package coinpurse;

/**
 * ThaiMoneyFactory use to create Thai money
 * @author Charin Tantrakul
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Create money and check that must be BankNote or Coin
	 */
	public Valuable createMoney(double value){
		if(isCoin(value)){
			return new Coin(value);
		}
		else if(isBank(value)){
			return new BankNote(value,"Baht",nextSerialNumber++);
		}
		else{
			throw new IllegalArgumentException();
		}

	}
	
	/**
	 * Check value with Thai Banknote s
	 * @param value value of Valuable
	 * @return true if value is same with Thai Banknotes
	 */
	private boolean isBank(double value){
		if(value >= 20){
			if(value == 20 || value == 50 || value == 100 || value == 500 || value==1000){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check value with Thai coins
	 * @param value value of Valuable
	 * @return true if value is same with Thai coins
	 */
	private boolean isCoin(double value){
		if(value < 20){
			if(value == 1 || value == 2 || value == 5 || value == 10){
				return true;
			}
		}
		return false;
	}
}
