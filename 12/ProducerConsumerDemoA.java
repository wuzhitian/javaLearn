class Resource
{
	private String name;
	private int count;
	private boolean flag = true;

	public synchronized void set(String name)
	{
		while(flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{

			}
		}
		this.name = name + "--" + count++;
		
		System.out.println(Thread.currentThread().getName()+".Producer."+this.name);
		flag = true;
		this.notifyAll();
	}

	public synchronized void get()
	{
		while(!flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{

			}
		}

		System.out.println(Thread.currentThread().getName()+"..Consumer.."+this.name);
		flag = false;
		this.notifyAll();
	}
}

class Producer implements Runnable
{
	private Resource res;

	Producer(Resource r)
	{
		this.res = r;
	}
	public void run()
	{
		while(true)
		{
			res.set("+SHOP+");
		}
	}
}

class Consumer implements Runnable
{
	private Resource res;

	Consumer(Resource r)
	{
		this.res = r;
	}
	public void run()
	{
		while(true)
		{
			res.get();
		}
	}
}

class ProducerConsumerDemoA
{
	public static void main(String[] args)
	{
		Resource r = new Resource();

		Producer p = new Producer(r);
		Consumer c = new Consumer(r);

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}