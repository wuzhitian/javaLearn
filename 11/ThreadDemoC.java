class Demo extends Thread
{
	Demo(String name)
	{
		super(name);
	}

	public void run()
	{
		for(int x = 0; x < 60; x++)
		{
			System.out.println((Thread.currentThread()==this)+"..."+this.getName() +":"+x);
		}
	}
}

class ThreadDemoC
{
	public static void main(String[] args)
	{
		Demo d = new Demo("AA---");
		Demo d2 = new Demo("BB+++");
		d.start();
		d2.start();

		for(int x = 0; x < 60; x++)
		{
			System.out.println("Main:***"+x);
		}
	}
}