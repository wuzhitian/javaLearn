class StringExerciseTrimA
{
	public static void main(String[] args)
	{
		String str = "  ef  g  ";

		String s1 = myTrim(str);
		sop(s1);

		String s2 = myTrimDemo(str);
		sop(s2);
	}

	public static String myTrimDemo(String str)
	{
		int startIndex = 0;
		int endIndex = str.length() - 1;

		while(str.charAt(startIndex) == ' ' &&  startIndex <= endIndex)
		{
			startIndex++;
		}

		while(str.charAt(endIndex) == ' ' && endIndex >= startIndex)
		{
			endIndex--;
		}

		return str.substring(startIndex, endIndex+1);
	}


	public static String myTrim(String str)
	{
		int startIndex = 0;
		for(int x = 0; x < str.length(); x++)
		{
			if(str.charAt(x) != ' ')
			{
				startIndex = x; 
				break;
			}
		}
		String temp0 = str.substring(startIndex);

		int endIndex = temp0.length();
		for(int x = temp0.length()-1; x > 0; x--)
		{
			if(temp0.charAt(x) != ' ')
			{
				endIndex = x;
				break;
			}
		}
		String temp1 = temp0.substring(0, endIndex+1);
		
		return temp1;

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}