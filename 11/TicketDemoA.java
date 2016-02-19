class Ticket extends Thread
{
	private static int ticks = 100;

	public void run()
	{
		while(ticks > 0)
		{
			System.out.println(currentThread().getName() + "....." +ticks);
			ticks--;
		}
	}
}

class TicketDemoA
{
	public static void main(String[] args)
	{
		Ticket t = new Ticket();
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();

		t.start();
		t1.start();
		t2.start();
	}
}