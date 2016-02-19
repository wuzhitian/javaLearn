abstract class AbsDemo
{
	abstract void show();
}

class Outer
{
	int x = 10;

	public void foo()
	{
		new AbsDemo()
		{
			void show()
			{
				System.out.println("x=" + x);
			}
		}.show();

		new AbsDemo()
		{
			void show()
			{
				System.out.println("x=" + x);
			}
			void hh()
			{
				System.out.println("HHHSSS");
			}
		}.hh();

		new AbsDemo()
		{
			int xx = 666;
			void show()
			{
				System.out.println("xx="+xx);
			}

		}.show();
	}
}

class InnerClassDemoD
{
	public static void main(String[] args)
	{
		Outer oo = new Outer();
		oo.foo();	//x = 10
	}
}