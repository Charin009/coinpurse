package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Charin Tantrakul
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Coin> money=new ArrayList<>(); 
	/** Capacity is maximum number of coins the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse( int capacity ) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse.
	 * This is the number of coins, not their value.
	 * @return the number of coins in the purse
	 */
	public int count() { 
		if(this.money!=null)return this.money.size();
		return  0;
	}

	/** 
	 *  Get the total value of all items in the purse.
	 *  @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance=0;
		for(Coin value: this.money){
			balance  +=value.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * @return the capacity
	 */
	public int getCapacity() { 
		return this.capacity;
	}

	/** 
	 *  Test whether the purse is full.
	 *  The purse is full if number of items in purse equals
	 *  or greater than the purse capacity.
	 *  @return true if purse is full.
	 */
	public boolean isFull() {
		if(this.capacity==this.money.size())return true;
		return false;
	}

	/** 
	 * Insert a coin into the purse.
	 * The coin is only inserted if the purse has space for it
	 * and the coin has positive value.  No worthless coins!
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert( Coin coin ) {
		if(this.isFull()||coin.getValue()<=0)return false;
		else this.money.add(coin); return true;
	}

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an array of Coins withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public Coin[] withdraw( double amount ) {
		List<Coin> money2 = new ArrayList<>();
		Collections.sort(this.money);
		Collections.reverse(this.money);
		if(amount<0){
			return null;
		}

		for(int i=0;i<this.money.size();i++){
			if(amount>=this.money.get(i).getValue()){
				amount = amount-this.money.get(i).getValue();
				money2.add(this.money.get(i));
			}	
		}
		if(amount==0){
			for(Coin c:money2){
				this.money.remove(c);
			}
			Coin[] moneyArray = new Coin[money2.size()];
			money2.toArray(moneyArray);
			return moneyArray;
		}
		return null;
	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		return this.money.size() + " coins with value " + this.getBalance();
	}

}

