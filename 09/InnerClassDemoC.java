class Outer
{
	int x = 3;

	static int y = 4;

	void method(final int bbb)
	{
		final int zzz = 10;

		class Inner
		{
			void foo()
			{
				System.out.println(Outer.this.x+", "+Outer.y);
			}

			void foo1()
			{
				System.out.println(zzz + ", " + bbb);
			}
		}

		Inner ii = new Inner();
		ii.foo();
		ii.foo1();
	}
}

class InnerClassDemoC
{
	public static void main(String[] args)
	{
		Outer oo = new Outer();
		oo.method(665);	//3, 4      10, 665

		oo.method(332);	//3, 4      10, 332
		
	}
}