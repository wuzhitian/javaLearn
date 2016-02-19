import java.util.*;

class ArraysDemoA
{
	public static void main(String[] args)
	{
		int[] arr0 = {2, 3, 4, 5};

		Log.println(arr0);		// [I@2a139a55

		String arr0Str = Arrays.toString(arr0);
		Log.println(arr0Str);	//[2, 3, 4, 5]




		String[] arr1 = {"aaa", "bbb", "CCC", "DDD", "eee"};

		List<String> arr1List = Arrays.asList(arr1);

		Log.println(arr1List.contains("aaa"));	//true

		// arr1List.add("qqqq"); // UnsupportedOperationException

		// arr1List.set(7, "ddddddd");		//ArrayIndexOutOfBoundsException
		
		arr1List.set(3, "ddddddd");

		Log.println(arr1List);		//[aaa, bbb, CCC, ddddddd, eee]




		int[] arr2 = {22, 333, 111, 4444, 555};

		List<int[]> arr2List = Arrays.asList(arr2);

		Log.println(arr2List);	//[[I@15db9742]


		Integer[] arr3 = {22, 333, 111, 4444, 555};

		List<Integer> arr3List = Arrays.asList(arr3);

		Log.println(arr3List);	//[22, 333, 111, 4444, 555]

	}
}