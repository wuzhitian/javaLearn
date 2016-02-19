class Outer
{
	public int x = 3;

	class Inner
	{
		int x = 5;
		void foo()
		{
			int x = 7;
			System.out.println(x + " , " + this.x + " , " + Outer.this.x);
		}
	}
	public void method()
	{
		Inner i = new Inner();

		i.foo();
	}
}

class InnerClassDemoA
{
	public static void main(String[] args)
	{
		Outer o = new Outer();
		o.method();

		Outer.Inner i = new Outer().new Inner();
		i.foo();
	}
}