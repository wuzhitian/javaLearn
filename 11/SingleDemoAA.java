class Single
{
	private String name = "SingleAA";
	private Single()
	{

	};

	public String getName()
	{
		return this.name;
	}

	private static Single s = null;

	public static Single getInstance()
	{
		if(s == null)
		{
			synchronized(Single.class)
			{
				if(s == null)
				{
					s = new Single();
				}
			}
		}
		return s;
	}
}

class SingleDemoAA
{
	public static void main(String[] args)
	{
		Single s = Single.getInstance();
		System.out.println(s.getName());
	}
}