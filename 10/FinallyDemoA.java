class FuShuException extends Exception
{
	FuShuException(String msg)
	{
		super(msg);
	}
}

class Demo
{
	public int divide(int a, int b) throws FuShuException
	{
		if(b < 0)
		{
			throw new FuShuException("FuShu!!!!");
		}
		return a/b;
	}
}

class FinalDemoA
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		try
		{
			System.out.println(d.divide(4, -1));
		}
		catch(FuShuException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			System.out.println("Finally!!!");
		}
		System.out.println("Over");
	}
}