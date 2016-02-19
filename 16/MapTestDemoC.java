import java.util.*;

class MyComparator implements Comparator<Character>
{
	public int compare(Character c1, Character c2)
	{
		return c1.compareTo(c2);
	}
}

class MapTestDemoC
{
	public static void main(String[] args)
	{
		String str = "aaaaaaaESBBBBABBWB;;dsajflka";
		charCount(str);
	}
	public static void charCount(String  str)
	{
		char[] strArr = str.toCharArray();

		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

		for(int x = 0; x < strArr.length; x++)
		{
			if(!(strArr[x] >= 'a' && strArr[x] <= 'z' || strArr[x] >= 'A' && strArr[x] <= 'Z'))
			{
				continue;
			}

			// char key = strArr[x];
			// if(tm.containsKey(key))
			// {	
			// 	int count = tm.get(key).intValue();
			// 	tm.put(key, ++count);
			// }else{
			// 	tm.put(key, 1);
			// }
			
			Integer value = tm.get(strArr[x]);

			if(value == null)
			{
				tm.put(strArr[x], 1);
			}
			else
			{
				tm.put(strArr[x], ++value);
			}

		}

		Iterator<Map.Entry<Character, Integer>> it = tm.entrySet().iterator();

		while(it.hasNext())
		{
			Map.Entry<Character, Integer> m = it.next();

			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}
}