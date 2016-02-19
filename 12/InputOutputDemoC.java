class Resource
{
	private String name;
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name, String sex)
	{
		if(this.flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{

			}
		}

		this.name = name;
		this.sex = sex;

		this.flag = true;
		this.notify();
	}

	public synchronized void get()
	{
		if(!this.flag)
		{
			try
			{
				this.wait();
			}
			catch(Exception e)
			{

			}
		}
		System.out.println(this.name+"..."+this.sex);

		this.flag = false;
		this.notify();
	}
}

class Input implements Runnable
{
	private Resource r;
	Input(Resource r)
	{
		this.r = r;
	}

	public void run()
	{
		int x = 1;
		while(true)
		{
			if(x == 1)
			{
				r.set("Nike", "Man");
			}
			else
			{
				r.set("1111", "222");
			}
			x = (x+1)%2;
		}
	}
}

class Output implements Runnable
{
	private Resource r;
	Output(Resource r)
	{
		this.r = r;
	}

	public void run()
	{
		while(true)
		{
			r.get();
		}
	}
}

class InputOutputDemoC
{
	public static void main(String[] args)
	{
		Resource r = new Resource();

		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
	}
}
