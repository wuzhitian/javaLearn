class Bank
{
	private int sum;
	public synchronized void add(int n)
	{
		try
		{
			Thread.sleep(10);
		}
		catch(Exception e)
		{

		}
		sum += n;
		System.out.println(sum);
	}
}

class Cus implements Runnable
{
	Bank b = new Bank();
	public void run()
	{
		for(int x = 0; x < 3; x++)
		{
			b.add(100);
		}
	}
}

class BankDemoA
{
	public static void main(String[] args)
	{
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}