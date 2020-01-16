//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
public class Student extends Customer{ //this is a child class of the absract class customer (has to implement all the abstract methods of customer)
	private static final double SAVINGS_INTEREST = 0.07;  //initalizing and defining the private, static anf final variables for the class (constants)
	private static final double CHECK_INTEREST = 0.03;
	private static final double CHECK_CHARGE = 0.02;
	
	/*Constructor of arity 2 that just calls the constructor of the parent class customer*/
	public Student(String fullName, int age){
		super(fullName, age);
	}
	/* accesor method that returns the constant private variable SAVINGS_INTEREST so it can be accesed outside of the class*/
	public double getSavingsInterest(){
		return SAVINGS_INTEREST;
	}
	/* accesor method that returns the constant private variable CHECK_INTEREST so it can be accesed outside of the class */
	public double getCheckInterest(){
		return CHECK_INTEREST;
	}
	/* accesor method that returns the constant private variable CHECK_CHARGE so it can be accesed outside of the class */
	public double getCheckCharge(){
		return CHECK_CHARGE;
	}
	/* accesor method that returns the constant private variable OVERDRAFT_PENALTY so it can be accesed outside of the class  but it returns 0 since a student cannot overdraft*/
	public double getOverdraftPenalty(){
		return 0;
	}
		/*boolean method that always returns true (it will not be used but it need to be implemented anyways since it is an absract method)*/
	public boolean overDraftAmount(double amount){
		return true;

	}
}