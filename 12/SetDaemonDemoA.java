class StopThread implements Runnable
{
	private boolean flag = true;

	public synchronized  void run()
	{
		while(flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{
				System.out.println(Thread.currentThread().getName()+"..Exception");
			}
			System.out.println(Thread.currentThread().getName()+".run");
		}
	}
}

class SetDaemonDemoA
{
	public static void main(String[] args)
	{
		StopThread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
				break;
			}
			System.out.println(Thread.currentThread().getName()+"--"+num);
		}
		System.out.println("over");
	}
}