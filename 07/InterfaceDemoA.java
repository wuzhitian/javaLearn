interface Inter
{
	public static final int NUM = 99;

	public abstract void show();
}

interface InterA
{
	public abstract void showA();
}

interface InterB extends InterA
{
	public abstract void showB();
}

class SupTest
{
	private int age;

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return this.age;
	}
}

class Test extends SupTest implements Inter, InterB
{
	public void showA()
	{
		System.out.println("showA");
	}
	public void showB()
	{
		System.out.println("showB");
	}
	public void show()
	{
		System.out.println("Test");
	}
}

class InterfaceDemoA
{
	public static void main(String[] args)
	{
		Test t1 = new Test();
		t1.show();	//Test
		System.out.println(t1.NUM);		    //99
		System.out.println(Inter.NUM);		//99
		System.out.println(Test.NUM);		//99

		t1.setAge(55);
		System.out.println(t1.getAge());		//55

		t1.showA();		//showA
		t1.showB();		//showB

	}
}