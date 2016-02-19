class Outer
{
	class Inner
	{
		class Innner
		{
			int x = 0;
		}
	}
}

class InnerBodyDemo
{
	public static void main(String[] args)
	{
		System.out.println(new Outer().new Inner().new Innner().x);	//0
	}
}