import java.util.*;

class CollectionsReverseDemoA
{
	public static void main(String[] args)
	{
		reverseDemoA();
		Log.println("----------------------------------");


	}
	public static void reverseDemoA()
	{
		List<String> list = new ArrayList<String>();
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		list.add("DDD");
		list.add("EEE");
		list.add("fff");
		list.add("gggg");

		Log.println(list);

		Collections.reverse(list);

		Log.println(list);
	}
}