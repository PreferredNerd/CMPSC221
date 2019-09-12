/*
* Author: Nicholas C. Birosik, Notary Public.
* Project Title: Savings Account Interest Calculator
* All rights reserved 2019.
*/

package savingsaccount;


/**
 *
 * @author Nicholas Birosik
 */
public class SavingsAccount {
    static float annualInterestRate;
    private String name;
    private float savingsBalance;
    public static int calculationMonth = 1;
    
    //Caluclates Monthly Intrest Rate by multiplying current balance by the monthly rate and adding it to the previous balance.
    public void calculateMonthlyInterest(){
        this.savingsBalance += this.savingsBalance * (annualInterestRate/12);
    }
    
    //Sets current interest rate after taking in a percentage as a float.
    public static void setInterestRate (float percentage){
        annualInterestRate = percentage/100;
    }
    
    //Returns Interest Rate as Float
    public static float getInterestRate(){
        return annualInterestRate;
    }
    
    //Allows user to visualize this object by it name: the account name
    public String toString(){
        return this.name;
    }
    
    //Allows for the Savings account balance to be set
    public void setSavingsBalance(float introBalance){
        this.savingsBalance = introBalance;
    }
   
    //Returns the savings account's balance
    public float getSavingsBalance(){
        return this.savingsBalance;
    }
    
    //Constructor for the savings account object. 
    public SavingsAccount (String name, float savingsBalance){
        this.name = name;
        setSavingsBalance(savingsBalance);
    }
    
    public static void main(String[] args){
        //Instantiate the two SavingsAccount Objects.
        SavingsAccount one = new SavingsAccount("Saver1", 2000);
        SavingsAccount two = new SavingsAccount("Saver2", 3000);
        //Create an output heading for the table
        System.out.printf("Savings Account Balances\nMonth\t%s\t%s\n", one, two);
        //Iterate through the two interest rate periods
        for (int interestPeriod = 4; interestPeriod <= 5; interestPeriod++){
            //Update the static variable to reflect the new interest rate for this period
            one.setInterestRate(interestPeriod); // Since annualInterestRate is static, this line of code will set annualIntrestRate for all SavingsAccount Objects!
            switch (interestPeriod){
                case 4:
                   //Iterate over all of the months (12) in the interestPeriod Year
                    for (int currentMonth = 1; currentMonth<12; currentMonth++){
                        //Calculate the new balance for both cases after next mothly interest cycle
                        one.calculateMonthlyInterest();
                        two.calculateMonthlyInterest();
                        //Print out the interest rates of both accounts, with the month
                        System.out.printf("%d\t%.2f\t%.2f\n",one.calculationMonth, one.getSavingsBalance(), two.getSavingsBalance());
                        //Unary operation to go to the next month
                        one.calculationMonth++;
                    }
                case 5:
                    //Perform the same operation but jsut once more!
                    one.calculateMonthlyInterest();
                    two.calculateMonthlyInterest();
                    System.out.printf("%d\t%.2f\t%.2f\n",one.calculationMonth, one.getSavingsBalance(), two.getSavingsBalance());
                    one.calculationMonth++;
            }
        }
    }  
}

