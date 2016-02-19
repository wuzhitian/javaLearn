class NegativeException extends Exception
{
	NegativeException()
	{

	}

	private int value;
	NegativeException(String msg, int value)
	{
		super(msg);
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

}

class Demo
{
	public int divide(int a, int b) throws NegativeException, ArithmeticException
	{
		if(b < 0)
		{
			throw new NegativeException("Negative value", b);
		}
		return a/b;
	}
}

class ExceptionDemoD
{
	public static void main(String[] args)
	{
		Demo d = new Demo();

		try
		{
			d.divide(4, -1);
		}
		catch(NegativeException e)
		{
			System.out.println(e.toString());
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.toString());
		}
		System.out.println("Over");
	}
}