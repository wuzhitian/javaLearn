class StringBufferDemoF
{
	public static void main(String[] args)
	{
		StringBuffer ss = new StringBuffer("abcdefg");

		char[] ch = new char[5];

		ss.getChars(2, 4, ch, 3);

		for(int x = 0; x < ch.length; x++)
		{
			System.out.println(ch[x]);
		}
	}
}