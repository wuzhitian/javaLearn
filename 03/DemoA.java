class DemoA
{
	public static void main(String[] args)
	{
		int x = 88;

		int b = 1;

		int i = 0;

		String str = "";

		while(b > 0)
		{
			int temp = x >>= (i * 4);
			b = temp & 15;
			if(b > 9)
			{
				b = (char)(b+'A');
			}
			i++;
			str += (char)b;
			System.out.println(b);
			System.out.println((char)b);
			System.out.println(str);
		}
		System.out.println(str);
	}
}