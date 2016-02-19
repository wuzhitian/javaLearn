import java.util.*;

class CollectionsReplaceAllDemoA
{
	public static void main(String[] args)
	{
		replaceAllDemoA();
		Log.println("----------------------------------");


	}
	public static void replaceAllDemoA()
	{
		List<String> list = new ArrayList<String>();
		list.add("fdsjka");
		list.add("mvnc");
		list.add("reuiwre");
		list.add("mvnc");
		list.add("oupiiou");
		list.add("jklsad");
		list.add("mvnc");

		Log.println(list);

		Collections.replaceAll(list, "mvnc", "AAAAA");

		Log.println(list);
	}
}