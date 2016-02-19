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
				System.out.println("x = " + x);
			}
		}.show();

		new AbsDemo()
		{
			void show()
			{

			}
			void hh()
			{
				System.out.println("hh");
			}
		}.hh();

		new AbsDemo()
		{
			int x = 99;
			void show()
			{
				System.out.println(x + " , " + Outer.this.x);
			}
		}.show();
	}
}

class InnerClassDemoC
{
	public static void main(String[] args)
	{
		Outer o = new Outer();
		o.foo();
		// x = 10
		// hh
		// 99 , 10
	}
}