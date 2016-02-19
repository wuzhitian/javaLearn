interface Inter
{
	void method();
}

class Test
{
	public static Inter foo()
	{
		return new Inter()
			   {
			   		public void method()
			   		{
			   			System.out.println("Test Inter");
			   		}
			   };
	}
}

class TestA
{
	static void foo()
	{
		new Object()
		{
			public void fooO()
			{
				System.out.println("DEDDDD");
			}
		}.fooO();
	}
}

class InnerClassDemoE
{
	public static void main(String[] args)
	{
		Test.foo().method();
		TestA.foo();
	}
}