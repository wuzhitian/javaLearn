class StringMethodDemoD
{
	public static void replace()
	{
		String s = "Hello Java";

		String s1 = s.replace('a', 'n');
		sop(s);			//"Hello Java"
		sop(s1);		//"Hello Jnvn"

		String s2 = s.replace('c', 'n');
		sop(s2);		//"Hello Java"

		String s3 = s.replace("Java", "World");
		sop(s3);		//"Hello World"
	}

	public static void split()
	{
		String s = "Lili, Jack, Mike, Jame";
		String[] s1 = s.split(",");

		for(int x = 0; x < s1.length; x++)
		{
			System.out.print("s1["+x+"]:"+ s1[x] + " |");
			//s1[0]:Lili |s1[1]: Jack |s1[2]: Mike |s1[3]: Jame |
		}
		System.out.println("");
	}

	public static void sub()
	{
		String s = "abcdefghi";

		String s1 = s.substring(3);
		sop(s1);		//"defghi"

		String s2 = s.substring(3, 5);
		sop(s2);		//"de"
	}

	public static void main(String[] args)
	{
		replace();
		split();
		sub();
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}