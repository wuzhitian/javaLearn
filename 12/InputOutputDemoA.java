class Resource
{
	String name;
	String sex;
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
				if(x == 1)
				{
					r.name = "Mike";
					r.sex = "max";
				}
				else
				{
					r.name = "1111";
					r.sex = "2222";
				}
				x = (x+1)%2;
			}
		}
	}
}

class OutInput implements Runnable
{
	private Resource r;
	OutInput(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			synchronized(r)
			{
				System.out.println(r.name+"...."+r.sex);
			}
		}
	}
}

class InputOutputDemoA
{
	public static void main(String[] args)
	{
		Resource r = new Resource();

		Input in = new Input(r);
		OutInput out = new OutInput(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
	}
}