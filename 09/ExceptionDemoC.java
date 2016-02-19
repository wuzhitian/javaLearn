class Demo
{
	public int divide(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException
	{
		int[] arr = new int[a];
		int aa = arr[a];

		return a/b;
	}
}


class ExceptionDemoC
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		try
		{
			d.divide(4, 0);
		}
		catch(ArithmeticException e)
		{
			Log(e.toString());
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			Log(e.toString());
		}
		catch(Exception e)
		{
			Log(e.toString());
		}
		Log("Over");
	}
	public static void Log(Object a)
	{
		System.out.println(a);
	}
}