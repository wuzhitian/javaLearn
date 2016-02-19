abstract class GetTime
{
	public final void getTime()
	{
		long start = System.currentTimeMillis();
		runCode();
		long end = System.currentTimeMillis();
		System.out.println("Milliseconds:" + (end - start));
	}

	public abstract void runCode();
}

class SubTime extends GetTime
{
	public void runCode()
	{
		int y = 0;
		for(int x = 0; x < 40000; x++)
		{
			y += x;
			y--;
			// System.out.print(x);
		}
		System.out.println("Y:" + y);
	}
}

class TemplateDemoA
{
	public static void main(String[] args)
	{
		SubTime s1 = new SubTime();
		s1.getTime();
	}
}