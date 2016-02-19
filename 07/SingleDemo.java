class Single
{
	private int width;
	private int height;

	public void setWidth(int width)
	{
		this.width = width;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	private Single()
	{

	}
	private static Single c = new Single();

	public static Single getInstance()
	{
		return c;
	}
}

class SingleDemo
{
	public static void main(String[] args)
	{
		Single s1 = Single.getInstance();
		s1.setWidth(10);
		s1.setHeight(200);
		System.out.println(s1.getWidth() +"..."+s1.getHeight());	//10...200

		Single s2 = Single.getInstance();
		System.out.println(s2.getWidth() +"..."+s2.getHeight());	//10...200

	}
}