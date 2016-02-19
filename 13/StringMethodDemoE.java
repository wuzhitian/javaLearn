class StringMethodDemoE
{
	public static void main(String[] args)
	{
		String s = "  Hello  ";

		String s1 = s.toLowerCase();
		sop(s1);		//"  hello  "

		String s2 = s.toUpperCase();
		sop(s2);		//"  HELLO  "

		String s3 = s.trim();
		sop(s3);		//"hello"


		String ss0 = "aac";
		String ss1 = "aac";
		String ss2 = "aec";
		String ss3 = "azd";

		int i0 = ss0.compareTo(ss1);
		sop(i0);			//0

		int i1 = ss1.compareTo(ss2);
		sop(i1);			//-4

		int i2 = ss3.compareTo(ss2);
		sop(i2);			//21

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}