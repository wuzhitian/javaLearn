class FooB
{
	public static void main(String[] args)
	{
		System.out.println(add(2,8,3));
		System.out.println(add(2,8));
	}
	public static int add(int a, int b, int c)
	{
		return a + b + c;
	}
	public static int add(int a, int b)
	{
		return a * b;
	}
}