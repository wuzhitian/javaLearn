import java.util.*;

import static java.util.Arrays.*;

class StaticImportDemoA
{
	public static void main(String[] args)
	{
		int[] arr = {43, 11, 22};

		sort(arr);

		Log.println(Arrays.toString(arr)); // [11, 22, 43]
		
		Log.println(binarySearch(arr, 22)); // 1
	}
}