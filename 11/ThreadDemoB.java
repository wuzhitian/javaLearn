class Demo extends Thread
{
	public void run()
	{
		for(int x=0; x < 60; x++)
		{
			System.out.println("DDDDDDDDDemo run--"+ x);
		}
	}
}

class ThreadDemoB
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		d.start();

		for(int x = 0; x < 60; x++)
		{
			System.out.println("Main run--"+x);
		}
	}
}