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
	private int state = 3;
	public void run() throws LanPingException, MaoYanException
	{
		if(state == 2)
		{
			throw new LanPingException("LanPingLe!!!");
		}
		if(state == 3)
		{
			throw new MaoYanException("MaoYanLe!!!");
		}
		System.out.println("Computer Run Right!!!");
	}
	public void restart()
	{
		System.out.println("Computer Restarting!!!");
		this.state = 1;
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
	public static void prelect() throws NoPlanException
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
			System.out.println(e.toString());
			DoExercise();
			throw new NoPlanException("Can not complete plan!!!");
		}
		System.out.println("Prelect Right!");
	}
	public static void DoExercise()
	{
		System.out.println("DoSomeExercise!!!");
	}
}
class ExceptionDemoG
{
	public static void main(String[] args)
	{
		Teacher t = new Teacher("BIBI");
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