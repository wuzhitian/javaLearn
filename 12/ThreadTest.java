class ThreadTest
{
	public static void main(String[] args)
	{

		new Thread()
		{
			public void run()
			{
				for(int x = 0; x < 200; x++)
				{
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + "---" + x);
				}
			}
		}.start();

		for(int x = 0; x < 100; x++)
		{
			String threadName = Thread.currentThread().getName();

			System.out.println(threadName + "--x");
		}
		
		Runnable r = new Runnable()
		{
			public void run()
			{
				for(int x = 0; x < 300; x++)
				{
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + "----" + x);
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}