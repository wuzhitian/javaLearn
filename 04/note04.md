### 数组

	int[] arr = new int[2];
	int arr[] = new int[2];

	int[] arr = new int[]{1, 2, 3};
	int arr[] = new int[]{1 ,2, 3};

	int[] arr = {1, 2, 3};

//ArrayIndexOutOfBoundsException: 操作数组时，访问到了数组中不存在的脚标
//NullPointerException: 空指针异常：当引用没有任何指向值为null的情况，该引用还在用于操作实体

##### 排序

1.选择排序

```java
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
```

```java
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
		//for(int x = 0; x < arr.length - 1; x++)
		//{
		//	for(int y = 0; y < arr.length - x - 1; y++)
		//	{
		//		if(arr[y] < arr[y+1])
		//		{
		//			swap(arr, y, y+1);
		//		}
		//	}
		//}

		for(int x = 0; x < arr.length - 1; x++)
		{
			for(int y = arr.length - 1; y > x; y--)
			{
				if(arr[y] > arr[y - 1])
				{
					swap(arr, y, y-1);
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
```

```java
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
```

##### 进制转换

```java
class radix_C
{
	public static void main(String[] args)
	{
		toBin(22);
		toHex(878);
	}
	public static void toBin(int num)
	{
		trans(num, 2);
	}
	public static void toHex(int num)
	{
		trans(num, 16);
	}
	
	public static void trans(int num, int base)
	{
		char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E', 'F'};
		char[] arr = new char[32];
		int pos = arr.length;

		int offset = 0, tempBase = base;
		while(tempBase > 1)
		{
			offset++;
			tempBase >>= 1; 
		}

		while(num != 0)
		{
			int temp = num & (base - 1);

			arr[--pos] = chs[temp];

			num >>>= offset;
		}
		for(int x = pos; x < arr.length; x++)
		{
			System.out.print(arr[x]);
		}
		System.out.println("");
	}
}
```

##### 二维数组

```java
	int[][] arrA = new int[2][3];

	int[][] arrB = new int[3][];

	int[][] arrC = {{1, 2}, {3, 4}, {5, 6}};

	int[] arrD[] = new int[3][];

```