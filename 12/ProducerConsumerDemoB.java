import java.util.concurrent.locks.*;

class Resource
{
	private String name;
	private int count;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();

	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();

	public void set(String name) throws InterruptedException
	{
		lock.lock();

		try
		{
			while(flag)
			{
				condition_pro.await();
			}
			this.name = name + "--" + count++;

			System.out.println(Thread.currentThread().getName()+"...Producer."+this.name);
			
			flag = true;
			condition_con.signalAll();
		}
		finally
		{
			lock.unlock();
		}
	}

	public void get() throws InterruptedException
	{
		lock.lock();

		try
		{
			while(!flag)
			{
				condition_con.await();
			}
			System.out.println(Thread.currentThread().getName()+".Consumer."+this.name);

			flag = false;
			condition_pro.signalAll();
		}
		finally
		{
			lock.unlock();
		}
	}
}

class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}

	public void run()
	{
		while(true)
		{
			try
			{
				r.set("Goods");
			}
			catch(Exception e)
			{
				
			}
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}

	public void run()
	{
		while(true)
		{
			try
			{
				r.get();
			}
			catch(Exception e)
			{

			}
		}
	}
}

class ProducerConsumerDemoB
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