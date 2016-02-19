class StringExerciseSameMaxA
{

	public static void main(String[] args)
	{
		String s1 = "abcccdedfesfdsa";
		String s2 = "dedfses";

		sop(getMaxSubString(s1, s2));
	}

	public static String getMaxSubString(String s1, String s2)
	{
		String max = "", min = "";

		max = (s1.length() > s2.length())? s1 : s2;
		min = (max == s1) ? s2 : s1;

		for(int x = 0; x < min.length(); x++)
		{
			for(int y = 0, z = min.length()-x; z != min.length()+1; y++, z++)
			{
				String temp = min.substring(y, z);

				if(max.contains(temp))
				{
					return temp;
				}
			}			
		}
		return "";
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}