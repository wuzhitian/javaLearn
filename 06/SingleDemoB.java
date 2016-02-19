class SingleA
{
	private SingleA()
	{

	}
	private static SingleA c = new SingleA();

	public static SingleA getInstance()
	{
		return c;
	}
}

class SingleB
{
	private SingleB()
	{

	}

	private static SingleB c = null;

	public static SingleB getInstance()
	{
		if (c==null)
		{
			c = new SingleB();
		}
		return c;
	}
}