//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
public abstract class Account{ //abstract class that will have child classes who will implement its absract methods 
	private Customer customer; //defining the instance varibales of Account
	private double balance;
	private int accountNumber;
	private int capacity;
	private static int lastAccountNumber = 9999; //private class variable lasAccountNumber that will help initalize the accountnumber for every new object
	public Transaction[] transactions;
	public final static int INITSIZE = 25; //class variable INITSIZE that will help initialize the capacity of the aray transactions in the constructor

	public Account(Customer customer, double balance){ // constructor with arrity two
		this.customer = customer; //initilizing all the varibles using the instance and class variables
		this.balance = balance;
		this.accountNumber = lastAccountNumber;
		lastAccountNumber++;
		capacity=INITSIZE;
		this.transactions = new Transaction[capacity]; //creating an array of transactions of type Transaction 
	}
	/*method reallocate that is called in order to double the capacity of transactions array when needed by creating a temporary reference variable for the array then creating a new one with the same
	reference variable, transactions, then for looping through the values of temp and copying them to the new bigger array, finally the old array temp is erased from the memory */
	public void reallocate(){
		Transaction[] temp = transactions; 
		capacity=capacity*2;
		transactions= new Transaction[capacity];
		for(int a = 0; a < temp.length; a++){
			transactions[a] = temp[a];
		temp=null;
		}
	}
	/* accessor method that returns balance*/
	public double getBalance(){
		return balance;
	}
	/* modifier method that re-initilaizes the balance given to the instance variable balance*/
	public void setBalance(double balance){
		this.balance=balance;
	}
	/* accessor method that returns accountnumber*/
	public int getAccountNumber(){
		return accountNumber;
	}
	/* accessor method that returns customer*/
	public Customer getCustomer(){
		return customer;
	}
	/* absract method to String that will be implemented in the child classes*/
	public abstract String toString();

	/* modifier method that re-initilaizes the customer given to the instance variable customer*/
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	/* absract methods that will be implemented in the child classes*/
	public abstract double deposit(double quantity);
	public abstract double withdraw(double reduce);
	public abstract double addInterest();
}