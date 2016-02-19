import java.util.*;

class CollectionsBinarySearchDemoA
{
	public static void main(String[] args)
	{
		binarySearchDemo();
	}
	public static void binarySearchDemo()
	{
		List<String> list = new ArrayList<String>();

		list.add("dd");
		list.add("bbb");
		list.add("cccd");
		list.add("a");
		list.add("eee");
		list.add("eeefff");


		Collections.sort(list, new StrLenComparator());
		Log.println(list);
		Log.println("eee1: " + Collections.binarySearch(list, "eee"));		// -6

		Log.println("eee2: " + Collections.binarySearch(list, "eee", new StrLenComparator()));		//3
		Log.println(Collections.binarySearch(list, "ddddddddddddddd", new StrLenComparator()));		// -6

		Log.println(halfSearch(list, "eee", new StrLenComparator())); //3

	}

	public static int halfSearch(List<String> list, String key, Comparator<String> cmp)
	{
		int max, min, mid;
		max = list.size() - 1;
		min = 0;

		while(min <= max)
		{
			mid = (max + min) >> 1;
			String str = list.get(mid);

			int num = cmp.compare(str, key);
			if(num > 0)
			{
				max = mid - 1;
			}else if(num < 0)
			{
				min = mid + 1;
			}else
			{
				return mid;
			}
		}
		return -min-1;

	}

	static class StrLenComparator implements Comparator<String>
	{
		public int compare(String s1, String s2)
		{
			int num = s1.length() - s2.length();
			if(num == 0)
			{
				return s1.compareTo(s2);
			}else
			{
				return num;
			}
		}
	}
}