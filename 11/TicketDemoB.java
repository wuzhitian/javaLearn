class Ticket implements Runnable
{
	private int ticks = 100;

	public void run()
	{
		while(ticks > 0)
		{
			System.out.println(Thread.currentThread().getName() + "..." + ticks);
			ticks--;
		}
	}
}

class TicketDemoB
{
	public static void main(String[] args)
	{
		Ticket t = new Ticket();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}