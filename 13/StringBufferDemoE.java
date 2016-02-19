class StringBufferDemoE
{
	public static void main(String[] args)
	{
		StringBuffer ss = new StringBuffer("abcdefg");

		sop(ss.reverse());		//gfedcba
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}