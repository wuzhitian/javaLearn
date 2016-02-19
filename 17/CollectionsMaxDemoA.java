import java.util.*;

class CollectionsMaxDemoA
{
	public static void main(String[] args)
	{
		maxDemo();
	}
	public static void maxDemo()
	{
		List<String> list = new ArrayList<String>();
		list.add("zzueiopwq");
		list.add("erwuioeiop");
		list.add("euyiorew");
		list.add("coooooovjklxfdkjl");
		list.add("rrueiopwq");
		list.add("eruiowds");

		Log.println(list);

		Log.println(Collections.max(list));

		Log.println(Collections.max(list, new StrLenComparator()));

	}

	static class StrLenComparator implements Comparator<String>
	{
		public int compare(String s1, String s2)
		{
			int num = s1.length()  - s2.length();
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