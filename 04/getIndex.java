class getIndex
{
	public static void main(String[] args)
	{
		int[] arr = {2, 4, 1, 6, 7, 8, 5, 0};
		System.out.println(getIndex(arr, 1));		//2

		int[] arrA = {2, 3, 5, 6, 7, 8, 20};
		System.out.println(halfSearch(arrA, 20));	//6
		System.out.println(halfSearch_2(arrA, 8));	//5

		System.out.println(getIndex_2(arrA, 4));

		System.out.println((double)(13/3));	//4.0;
		System.out.println((double)13/3);	//4.33333333333333333
		System.out.println((double)13/(double)3);	//4.33333333333333333
	}
	public static int getIndex_2(int[] arr, int key)	
	{
		int min = 0, max = arr.length-1, mid;
		while(max >= min)
		{
			mid = (max+min)>>1;
			// System.out.println(mid);
			if(key > arr[mid])
			{
				min = mid+1;
			}
			else if(key < arr[mid])
			{
				max = mid-1;
			}
			else
			{
				return mid;
			}
			mid = (max + min)>>1;
		}
		return min;
	}
	public static int getIndex(int[] arr, int key)
	{
		for(int x = 0; x < arr.length; x++)
		{
			if(arr[x] == key)
			{
				return x;
			}
		}
		return -1;
	}
	public static int halfSearch_2(int[] arr, int key)
	{
		int min = 0, max = arr.length - 1, mid=(max+min)/2;
		while(arr[mid] != key)
		{
			if(key > arr[mid])
			{
				min = mid +1;
			}
			else
			{
				max = mid -1;
			}
			if(min > max)
			{
				return -1;
			}
			mid = (max + min)>>1;
		}
		return mid;
	}
	public static int halfSearch(int[] arr, int key)
	{
		int min=0, max = arr.length-1, mid;
		while(min <= max)
		{
			mid = (max + min) >> 1;
			if(key > arr[mid])
			{
				min = mid + 1;
			}
			else if(key < arr[mid])
			{
				max = mid - 1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}
}