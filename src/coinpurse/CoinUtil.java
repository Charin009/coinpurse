package coinpurse;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * @author Charin Tantrakul
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> moneylist, String currency) {
		List<Valuable> filter = new ArrayList<Valuable>();
		if(currency!=null){
			for(Valuable c: moneylist){
				if(c.getCurrency().equalsIgnoreCase(currency)){
					filter.add(c);
				}
			}
		}
		return filter;
	}


	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	public static void sortByCurrency(List<Valuable> money) {
		Collections.sort(money,new Comparator<Valuable>(){
			public int compare(Valuable c1,Valuable c2){
				int compare = c1.getCurrency().compareToIgnoreCase(c2.getCurrency());
				return compare;
			}
		});
	}

	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 */
	public static void sumByCurrency(List<Valuable> money) {
		Map<String,Double> moneyMap = new HashMap<String,Double>();
		for(int i=0;i<money.size();i++){
			if(moneyMap.containsKey(money.get(i).getCurrency())){
				moneyMap.put(money.get(i).getCurrency(), moneyMap.get(money.get(i).getCurrency())+money.get(i).getValue());
			}
			else{
				moneyMap.put(money.get(i).getCurrency(),money.get(i).getValue());
			}
		}
		
		for(String key : moneyMap.keySet()) {
			System.out.println(key+" : "+moneyMap.get(key));
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. 
	 **@param currency is currency of coin and values is values of coin.
	 **
	 **/
	public static List<Coin> makeCoins(String currency, double ... values) {
		List<Coin> list = new ArrayList<Coin>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);

		}
		System.out.println();
	}
}
