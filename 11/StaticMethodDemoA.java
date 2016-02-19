class Ticket implements Runnable
{
	private static int ticks = 10000;

	public boolean flag = true;

	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(Ticket.class)
				{
					if(ticks > 0)
					{
						String name = Thread.currentThread().getName();
						System.out.println(name+" code."+ticks);
						ticks--;
					}
				}
				if(ticks == 0)
				{
					return;
				}
			}
		}
		else
		{
			while(true)
			{
				this.sell();
				if(ticks == 0)
				{
					return;
				}
			}
		}
	}
	public static synchronized void sell()
	{
		if(ticks > 0)
		{
			String name = Thread.currentThread().getName();
			System.out.println(name+" sell(). "+ticks);
			ticks--;
		}
	}
}

class StaticMethodDemoA
{
	public static void main(String[] args)
	{
		Ticket t = new Ticket();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		try
		{
			Thread.sleep(10);
		}
		catch(Exception e)
		{

		}
		t.flag = false;
		t2.start();
	}
}