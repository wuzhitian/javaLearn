class radix_A
{
	public static void main(String[] args)
	{
		toHex(50);
		toHex(3321);
		toHex(-3321);
	}
	public static void toHex(int num)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

		StringBuffer sb = new StringBuffer();
		while(num !=  0)
		{
			int temp = num & 15;
			sb.append(chs[temp]);
			num >>>= 4;
		}
		System.out.println(sb.reverse());
	}
}