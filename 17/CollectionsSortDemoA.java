import java.util.*;

class CollectionsSortDemoA
{
	public static void main(String[] args)
	{
		sortDemo();
	}
	public static void sortDemo()
	{
		List<String> list = new ArrayList<String>();

		list.add("eedcuuud");
		list.add("abcd");
		list.add("ooadppp");
		list.add("ffacdi");
		list.add("qqwbdcd");
		list.add("wqwbdcd");

		sop(list);

		Collections.sort(list, new StrLenComparator());

		sop(list);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

	static class StrLenComparator implements Comparator<String>
	{
		public int compare(String s1, String s2)
		{
			int num = s1.length() - s2.length();

			if(num == 0)
			{
				return s1.compareTo(s2);
			}else{
				return num;
			}
		}
	}
}