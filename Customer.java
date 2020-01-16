//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
public abstract class Customer{ //this is an absract class called customer that will be the parent to Senior, adult and student and they will implement its abstract method
	private String firstName; //defining the instance varibles
	private String lastName;
	private String fullName;
	private int age;
	private int customerNumber;
	private static int lastCustomerNumber = 9999; //defining the class variables 
	private static final int OVERDRAFT = 500; //final variable because its constant
	/*contructor arity two*/
	public Customer(String fullName, int age){ 
		setFullName(fullName);  //calling this method
		this.age = age; //initializing the varibles
		customerNumber = lastCustomerNumber;
		lastCustomerNumber++; //this increments the static varible everytime the constructor is called to create any sort of customer
	}
	/*this method takes a String fullName and checks if it has a space, if it does, it seperates the name into firstname and lastname using split when it encounters a space
	it creates an array of type String and stores the first and last name in this array*/
	public void setFullName(String fullName){ 
		firstName=null;
		lastName=null;
		if (fullName.contains(" ")==false){
			firstName=fullName;

		}
		else{
			String[] a = fullName.split(" "); // dividing wholeName into a list a of String limited by the space
			setFirstName(a[0]); // first will receive the String in the 0 position of a
			setLastName (a[1]); // second will receive the String in the 1 position of a
			}	
	}
/*accessor method that returns fullname*/
	public String getFullName(){
		return fullName;
	}
	/*accessor method that returns firstName*/
	public String getFirstName(){
		return firstName;
	}
	/*accessor method that returns lastName*/
	public String getLastName(){
		return lastName;
	}
	/*accessor method that returns age*/
	public int getAge(){
		return age;
	}
	/*accessor method that returns customerNumber*/
	public int getCustomerNumber(){
		return customerNumber;
	}
	/*modifier method that sets firstname to the string given to it*/
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	/*modifier method that sets lastname  to the string given to it*/
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	/*modifier method that sets age  to the string given to it*/
	public void setAge(int age){
		this.age = age;
	}
	/*boolean method equals that compares two objects of type customer and their variables*/
	public boolean equals(Customer other){
		if(firstName == other.firstName && lastName == other.lastName && age == other.age){
			return true;
		}
		else{
			return false;
		}
	}
	/* Checks if overdraft amount is below or equal to the final class variable OVERDRAFT and return a boolean value*/
	public boolean canOverDraft(double overdraft){
			return OVERDRAFT >= overdraft;
	}
	/*method to string that returns the customer info in a string*/
	public String toString(){
		String result;
		if (firstName!=null && lastName!=null){
		result = " \nWith the customer number: " + Integer.toString(customerNumber) + "\nName: " + firstName+" "+lastName + "\nAge: " + Integer.toString(age);
		}
		else if (firstName!=null) {
		result = " \nWith the customer number: " + Integer.toString(customerNumber) + "\nName: " + firstName+ "\nAge: " + Integer.toString(age);
		}
		else{
		result = " \nWith the customer number: " + Integer.toString(customerNumber) +"\nAge: " + Integer.toString(age);
		}
		return result;
	}
	/* creating all these abstract methods that will be implemented in the child classes because its an absract class*/
	public abstract boolean overDraftAmount(double amount);
	public abstract double getSavingsInterest();
	public abstract double getCheckInterest();
	public abstract double getCheckCharge();
	public abstract double getOverdraftPenalty();
}