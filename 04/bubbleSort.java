class bubbleSort
{
	public static void main(String[] args)
	{
		int[] arrA = {122, 12, 321, 442, 112, 423};
		printArr(arrA);
		bubbleSort(arrA);
		printArr(arrA);
	}
	public static int[] bubbleSort(int[] arr)
	{
		// for(int x = 0; x < arr.length-1; x++)
		// {
		// 	for(int y=arr.length - 1; y>x; y--)
		// 	{
		// 		if(arr[y] > arr[y - 1])
		// 		{
		// 			swap(arr, y, y-1);
		// 		}
		// 	}
		// }
		
		for(int x = 0; x < arr.length-1; x++)
		{
			for(int y = 0; y < arr.length - x - 1; y++)
			{
				if(arr[y] < arr[y+1])
				{
					swap(arr, y, y+1);
				}
			}
		}
		return arr;
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

	public static void swap(int[] arr, int a, int b)
	{
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}
}