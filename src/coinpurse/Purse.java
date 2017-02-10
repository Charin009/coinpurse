package coinpurse;

//TODO import ArrayList and Collections (so you can use Collections.sort())
import java.util.ArrayList;
import java.util.Collections;
/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author your name
 */
public class Purse {
	/** Collection of objects in the purse. */
	//TODO declare a List of Coins named "money".
	ArrayList<Coin> money=new ArrayList<Coin>(); 
	/** Capacity is maximum number of coins the purse can hold.
	 *  Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private double balance;

	/** 
	 *  Create a purse with a specified capacity.
	 *  @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse( int capacity ) {
		//TODO initialize the attributes of purse
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
		if(this.money!=null){
			for(Coin value: this.money){
				balance = balance+value.getValue();
			}
		}
		return 0.0; 
	}

	/**
	 * Return the capacity of the coin purse.
	 * @return the capacity
	 */
	//TODO write accessor method for capacity. Use Java naming convention.
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
		//TODO complete this method
		//TODO Don't Repeat Yourself: Avoid writing duplicate code.
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
		// if the purse is already full then can't insert anything.
		//TODO complete the insert method
		if(this.isFull())return false;
		else if(coin.getValue()<0)return false;
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
		//TODO don't allow to withdraw amount < 0
		if(amount)
		/*
		 * See lab sheet for outline of a solution, 
		 * or devise your own solution.
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		if ( amount > 0 )
		{	// failed. Don't change the contents of the purse.
			return null;
		}

		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return new Coin[0]; //TODO replace this with real code
	}

	/** 
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		//TODO complete this
		return "you forgot to write Purse.toString()";
	}

}
//TODO remove the TODO comments after you complete them.
//TODO When you are finished, there should not be any TODO. Including this one.
