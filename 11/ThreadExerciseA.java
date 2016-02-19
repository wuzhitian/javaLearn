class Test extends Thread
{
	private String name;
	Test(String name)
	{
		this.name = name;
	}

	public void run()
	{
		for(int x = 0; x < 60; x++)
		{
			System.out.println(this.name+":"+x);
		}
	}
}

class ThreadExerciseA
{
	public static void main(String[] args)
	{
		Test t1 = new Test("AAAAAAAA");
		Test t2 = new Test("BBBBB");
		t1.start();
		t2.start();

		for(int x = 0; x < 60; x++)
		{
			System.out.println("Main:"+x);
		}
	}
}