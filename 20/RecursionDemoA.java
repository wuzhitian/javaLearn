class RecursionDemoA
{
	public static void main(String[] args)
	{
		toBin(9);
		System.out.println(getSum(50));
	}
	public static void toBin(int num)
	{
		if(num > 0)
		{
			System.out.println(num%2);
			toBin(num/2);
		}
	}

	public static int getSum(int num)
	{
		if(num == 1)
		{
			return num;
		}
		else
		{
			return num + getSum(num - 1);
		}
	}
}