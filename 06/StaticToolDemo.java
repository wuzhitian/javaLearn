import ArrayTool.ArrayTool;

class StaticToolDemo
{
	public static void main(String[] args)
	{
		int[] arrA = {9,2,4,1,5,6};
		System.out.println(ArrayTool.getMax(arrA));	//9

		System.out.println(ArrayTool.getMin(arrA));	//1

		ArrayTool.printArr(ArrayTool.selectSort(arrA));	//[1, 2, 4, 5, 6, 9]

		int[] arrB = {3,1,4,6,2,7,8};

		ArrayTool.printArr(ArrayTool.bubbleSort(arrB));	//[1, 2, 3, 4, 6, 7, 8]
	}
}