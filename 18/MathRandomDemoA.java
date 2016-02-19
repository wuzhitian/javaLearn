import java.util.Random;

class MathRandomDemoA
{
	public static void main(String[] args)
	{
		method0();

		Log.println("------------------------------");

		method1();

		Log.println("------------------------------");

		method2();
	}

	public static void method0()
	{
		double n1 = Math.ceil(13.43);
		Log.println("n1: " + n1);

		double n2 = Math.floor(11.43);
		Log.println("n2: " + n2);

		double n3 = Math.round(13.43);
		Log.println("n3: " + n3);

		double n4 = Math.pow(4, 5);
		Log.println("n4: " + n4);
	}

	public static void method1()
	{
		Random r = new Random();
		for(int x = 0; x < 10; x++)
		{
			Log.println(r.nextInt(10));
		}
		Log.println("---------");
		for(int x = 0; x < 10; x++)
		{
			Log.println(r.nextFloat());
		}
	}

	public static void method2()
	{
		for(int x = 0; x < 10; x++)
		{
			double d = Math.random();
			Log.println(d);
		}
	}
}