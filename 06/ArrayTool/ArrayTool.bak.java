/**
 *This is an Array Tool
 *@author wuzhitian
 *@version 1.0
 */
public class ArrayTool
{
	/**
	 * empty foo
	 * @return void
	 */
	private ArrayTool()
	{

	}
	/**
	 * getMax
	 * @param  arr array
	 * @return     Max of Array
	 */
	public static int getMax(int[] arr)
	{
		int max = arr[0];
		for(int x = 1; x < arr.length; x++)
		{
			if(arr[x] > max)
			{
				max = arr[x];
			}
		}
		return max;
	}
	/**
	 * getMin
	 * @param  arr array
	 * @return     Min of Array
	 */
	public static int getMin(int[] arr)
	{
		int min = arr[0];
		for(int x = 1; x < arr.length; x++)
		{
			if(arr[x] < min)
			{
				min = arr[x];
			}
		}
		return min;
	}
	/**
	 * selectSorttttttt
	 * @param  arr array
	 * @return     selectSortArr
	 */
	public static int[] selectSort(int[] arr)
	{
		for(int x = 0; x < arr.length-1; x++)
		{
			for(int y = x+1; y < arr.length; y++)
			{
				if(arr[x] > arr[y])
				{
					swap(arr, x, y);
				}
			}
		}
		return arr;
	}
	/**
	 * bubbleSorttttttt
	 * @param  arr array
	 * @return     bubbleSortArr
	 */
	public static int[] bubbleSort(int[] arr)
	{
		for(int x = 0; x <arr.length-1; x++)
		{
			for(int y = 0; y < arr.length - x -1; y++)
			{
				if(arr[y] > arr[y+1])
				{
					swap(arr, y, y+1);
				}
			}
		}
		return arr;
	}
	/**
	 * printArr
	 * @param arr array
	 */
	public static void printArr(int[] arr)
	{
		System.out.print("[");
		for(int x = 0; x < arr.length; x++)
		{
			if(x == arr.length - 1)
			{
				System.out.println(arr[x]+"]");
			}
			else{
				System.out.print(arr[x]+", ");
			}
		}
	}

	/**
	 * swap element
	 * @param arr array
	 * @param a   index a
	 * @param b   index b
	 */
	private static void swap(int[] arr, int a, int b)
	{
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}
}