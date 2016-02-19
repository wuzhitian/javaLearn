class ArrB
{
	public static void main(String[] args)
	{
		int[] arr = {1, 3, 4, 5, 7};
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("arr["+i+"]="+arr[i]);
		}

		int[] arrA = {11, 22, 33};
		System.out.println(arrA);

		printArr(arrA);
	}
	public static void printArr(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("arr["+i+"]="+arr[i]+";");
		}
	}
}