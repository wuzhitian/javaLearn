class Demo
{
	int divide(int a, int b) throws Exception
	{
		return a/b;
	}

	int divide1(int a, int b)
	{
		return a/b;
	}
}

class ExceptionDemoB
{
	//throws Exception
	public static void main(String[] args)	
	{
		Demo d = new Demo();
		try
		{
			d.divide(4, 0);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}