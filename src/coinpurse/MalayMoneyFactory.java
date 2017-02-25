package coinpurse;

/**
 * MalaysiaMoneyFactory use to create Malaysia money
 * @author Charin Tantrakul
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 1000000;

	/**
	 * Create money and check that must be BankNote or Coin
	 */
	public Valuable createMoney(double value){
		if(isCoin(value)){
			return new Coin(value,"Ringgit");
		}
		else if(isBank(value)){
			return new BankNote(value,"Ringgit",nextSerialNumber++);
		}
		else{
			throw new IllegalArgumentException();
		}

	}
	
	/**
	 * Check value with Malaysia Banknotes
	 * @param value value of Valuable
	 * @return true if value is same with Malaysia Banknotes
	 */
	private boolean isBank(double value){
		if(value >= 1){
			if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check value with Malaysia coins
	 * @param value value of Valuable
	 * @return true if value is same with Malaysia coins
	 */
	private boolean isCoin(double value){
		if(value < 1){
			if(value == 0.05 || value ==0.10 || value == 0.20 || value == 0.50){
				return true;
			}
		}
		return false;
	}
}
