class LanPingException extends Exception
{
	LanPingException(String msg)
	{
		super(msg);
	}
}

class MaoYanException extends Exception{
	MaoYanException(String msg)
	{
		super(msg);
	}
}

class Computer
{
	private int state = 2;

	public void run() throws LanPingException, MaoYanException
	{
		if(state == 2)
		{
			throw new LanPingException("Blue Blue! Must be Restart!");
		}
		if(state == 3)
		{
			throw new MaoYanException("MaoYanLe!");
		}

		System.out.println("Computer Run Right!");
	}

	public void restart()
	{
		System.out.println("Computer Restarting!");
		state = 1;
	}
}

class NoPlanException extends Exception
{
	NoPlanException(String msg)
	{
		super(msg);
	}
}

class Teacher
{
	private String name;

	Teacher(String name)
	{
		this.name = name;
	}

	public void prelect() throws NoPlanException
	{
		Computer c = new Computer();
		try
		{
			c.run();
		}
		catch(LanPingException e)
		{
			System.out.println(e.toString());
			c.restart();
		}
		catch(MaoYanException e)
		{
			test();
			throw new NoPlanException("Computer Broken,"+e.getMessage()+", Can not complete plan!");
		}
		System.out.println("Prelect Right!");
	}

	public void test()
	{
		System.out.println("Do Some Exercise!!!");
	}
}


class ExceptionDemoF
{
	public static void main(String[] args)
	{
		Teacher t = new Teacher("BiBi");
		try
		{
			t.prelect();
		}
		catch(NoPlanException e)
		{
			System.out.println(e.toString());
		}
	}
}