class DemoC
{
	public static void main(String[] args)
	{
		int x =56;

		int a = x & 15;

		int b = x >>= 4 & 15;

		int c = x >> 8;

		System.out.println(a+", "+b+", "+c);
	}
}