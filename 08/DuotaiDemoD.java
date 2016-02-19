class Fu
{
	static String str = "Fu static";
	String strA = "Fu strA";

	public void method_A()
	{
		System.out.println("Fu method_A");
	}
	public void method_B()
	{
		System.out.println("Fu method_B");
	}
}

class Zi extends Fu
{
	static String str = "Zi static";
	String strA = "Zi strA";

	public void method_A()
	{
		System.out.println("Zi method_A");
	}

	public void method_C()
	{
		System.out.println("Zi method_C");
	}
}

class DuotaiDemoD
{
	public static void main(String[] args)
	{
		Fu z1 = new Zi();

		z1.method_A();					//Zi method_A
		// z1.method_C();	//error
		System.out.println(z1.str);		//Fu static
		System.out.println(z1.strA);	//Fu strA

		Zi z2 = (Zi)z1;
		z2.method_C();			//Zi method_C
		System.out.println(z2.str);		//Zi static
		System.out.println(z2.strA);	//Zi strA

		Zi a1 = new Zi();
		System.out.println(a1.str);		//Zi static
		System.out.println(a1.strA);	//Zi strA

		Fu a2 = (Fu)a2;


	}
}