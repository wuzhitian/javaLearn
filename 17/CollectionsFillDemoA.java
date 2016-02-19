import java.util.*;

class CollectionsFillDemoA
{
	public static void main(String[] args)
	{
		fillDemoA();
		Log.println("----------------------------------");

		fillDemoB();

	}
	public static void fillDemoA()
	{
		List<String> list = new ArrayList<String>();
		list.add("fdsjka");
		list.add("reuiwre");
		list.add("oupiiou");
		list.add("jklsad");
		list.add("mvnc");

		Log.println(list);

		Collections.fill(list, "ddes");

		Log.println(list);
	}

	public static void fillDemoB()
	{
		List<String> list = new ArrayList<String>();
		list.add("eeeeii");
		list.add("ffffee");
		list.add("wwwwrr");
		list.add("ppppcc");
		list.add("qqqqzz");
		list.add("iiiioo");
		list.add("mmmmll");

		Log.println(list);

		fillMethod(list, 3, 6, "AAAAA");

		Log.println(list);
	}

	public static void fillMethod(List<String> list, int startIndex, int endIndex, String key)
	{
		for(int x = startIndex; x < endIndex; x++)
		{
			list.set(x, key);
		}
	}
}