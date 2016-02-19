class ArrMax
{
	public static void main(String[] args)
	{
		int[] arrA = {1, 2, 44, 54, 65, 66};
		System.out.println("Max of arrA is "+getMax(arrA));
		System.out.println("Min of arrA is "+getMin(arrA));


		double[] arrB = {22.11, 33.11, 43.12, 42.43};
		System.out.println("Max of arrA is "+getMax(arrB));
		System.out.println("Min of arrA is "+getMin(arrB));
	}
	/**
	 * get MaxValue of Arr
	 * @param  arr [description]
	 * @return     [MaxValue]
	 */
	public static int getMax(int[] arr)
	{
		int result = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > result)
			{
				result = arr[i];
			}
		}
		return result;
	}
	public static int getMin(int[] arr)
	{
		int result = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] < result)
			{
				result = arr[i];
			}
		}
		return result;
	}

	/**
	 * 重载 
	 * @param  arr [description]
	 * @return     [description]
	 */
	public static double getMax(double[] arr)
	{
		double result = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			if(result < arr[i])
			{
				result = arr[i];
			}
		}
		return result;
	}

	public static double getMin(double[] arr)
	{
		double result = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			if(result > arr[i])
			{
				result = arr[i];
			}
		}
		return result;
	}
}