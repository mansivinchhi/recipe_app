/*
we are assuming that overdraft facility available current account holders
normaly overdraft (OD) is a seprate account.
*/

abstract class Account
{
	long accountNo=0; 
	double balance=0.0;
	Account()
	{
		this.accountNo=0; 
		this.balance=0.0;
	}
	Account(long x, double y)
	{
		this.accountNo=x; 
		this.balance=y;		
	}
	public abstract void checkBalance();			
}
class Saving extends Account
{
	
	double interestRate=0.0;
	final int minimumBalance=1000;
	Saving()
	{
		this.accountNo=0; 
		this.balance=0.0;
		this.interestRate=4.0;
	}
	Saving(long a,double b, double i)
	{
		this.accountNo=a; 
		this.balance=b;
		this.interestRate=i;
	}
	public void checkBalance(){
		System.out.println("\n*********************************************");
		System.out.println("\nSaving Acount Balance:"+this.balance);
		System.out.println("\n*********************************************");
	}	
	public void depositBalance(double x)
	{
		this.balance=this.balance+x;
	}
	public void withdrawBalance(double x)
	{
		if((this.balance-x) >= this.minimumBalance)
		{
			this.balance=this.balance-x;
		}
		else
		{
			System.out.println("\n*********************************************");
			System.out.println("\nYou can not withdraw "+x);
			System.out.println("\ninsufficient balance in your account,\n\nPlease maintain minumum balace "+this.minimumBalance);			
			System.out.println("\nSaving Account balance : "+this.balance);
			System.out.println("\n*********************************************");
			
		}
		
	}
}
class Current extends Account
{
	double overdraftLimit;	
	double overdraft;	
	Current()
	{
		this.accountNo=0; 
		this.balance=0.0;
		this.overdraftLimit=100000;
		this.overdraft=0;
	}
	Current(long a,double b, double o)
	{
		this.accountNo=a; 
		this.balance=b;
		this.overdraftLimit=o;
		this.overdraft=0;
	}
	public void checkBalance(){		
		System.out.println("\n*********************************************");
		System.out.println("\nCurrent Acount Balance:"+this.balance);		
		System.out.println("\n*********************************************");
	}	
	public void depositBalance(double x)
	{
		this.balance=this.balance+x;
	}
	public void withdrawBalance(double x)
	{
		if((this.balance-x) >= 0)
		{
			this.balance=this.balance-x;
		}
		else
		{
			System.out.println("\n*********************************************");		
			System.out.println("\nyou can not withdraw "+x+" balance");
			System.out.println("\ncurrent balance : "+this.balance);			
			System.out.println("\n*********************************************");
		}
	}
	public void takeOverDraft(double x)
	{
		//under development
		if((this.balance-x) >= 0)
		{
			this.balance=this.balance-x;
		}
		else
		{
			System.out.println("\n*********************************************");		
			System.out.println("\nyou can not withdraw "+x+" balance");
			System.out.println("\ncurrent balance : "+this.balance);			
			System.out.println("\n*********************************************");
		}
	}
}
class Ex19
{	
	public static void main(String args[])
	{
		/*
		Saving s = new Saving(1,1000,4);
		s.depositBalance(100000);
		s.checkBalance();
		s.withdrawBalance(5000000);
		*/
		
		Current c = new Current(1,1000,100000);
		//c.depositBalance(100000);
		//c.checkBalance();
		//c.withdrawBalance(1000);
		c.checkBalance();
		c.withdrawBalance(1000);
		c.checkBalance();
		
	}
}