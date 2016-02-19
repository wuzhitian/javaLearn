class Resource
{
	String name;
	String sex;
	boolean flag;
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
			synchronized(r)
			{
				if(r.flag)
				{
					try
					{
						r.wait();
					}
					catch(Exception e)
					{

					}
				}
				if(x == 1)
				{
					r.name = "Mike";
					r.sex = "Man";
				}
				else
				{
					r.name = "111111";
					r.sex = "22222";
				}
				x = (x+1)%2;

				r.flag = true;
				r.notify();
			}
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
			synchronized(r)
			{
				if(!r.flag)
				{
					try
					{
						r.wait();
					}
					catch(Exception e)
					{
						
					}
				}
				System.out.println(r.name+"..."+r.sex);

				r.flag = false;
				r.notify();
			}
		}
	}
}

class InputOutputDemoB
{
	public static void main(String[] args)
	{
		Resource r = new Resource();

		Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
	}
}
