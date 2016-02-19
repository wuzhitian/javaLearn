class Outer
{
	private static int n = 110000;

	public void method()
	{
		Inner i = new Inner();
		i.foo();
	}

	class Inner
	{
		void foo()
		{
			System.out.println(n);
		}
	}

	static class Inner0
	{
		void foo0()
		{
			System.out.println(n);
		}
	}

	static class Inner1
	{
		static void foo1()
		{
			System.out.println(n);
		}
	}
}

class InnerClassDemoB
{
	public static void main(String[] args)
	{
		Outer o = new Outer();
		o.method();

		Outer.Inner i = new Outer().new Inner();
		i.foo();

		Outer.Inner0 i0 = new Outer.Inner0();
		i0.foo0();

		Outer.Inner1.foo1();
	}
}