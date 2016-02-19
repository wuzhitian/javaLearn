class Fu
{
	int num = 1;

	void methodA()
	{
		System.out.println("Fu method_A");
	}
	void methodB()
	{
		System.out.println("Fu method_B");
	}
}

class Zi extends Fu
{
	int num = 10;

	void methodA()
	{
		System.out.println("Zi method_A");
	}

	void methodC()
	{
		System.out.println("Zi method_C");
	}
}

class DuotaiDemoC
{
	public static void main(String[] args)
	{
		Fu z = new Zi();
		z.methodA();	//Zi method_A
		z.methodB();	//Fu method_B

		System.out.println(z.num);	//1

		Zi z1 = new Zi();
		System.out.println(z1.num);	//10


	}
}