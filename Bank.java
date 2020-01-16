//Amir Fanous - 300008851
//Branko Malaver-Vojvodic - 300048455
//Bank.java

/*
 * Bank.java
 *
 * Created on July 21, 2004, 1:23 AM
 */

public class Bank{
    private Account[] accounts;
    private int size;
    private int capacity;
    private Customer customer;
    private Account account;
    private int accounttype;
    
    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;    
    private static final int SENIOR = 0;
    private static final int ADULT = 1;    
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;
    
    /** Creates a new instance of Bank */
    public Bank(){
    capacity=INIT_CAPACITY;
    accounts=new Account[capacity];
    size=0;
    }
    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */
    public String addAccount(String customerName, int customerAge, int customerType, boolean isVIP, int typeAccount){
    
    Customer customer=null;
    accounttype=typeAccount;

       if(customerType==STUDENT){
            customer = new Student(customerName,customerAge);
        }
        else if(customerType==ADULT){
            customer = new Adult(customerName,customerAge);
        }
        else if(customerType==SENIOR){
            if(isVIP){
                customer = new Senior(customerName,customerAge,true);
            }
            else{
                customer = new Senior(customerName,customerAge,false);
            }
        }

        Account account=null;

        if (typeAccount==SAVINGS){ 
             account= new SavingsAccount(customer, 0);
        }
        else if (typeAccount==CHECKING){
             account= new CheckingAccount(customer, 0);
        }

        if (size<accounts.length){
            accounts[size] = account;
            size++;
        }
        else{
            reallocate();
            accounts[size] = account;
            size++;
        }
        return Integer.toString(account.getAccountNumber());


    }
    
    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    public String makeDeposit(String accountNumber, double amount){
        int index = find(accountNumber);
        accounts[index].deposit(amount);
        return Double.toString(accounts[index].getBalance());  
    }
    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */   
    public String makeWithdrawal(String accountNumber, double amount){
        int index = find(accountNumber);
        accounts[index].withdraw(amount);
        return Double.toString(accounts[index].getBalance());       
    }

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */    
    public String getAccount(String accountNumber){
        int index=find(accountNumber);
        return accounts[index].toString();


    }
    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
     */    
    private int find(String accountNumber){
        for(int i=0; i<accounts.length; i++){
            if (accounts[i].getAccountNumber()==Integer.parseInt(accountNumber)){
                return i;
            }
        }
        
        return -1;

    }

 /***********************************************************************


    /** You need to create private method : Allocate to allocate a new array to hold the accounts. */
    private void reallocate(){
        Account[] temp = accounts; 
        capacity=capacity*2;
        accounts= new Account[capacity];
            for(int a = 0; a < temp.length; a++){
                accounts[a] = temp[a];
            temp=null;
        }
    }
    /* public method that finds the account position in the array of accounts and if it this account exists, it calls the method addInterest in the class account and returns it as a string*/
    public String addInterest(String accountNumber){
        int index = find(accountNumber);
        if(index!=-1){
            accounts[index].addInterest();
        }
        String s=Double.toString(accounts[index].getBalance());
        return s;
    }
   

}



