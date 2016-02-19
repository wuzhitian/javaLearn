class ArrC
{
	public static void main(String[] args)
	{
		int[][] arrA = new int[2][3];
		System.out.println(arrA);		//[[I@2a139a55
		System.out.println(arrA[0]);		//[I@15db9742
		System.out.println(arrA[0][0]);		//0

		int[][] arrB = new int[3][];
		System.out.println(arrB);		//[[I@2a139a55
		System.out.println(arrB[0]);		//null

		arrB[0] = new int[3];
		arrB[1] = new int[4];
		System.out.println(arrB[1][2]);	//0

		// arrB[2] = new char[3];		//不兼容的类型: char[]无法转换为int[]
		
		int[][] arrC = {{1, 2}, {3, 4}, {5, 6}};

		int[][][] arrD = new int[2][][];
		System.out.println(arrD.length);	//2

		int[][][][] arrE = new int[5][][][];
		System.out.println(arrE.length);	//5

		int[] arrF[] = new int[21][];
		System.out.println(arrF.length);	//21

		int[] arrG, arrH[];	//arrG: 一维数组; arrH: 二维数组
	}
}