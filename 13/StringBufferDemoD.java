class StringBufferDemoD
{
	public static void main(String[] args)
	{
		StringBuffer ss = new StringBuffer("abcdefghijk");
		sop(ss.replace(3, 5, "pppp"));	//abcppppfghijk

		ss.setCharAt(8, 'Y');
		sop(ss);						//abcppppfYhijk
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}