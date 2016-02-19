class StringExerciseReverseA
{
	public static void main(String[] args)
	{
		String str = "abcdefg";
		String str1 = reverseA(str);

		sop(str1);

		String str2 = reverseB(str, 2, 16);
		sop(str2);



		String sss = "abcd  efgh";
		sop(reverseString(sss));
		sop(reverseString(sss, 4, 7));
	}

	//**********Demo code********//
	
	public static String reverseString(String str)
	{
		return reverseString(str, 0, str.length());
	}

	
	public static String reverseString(String str, int startIndex, int endIndex)
	{
		char[] c = str.toCharArray();

		reverse(c, startIndex, endIndex);

		return new String(c);
	}

	public static void reverse(char[] c, int startIndex, int endIndex)
	{
		for(int start = 0, end = endIndex - 1; start < end; start++, end--)
		{
			swap(c, start, end);
		}
	}
	public static void swap(char[] c, int x, int y)
	{
		char temp = c[x];
		c[x] = c[y];
		c[y] = temp;
	}


	//***************************//





	public static String reverseA(String str)
	{
		char[] c = str.toCharArray();
		char[] c1 = new char[c.length];

		for(int x = 0; x < c.length; x++)
		{
			c1[x] = c[c.length-1-x];
		}

		return new String(c1);
	}

	public static String reverseB(String str, int startIndex, int endIndex)
	{

		try
		{
			if(startIndex < str.length() && endIndex < str.length())
			{
				String c0 = str.substring(0, startIndex);
				String c1 = str.substring(startIndex, endIndex);
				String c2 = str.substring(endIndex, str.length());
				return c0+reverseA(c1)+c2;
			}
			else
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			sop(e);
		}
		return str;
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}