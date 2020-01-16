//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455


import java.util.Date; // importing Datem as we will have variables of this type
public class Transaction{ // class Transaction
	// instance variables
	private byte type; 
	private double amount;
	private Date date;
	private double fees;
	private String description;
	// constant variables to set the difference between the actions of depositing, withdrawing and adding interest
	public final static byte DEPOSIT=0; 
	public final static byte WITHDRAW = 1;
	public final static byte ADDEDINTEREST = 2;
	public Transaction(byte type, double amount, Date date, double fees, String description){ // constructor with arity 5
		// initializing the variables
		this.type = type; 
		this.amount = amount;
		this.date = date;
		this.fees = fees;
		this.description = description;
	}
	public byte getType(){ // method getType, it returns the type of the transaction
		return type;
	}
	public double getAmount(){ // method getAmount, it returns the amount of money involved in the transaction
		return amount;
	}
	public Date getDate(){ // method getDate, it returns the date of the transaction
		return date;
	}
	public double getFees(){ // method getFees, it returns the fees involved in the transaction
		return fees;
	}
	public String getDescription(){ // method getDescription, it returns the description of the transaction
		return description;
	}
	public void setAmount(double amount){ // method setAmount, it sets the amount to the double written inside the method 
		this.amount = amount;
	}
	public void setType(byte type){ // method setType, it sets the type of the transaction to the byte written inside the method
		this.type = type;
	}
	public void setDate(Date date){ // method setDate, it sets the date to the Date written inside the method
		this.date = date;
	}
	public void setFees(double fees){ // method setFees, it sets the fees in the transaction to the double written inside the method
		this.fees = fees;
	}
	public void setDescription(String description){ // method setDescription, it sets the description to the String written inside the method
		this.description = description;
	}
	public String processTransaction(){ // method processTransaction, it returns a string with the transaction information
		String result = "The type of the transaction is " + type + "\nThe amount is " + amount + "\nThe date was " + date + "\nThe fees are " + fees + "\nDescription: " + description;
		return result;
	}
}
