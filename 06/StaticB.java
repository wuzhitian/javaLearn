class Person
{
	String name;

	private static void showA()
	{
		System.out.println("AA haha"); 
	}

	public static void showB()
	{
		showA();
	}

	public static void showC()
	{
		System.out.println("CC HEHE");
	}
}

class StaticB
{
	public static void main(String[] args)
	{
		// Person.showA();	// 错误: showA()被 private 修饰，仅能在Person内部被访问
		Person.showB();	//AA haha
		Person.showC();	//CC HEHE
	}
}