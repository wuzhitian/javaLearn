class MainDemoC
{
	public static void main(String[] args)
	{
		String[] arr = {"AA", "BB", "CC", "DD", "EE"};
		MainTest.main(arr);	//[AA, BB, CC, DD, EE]
	}
}

class MainTest
{
	public static void main(String[] args)
	{
		System.out.print("[");
		for(int x = 0; x < args.length; x++)
		{
			if(x == args.length - 1)
			{
				System.out.println(args[x]+"]");
			}
			else
			{
				System.out.print(args[x]+", ");
			}
		}
	}
}