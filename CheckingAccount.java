//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
import java.util.Date; //importing java.util.Date to be able to use the constructor method Date() of the class Date

public class CheckingAccount extends Account{ //the child class Checking account extends account (it is exactly the same to SavingsAccount except for the to String, the fees and the interest values that change)

	private double fees; //defining the instance variables
	private String description;
	private double interest;
	private Date todaysdate;
	private int size;
	public final static byte DEPOSIT=0; //defining and initializing the class constants
	public final static byte WITHDRAW = 1;
	public final static byte ADDEDINTEREST = 2;

	/* the constructor method CheckingAccount calls the constructor of the parent class and initializes the instance variable size to zero*/

	public CheckingAccount(Customer customer, double balance){ 
		super(customer, balance);
		size=0;
	}
	/* the method deposit is implemented after being initalized as an absract method in the parent class
	it initializes the date and the description then, it calls the modifier and accessor of balance to add the given amount to the balance, it also creates an object transaction 
	in the array of transactions and if the array is not big enough it calls the method realocate of its parent class to double the size of the array*/
	public double deposit(double quantity){
		todaysdate= new Date();
		description="deposit of amount"+quantity;
		setBalance(this.getBalance()+quantity);

		if (size<transactions.length){
			transactions[size] = new Transaction(DEPOSIT, quantity, todaysdate, fees, description);
			size++;
		}
		else{
			reallocate();
			transactions[size] = new Transaction(DEPOSIT, quantity, todaysdate, fees, description);
			size++;
		}
	return this.getBalance();             
				
	}
	/* the method withdraw is implemented after being initalized as an absract method in the parent class
	it initializes the date and the description then, it calls the modifier and accessor of balance to subtract the given amount from the balance and it substracts the fees that apply when making a withdrawal depending on the type of customer and
	if the amount that is withdrawn contains an overdraft or not, it also compares the amount withdrawn to the maximum overdraft. It assumes that the maximum overdraft is without includinf the fees and if the amount witdrawn is more than the balance by less or equal to 500$
	it also calls the methods in customer like canOverDraft and overDraftAmount to determine the fees and if the anything will be withdrawn. It does all this using complex if and else statements and it returns the balance in all cases. It also creates an object transaction 
	in the array of transactions and if the array is not big enough it calls the method realocate of its parent class to double the size of the array*/

	public double withdraw(double reduce){
		todaysdate= new Date();
		description="withdrawal of amount"+reduce;
		if (reduce<=this.getBalance()){
			fees=getCustomer().getCheckCharge();
			setBalance(this.getBalance()-reduce-fees);
			if (size<transactions.length){
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
				}
			else{
				reallocate();
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
			}
		}
		else if(getCustomer().canOverDraft(reduce-this.getBalance()) && this.getCustomer() instanceof Adult){
			fees=getCustomer().getOverdraftPenalty()+getCustomer().getCheckCharge();
			setBalance(this.getBalance()-reduce-fees);
			if (size<transactions.length){
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
				}
			else{
				reallocate();
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
			}
	
		}

		else if(!getCustomer().overDraftAmount(reduce-this.getBalance()) && getCustomer().canOverDraft(reduce-this.getBalance()) && this.getCustomer() instanceof Senior){
			fees= getCustomer().getOverdraftPenalty()+getCustomer().getCheckCharge();
			setBalance(this.getBalance()-reduce-fees);
			if (size<transactions.length){
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
				}
			else{
				reallocate();
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
			}
		}
		else if(getCustomer().overDraftAmount(reduce-this.getBalance()) && this.getCustomer() instanceof Senior){
			fees= this.getCustomer().getOverdraftPenalty()+getCustomer().getCheckCharge();
			setBalance(this.getBalance()-reduce-fees);
			if (size<transactions.length){
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
				}
			else{
				reallocate();
				transactions[size] = new Transaction(WITHDRAW, reduce, todaysdate, fees, description);
				size++;
			}
		}

		else{
			System.out.println("You cannot overdraft this amount");
		}
		
		return this.getBalance();
	}
	/*the method addInterest is implemented from the parent class and initializes todaysdate, calculates the interest on the balance of the account by using accesor methods for the constants needed and if the balance is less than zero than the interest is 0
	it also created a transaction object to store the details of the transaction and adds it to the array of transactions, if the arrray is too small it calls the method reallocate(). */
		public double addInterest(){
			todaysdate= new Date();

			if (this.getBalance()<0){
				interest=0;
			}
			else{
		
				interest=this.getCustomer().getCheckInterest()*this.getBalance();
			}
			setBalance(this.getBalance()+interest);

			if (size<transactions.length){
				transactions[size] = new Transaction(ADDEDINTEREST, interest, todaysdate, fees, description);
				size++;
				}
			else{
				reallocate();
				transactions[size] = new Transaction(ADDEDINTEREST, interest, todaysdate, fees, description);
				size++;
			}
			return this.getBalance();
			
	}
	/*the method toString is implemented in the child class of account checkingaccount and returns a string with the details of the account and the customer deoending on the type of account and customer
	it uses the accesor methods to access the info needed and returns the string*/
		public  String toString(){
			String result;
			if (getCustomer() instanceof Senior){
			result = "The Senior: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Checking and has a balance of: " + getBalance()+"$";
			}
			else if (getCustomer() instanceof Adult){
			result = "The Adult: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Checking and has a balance of: " + getBalance()+"$";
			}
			else if (getCustomer() instanceof Student){
			result = "The Student: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Checking and has a balance of: " + getBalance()+"$";
			}
			else{
			result = "The Customer: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Checking and has a balance of: " + getBalance()+"$";
			}

				return result;
	}
}
	