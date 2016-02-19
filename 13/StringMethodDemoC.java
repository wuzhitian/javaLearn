class StringMethodDemoC
{

	public static void transform()
	{
		char[] a = {'a', 'd', 'c', 'f', 'g'};

		String str1 = new String(a);
		sop(str1);				//"adcfg"

		String str2 = new String(a, 2, 3);
		sop(str2);				//"cfg"

		String str3 = String.copyValueOf(a);
		sop(str3);				//"adcfg"

		String str4 = String.copyValueOf(a, 2, 3);
		sop(str4);				//"cfg"

		String str5 = String.valueOf(a);
		sop(str5);				//"adcfg"



		byte[] b = {97, 98, 99, 100, 101, 102};

		String str6 = new String(b);
		sop(str6);				//"abcdef"

		String str7 = new String(b, 2, 3);
		sop(str7);				//"cde"

		
		String s = "GHIJK";

		char[] c1 = s.toCharArray();
		for(int x = 0; x < c1.length; x++)
		{
			System.out.print("c1["+x+"]:"+c1[x]+" | ");
			//c1[0]:G | c1[1]:H | c1[2]:I | c1[3]:J | c1[4]:K | 
		}
		System.out.println("");


		byte[] b1 = s.getBytes();
		for(int x = 0; x < b1.length; x++)
		{
			System.out.print("b1["+x+"]:"+b1[x]+" | ");
			//b1[0]:71 | b1[1]:72 | b1[2]:73 | b1[3]:74 | b1[4]:75 |
		}
		System.out.println("");


		String str8 = String.valueOf(5678);
		sop(str8);				//"5678"

		String str9 = String.valueOf(34.55444333);
		sop(str9);				//"34.55444333"
	}

	public static void main(String[] args)
	{
		transform();
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}