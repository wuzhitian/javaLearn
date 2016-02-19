class StringDemoA
{
	public static void main(String[] args)
	{
		String s1 = "abc";
		String s2 = new String("abc");

		System.out.println(s1 == s2);	    //false
		System.out.println(s1.equals(s2));	//true

		String s3 = "abc";
		System.out.println(s1 == s3);	    //true
	}
}