//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
import java.util.Date; /*lease refer to the CheckingAccount class for the comments since they are very similar classes, the only differences is the details in to String because its a different type of account
and the fees that change since this class doesnt have a checking fee and it has different inerest values but the rest is identical*/

public class SavingsAccount extends Account{

	private double fees;
	private String description;
	private double interest;
	private Date todaysdate;
	private int size;
	public final static byte DEPOSIT=0;
	public final static byte WITHDRAW = 1;
	public final static byte ADDEDINTEREST = 2;

	public SavingsAccount(Customer customer, double balance){
		super(customer, balance);
		size=0;
	}
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
	public double withdraw(double reduce){
		todaysdate= new Date();
		description="withdrawal of amount"+reduce;
		if (reduce<=this.getBalance()){
			fees=0;
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
			fees=getCustomer().getOverdraftPenalty();
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
			fees= getCustomer().getOverdraftPenalty();
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
			fees= this.getCustomer().getOverdraftPenalty();
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

		public double addInterest(){
			todaysdate= new Date();
			if (this.getBalance()<0){
				interest=0;
			}
			else{
				interest=this.getCustomer().getSavingsInterest()*this.getBalance();
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
		public  String toString(){
			String result;
			if (getCustomer() instanceof Senior){
			result = "The Senior: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Savings and has a balance of: " + getBalance()+"$";
			}
			else if (getCustomer() instanceof Adult){
			result = "The Adult: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Savings and has a balance of: " + getBalance()+"$";
			}
			else if (getCustomer() instanceof Student){
			result = "The Student: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Savings and has a balance of: " + getBalance()+"$";
			}
			else{
			result = "The Customer: " + getCustomer() +"\nHas an account with the account number: " + getAccountNumber() + " \nThis account is of type Savings and has a balance of: " + getBalance()+"$";
			}

				return result;
	}
}
	