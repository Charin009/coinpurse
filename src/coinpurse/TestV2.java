package coinpurse;
import java.util.ArrayList;
import java.util.Collections;
/**
*This class is my fault this class don't use .I creat it to test my code.
*
*@author Charin Tantrakul.
*/
public class TestV2 {
 public static void main(String[]arg){
	 Purse purse = new Purse( 3 );
	 int[] a = {1,2,3,4,5,6,7,8};
	 System.out.println(purse.getBalance( ) );
	 System.out.println(purse.count( ) );
	 System.out.println(purse.isFull( ) );
	 System.out.println(purse.insert(new Coin(5)));
	 System.out.println(purse.insert(new Coin(10)) );
	 System.out.println(purse.insert(new Coin(0)) );
	 System.out.println(purse.insert(new Coin(1)) );
	 System.out.println(purse.insert(new Coin(5))) ;
	 System.out.println(purse.count( )) ;
	 System.out.println(purse.isFull( )) ;
	 System.out.println(purse.getBalance( ) );
	 System.out.println(purse.toString() );
	 System.out.println(purse.withdraw(12) );
	 System.out.println(purse.withdraw(11));
	 System.out.println(purse.isFull( )) ;
	 System.out.println(purse.getBalance( ) );
 }
}
