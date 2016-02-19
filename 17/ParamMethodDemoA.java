import java.util.*;

class ParamMethodDemoA
{
	public static void main(String[] args)
	{
		show("AAA", 11, 22, 33, 44, 55);
		// 5
		// [11, 22, 33, 44, 55]


		show("BBB", 888, 777, 666, 555, 4, 3, 2, 1, 33);
		// 9
		// [888, 777, 666, 555, 4, 3, 2, 1, 33]
	}

	public static void show(String s, int... arr)
	{
		Log.println(arr.length);
		Log.println(Arrays.toString(arr));
	}
}