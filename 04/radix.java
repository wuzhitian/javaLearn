class radix
{
	public static void main(String[] args)
	{
		toBin_A(22);
		toBin(22);
		System.out.println(Integer.toBinaryString(22));
		toHex(878);
		toHex_A(878);
		toHex_B(-8788);
	}
	public static void toBin(int num)
	{
		StringBuffer sb = new StringBuffer();

		while(num > 0)
		{
			sb.append(num%2);
			num>>=1;
		}
		// System.out.println(sb);
		System.out.println(sb.reverse());
	}
	public static void toBin_A(int num)
	{
		// System.out.println("num: "+num);
		char[] chs = {'0', '1'};
		char[] arr = new char[32];
		int pos = arr.length;
		while(num != 0)
		{
			int temp = num & 1;
			arr[--pos] = chs[temp];
			num >>= 1;
		}
		for(int x = pos; x < arr.length; x++)
		{
			// System.out.println("AAAAAA");
			System.out.print(arr[x]);
		}
		System.out.println("");
	}
	public static void toHex(int num)
	{
		StringBuffer sb = new StringBuffer();
		while(num != 0)
		{
			int temp = num & 15;
			if(temp > 9)
			{
				sb.append((char)(temp-10+'A'));
			}
			else
			{
				sb.append(temp);
			}
			num = num >>> 4;
			System.out.println(num);
		}
		System.out.println(sb.reverse());
	}
	public static void toHex_A(int num)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E', 'F'};
		StringBuffer sb = new StringBuffer();
		while(num != 0)
		{
			int temp = num & 15;
			sb.append(chs[temp]);
			num >>>= 4;
		}
		System.out.println(sb.reverse());
	}
	public static void toHex_B(int num)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E', 'F'};

		char[] arr = new char[8];

		int pos = arr.length;

		while(num != 0)
		{
			int temp = num & 15;
			arr[--pos] = chs[temp];
			num >>>= 4;
		}

		for(int x = pos; x < arr.length; x++)
		{
			System.out.print(arr[x]);
		}
	}
}