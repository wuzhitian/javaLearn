class MainDemoA
{
	public static void main(String[] args)
	{
		System.out.println(args);    // [Ljava.lang.String;@2a139a55

		System.out.println(new String[0]); //[Ljava.lang.String;@15db9742
		// printArr(args);
	}
	public void printArr(String[] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		}
	}
}