class selectSort
{
	public static void main(String[] args)
	{
		int[] arr = {21, 12, 43, 23, 44, 54, 22};
		printArr(arr);
		selectSort(arr);	//数组 引用类型;
		printArr(arr);
	}
	public static int[] selectSort(int[] arr)
	{
		for(int x = 0; x < arr.length-1; x++)	//x < arr.length -1;
		{
			for(int y = x+1; y < arr.length; y++) //y = x+1
			{
				if(arr[x] > arr[y])
				{
					// arr[x] = arr[x] ^ arr[y];
					// arr[y] = arr[x] ^ arr[y];
					// arr[x] = arr[x] ^ arr[y];
					
					// arr[x] = arr[x] + arr[y];
					// arr[y] = arr[x] - arr[y];
					// arr[x] = arr[x] - arr[y];

					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
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
			if(x != arr.length - 1)
			{
				System.out.print(arr[x]+" ,");
			}
			else
			{
				System.out.println(arr[x]+"]");
			}
		}
	}
}