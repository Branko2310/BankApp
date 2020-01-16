//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
public class Senior extends Customer{ //this is a child class of the absract class customer (has to implement all the abstract methods of customer)
/*initalizing and defining the private, static and final variables for the class (constants). There are 2 of each since there are two cases for each constant, Senior or senior VIP*/
	private static final double SAVINGS_INTEREST_NORMAL = 0.08; 
	private static final double CHECK_INTEREST_NORMAL = 0.04;
	private static final double CHECK_CHARGE_NORMAL = 0.01;
	private static final double OVERDRAFT_PENALTY_NORMAL = 10.0;
	private static final double SAVINGS_INTEREST_VIP = 0.10;
	private static final double CHECK_INTEREST_VIP = 0.04;
	private static final double CHECK_CHARGE_VIP = 0.0;
	private static final double OVERDRAFT_PENALTY_VIP_UP_TO_100 = 0.0;
	private static final double OVERDRAFT_PENALTY_VIP_UP_TO_500 = 5.0;
	private double amount; //defining two extra instance varibles expecially for this class 
	private boolean isVIP;

	/*Constructor of arity 2 that calls the constructor of the parent class customer, it also initializes an extra varible called isVIP which determines what type of senior account will be created*/
	public Senior(String fullName, int age, boolean isVIP){ 
		super(fullName, age);
		this.isVIP=isVIP;
	}
	/*this method is implemented because this is a child class of Customer and in customer 
	it was an absract method but it will actually be used for this class to help determine the interval of the overdrafted amount and then return a boolean value depending on the amount inputed*/
	public boolean overDraftAmount(double amount){ 
		this.amount=amount;
		if (0<amount && amount<100){
			return true;
		}
		
		return false;
	}
	/* accesor method that returns the constant private variable SAVINGS_INTEREST... depending on which value of VIP is given in the constructor so it can be accesed outside of the class*/
	public double getSavingsInterest(){
	    if(isVIP){
			return SAVINGS_INTEREST_VIP;
		} 
		else{
			return SAVINGS_INTEREST_NORMAL;
		}
	}
	/* accesor method that returns the constant private variable CHECK_INTREST.. depending on which value of VIP is given in the constructor so it can be accesed outside of the class*/
	public double getCheckInterest(){
	    if(isVIP){
		    return CHECK_INTEREST_VIP;
		}
		else{
			return CHECK_INTEREST_NORMAL;
		}
	}
	/* accesor method that returns the constant private variable CHECK_CHARGE... depending on which value of VIP is given in the constructor so it can be accesed outside of the class*/
	public double getCheckCharge(){
		if(isVIP){
			return CHECK_CHARGE_VIP;
		}
		else{
			return CHECK_CHARGE_NORMAL;
		}
	}
	/* accesor method that returns the constant private variable OVERDRAFT_PENALTY... depending on which value of VIP is given in the constructor and which value of amount is initalized in 
	 the method overDraftAmount so it can be accesed outside of the class*/
	public double getOverdraftPenalty(){ 
		if(isVIP && overDraftAmount(amount)){
			return OVERDRAFT_PENALTY_VIP_UP_TO_100;
		}
		
		else if(isVIP && !overDraftAmount(amount)){
			return OVERDRAFT_PENALTY_VIP_UP_TO_500;
			}
		
		else{
			return OVERDRAFT_PENALTY_NORMAL;
		}
	}
}
