class ExceptionDemoJ
{
	public static void func()
	{
		try
		{
			// throw new Exception();
			showExce();
			System.out.println("A");
		}
		catch (Exception e)
		{
			System.out.println("B");
		}
	}

	public static void showExce() throws Exception
	{
		throw new Exception();
	}
	public static void main(String[] args)
	{
		try
		{
			func();
		}
		catch(Exception e)
		{
			System.out.println("C");
		}
		System.out.println("D");
	}
}