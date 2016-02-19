class StringExerciseCountA
{
	public static void main(String[] args)
	{
		String ss = "aabbccdfgdeeccfg ";
		sop(ss.split("fg").length);
		sop(countA(ss, "cc"));

		sop(countDemoA(ss, "e"));
		sop(countDemoB(ss, "e"));
	}

	//**********Demo Code*********//
	public static int countDemoA(String str, String subStr)
	{
		int count = 0;
		int index = 0;

		while((index = str.indexOf(subStr, index)) != -1)	////!!!!
		{
			index = index + subStr.length();
			count++;
		}
		return count;
	}

	public static int countDemoB(String str, String subStr)
	{
		int count = 0;
		int index = 0;

		while((index = str.indexOf(subStr)) != -1)
		{
			str = str.substring(index+subStr.length());
			count++;
		}
		return count++;
	}

	//****************************//
	public static int countA(String str, String subStr)
	{
		if(str.contains(subStr))
		{
			String[] arr = str.split(subStr);
			if(str.endsWith(subStr))
			{
				return arr.length;
			}
			else
			{
				return arr.length - 1;
			}
		}
		else
		{
			return -1;
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}