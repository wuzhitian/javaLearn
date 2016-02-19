class Demo implements Runnable
{
	public void run()
	{
		for(int x = 0; x < 70; x++)
		{
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+"..."+x);
		}
	}
}

class JoinDemoA
{
	public static void main(String[] args) throws Exception
	{
		Demo d = new Demo();

		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);

		t1.start();
		t1.join();

		t2.start();

		for(int x = 0; x < 33; x++)
		{
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+"---"+x);
		}
	}
}