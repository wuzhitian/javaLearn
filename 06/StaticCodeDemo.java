class StaticCode
{
	int num = 999;

	static
	{
		System.out.println("StaticCode_A, ");
	}

	{
		System.out.println("StaticCode_B, ");
	}

	StaticCode()
	{
		System.out.println("StaticCode_D, ");
	}

	StaticCode(int num)
	{
		this.num = num;
		System.out.println(this.num + " StaticCode_E, ");
	}

	public static void show()
	{
		System.out.println("StaticCode.show run, ");
	}

	static void show_B()
	{
		System.out.println("StaticCode.show_B run, ");
	}

	static
	{
		System.out.println("StaticCode_C, ");
	}
}

class StaticCodeDemo
{
	static
	{
		System.out.println("StaticCodeDemo_A, ");
	}

	public static void main(String[] args)
	{


		System.out.println("StaticCodeDemo_B, ");

		StaticCode.show();
		StaticCode.show_B();

		StaticCode c = new StaticCode(88);

		c.show();
		c.show_B();
		// Staticcccc bb = null;
	}

	static
	{
		System.out.println("StaticCodeDemo_C, ");
	}
}

//StaticCodeDemo_A, 
//StaticCodeDemo_C, 
//StaticCodeDemo_B, 
//StaticCode_A, 
//StaticCode_C, 
//StaticCode.show run, 
//StaticCode.show_B run, 
//StaticCode_B, 
//88 StaticCode_E, 
//StaticCode.show run, 
//StaticCode.show_B run, 