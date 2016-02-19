class Test implements Runnable
{
	private boolean flag;

	Test(boolean flag)
	{
		this.flag = flag;
	}

	public void run()
	{
		if(flag)
		{
			synchronized (MyLock.a)
			{	
				System.out.println(Thread.currentThread().getName()+" if Mylock.a");
				synchronized(MyLock.b)
				{
					System.out.println(Thread.currentThread().getName()+" if Mylock.b");
				}
			}
		}
		else
		{
			synchronized (MyLock.b)
			{	
				System.out.println(Thread.currentThread().getName()+" else Mylock.b");
				synchronized(MyLock.a)
				{
					System.out.println(Thread.currentThread().getName()+ " else Mylock.a");
				}
			}
		}
	}
}

class MyLock
{
	public static Object a = new Object();
	public static Object b = new Object();
}

class DeadLockDemoA
{
	public static void main(String[] args)
	{
		Thread a = new Thread(new Test(true));
		Thread b = new Thread(new Test(false));
		a.start();
		b.start();
	}
}