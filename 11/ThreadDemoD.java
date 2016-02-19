class Demo extends Thread
{
	private int tick = 100;
	public void run()
	{
		while(true)
		{
			if(tick > 0)
			{
				System.out.println("SSS--" + tick);
				tick--;
			}
			System.out.println("AAA");
		}
	}
}

class ThreadDemoD
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		Demo d1 = new Demo();
		Demo d2 = new Demo();

		d.start();
		d1.start();
		d2.start();
	}
}