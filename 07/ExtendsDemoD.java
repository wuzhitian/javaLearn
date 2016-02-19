class Fu
{
	Fu()
	{
		System.out.println("Fu run");
	}

	Fu(int x)
	{
		System.out.println("Fu run"+x);
	}
}

class Zi extends Fu
{
	Zi()
	{	
		//super();
		System.out.println("Zi run");
	}

	Zi(int num)
	{
		//super();
		System.out.println("Zi run"+num);
	}

	Zi(int x, int y)
	{
		super(x);
		System.out.println("Zi run"+y);
	}
}

class ExtendsDemoD
{
	public static void main(String[] args)
	{
		Zi z1 = new Zi(); //Fu run,  Zi run

		Zi z2 = new Zi(4);	//Fu run, Zi run4

		Zi z3 = new Zi(50, 80);	//Fu run50,  Zi run80
	}
}