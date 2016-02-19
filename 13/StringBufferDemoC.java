class StringBufferDemoC
{
	public static void main(String[] args)
	{
		StringBuffer ss = new StringBuffer("abcdefghiejk");

		sop(ss.charAt(4));			//e
		sop(ss.indexOf("e"));		//4
		sop(ss.lastIndexOf("e"));	//9
		sop(ss.length());			//12
		sop(ss.substring(2, 6));	//cdef
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}