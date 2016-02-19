import java.util.*;

class CollectionsReverseOrderDemoA
{
	public static void main(String[] args)
	{
		reverseOrder();
	}
	public static void reverseOrder()
	{
		TreeSet<String> ts = new TreeSet<String>(new StrLenComparator());

		ts.add("fffff");
		ts.add("bbbb");
		ts.add("ddd");
		ts.add("cc");
		ts.add("e");

		Log.println(ts);
		// [e, cc, ddd, bbbb, fffff]
		


		
		TreeSet<String> ts1 = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator()));

		ts1.add("fffff");
		ts1.add("bbbb");
		ts1.add("ddd");
		ts1.add("cc");
		ts1.add("e"); 

		Log.println(ts1);
		// [fffff, bbbb, ddd, cc, e]
		


		TreeSet<String> ts2 = new TreeSet<String>();

		ts2.add("fffff");
		ts2.add("bbbb");
		ts2.add("ddd");
		ts2.add("cc");
		ts2.add("e");

		Log.println(ts2);
		// [bbbb, cc, ddd, e, fffff]
		

		TreeSet<String> ts3 = new TreeSet<String>(Collections.reverseOrder());

		ts3.add("fffff");
		ts3.add("bbbb");
		ts3.add("ddd");
		ts3.add("cc");
		ts3.add("e");

		Log.println(ts3);
		//[fffff, e, ddd, cc, bbbb]
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