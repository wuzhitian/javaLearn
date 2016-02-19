class StringMethodDemoA
{
	public static void main(String[] args)
	{
		get();
	}

	public static void get()
	{
		String str = "abcdefgacd";

		sop(str.length());				//10
		sop(str.indexOf(97));			//0
		sop(str.indexOf(97, 3));		//7
		sop(str.indexOf("a"));			//0
		sop(str.indexOf("a", 2));		//7
		sop(str.lastIndexOf("a"));		//7
		sop(str.lastIndexOf("a", 3));	//0

		sop((char)65);		//A
		sop((int)'a');		//97
		sop((byte)'a');		//97
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}