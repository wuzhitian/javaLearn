class Ticket implements Runnable
{
	private int ticks = 1000;

	Object obj = new Object();

	public void run()
	{
		synchronized(obj)
		{
			while(ticks > 0)
			{
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println(Thread.currentThread().getName() + "+++..." + ticks);
				ticks--;
			}
		}
	}
}

class TicketDemoDD
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