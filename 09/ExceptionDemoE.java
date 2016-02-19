class FuShuException extends RuntimeException
{
	FuShuException(String msg)
	{
		super(msg);
	}
}

class Demo
{
	public int divide(int a, int b)
	{
		if(b == 0)
		{
			throw new FuShuException("Zero Zero Zero Zero!!!!");
		}

		return a/b;
	}
}


class ExceptionDemoE
{
	public static void main(String[] args)
	{
		Demo d = new Demo();
		d.divide(4, 0);
		System.out.println("over");
	}
}