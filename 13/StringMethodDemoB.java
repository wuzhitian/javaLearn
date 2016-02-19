class StringMethodDemoB
{
	public static void main(String[] args)
	{
		is();
	}

	public static void is()
	{
		String str = "abcAbc.java.txt";
		sop(str.startsWith("abc"));			//true
		sop(str.endsWith("txt"));			//true
		sop(str.contains(".java"));			//true
		sop(str.isEmpty());					//false

		String str1 = "abcabc.java.txt";
		sop(str1.equals(str));				//false
		sop(str1.equalsIgnoreCase(str));	//true
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}