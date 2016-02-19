class Demo
{
	public void foo() throws Exception
	{
		try
		{
			throw new Exception();
		}
		finally
		{
			System.out.println("Close Source!!!");
		}
	}
}

class FinallyDemoB
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		try
		{
			d.foo();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		System.out.println("Over");
	}
}