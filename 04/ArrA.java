import java.util.*;
class ArrA
{
	public static void main(String[] args)
	{
		// int[] arr = new int[2];
		// int arr[] = new int[2];

		// int[] arr = new int[]{1, 2, 3, 4};
		// int arr[] = new int[]{1, 2, 3, 4};
		
		int[] arr = {211, 222, 111, 331, 4431, 1231, 333};
		printArr(arr);
		Arrays.sort(arr);
		printArr(arr);
	}
	public static void printArr(int[] arr)
	{
		System.out.print("[");
		for(int x = 0; x < arr.length; x++)
		{
			if(x != arr.length-1)
			{
				System.out.print(arr[x]+", ");
			}
			else
			{
				System.out.println(arr[x]+"]");
			}
		}
	}
}