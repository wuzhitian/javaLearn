class Demo
{
	public int divide(int a, int b)
	{
		return a/b;
	}
}

class ExceptionDemoA
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		try
		{
			d.divide(4, 0);
		}
		catch(Exception e)
		{
			Log(e.getMessage());	// / by zero
			Log(e.toString());		//java.lang.ArithmeticException: / by zero
			e.printStackTrace();
		}
		System.out.println("Over");

	}

	public static void Log(String a)
	{
		System.out.println(a);
	}
}