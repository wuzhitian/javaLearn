class radix_C
{
	public static void main(String[] args)
	{
		toBin(22);
		toHex(878);
	}
	public static void toBin(int num)
	{
		trans(num, 2);
	}
	public static void toHex(int num)
	{
		trans(num, 16);
	}
	
	public static void trans(int num, int base)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E', 'F'};
		char[] arr = new char[32];
		int pos = arr.length;

		int offset = 0, tempBase = base;
		while(tempBase > 1)
		{
			offset++;
			tempBase >>= 1; 
		}

		while(num != 0)
		{
			int temp = num & (base - 1);

			arr[--pos] = chs[temp];

			num >>>= offset;
		}
		for(int x = pos; x < arr.length; x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println("");
	}
}