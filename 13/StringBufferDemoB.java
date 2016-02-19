class StringBufferDemoB
{
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer("abcde");

		sop(sb.toString());		//abcde;

		sop(sb.delete(2, 4));	//abe;

		sop(sb.deleteCharAt(1));	//ae;

	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}