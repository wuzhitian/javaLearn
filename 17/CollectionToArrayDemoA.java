import java.util.*;

class CollectionToArrayDemoA
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();

		list.add("aaa1");
		list.add("aaa2");
		list.add("aaa3");
		list.add("aaa4");

		Log.println(list);
		// [aaa1, aaa2, aaa3, aaa4]
		

		String[] arr = list.toArray(new String[list.size()]);
		Log.println(arr);
		// [Ljava.lang.String;@2a139a55
		
		Log.println(Arrays.toString(arr));
		// [aaa1, aaa2, aaa3, aaa4]
		 
		Log.println(Arrays.asList(arr));
		// [aaa1, aaa2, aaa3, aaa4]
		



		String[] arr1 = list.toArray(new String[9]);

		Log.println(arr1);
		// [Ljava.lang.String;@15db9742
		
		Log.println(Arrays.toString(arr1));
		// [aaa1, aaa2, aaa3, aaa4, null, null, null, null, null]

		Log.println(Arrays.asList(arr1));
		// [aaa1, aaa2, aaa3, aaa4, null, null, null, null, null]
	}
}