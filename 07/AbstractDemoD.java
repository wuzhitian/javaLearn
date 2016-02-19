abstract class Demo
{
	abstract void show()
	{
		//抽象方法不能有主体，会报错
		System.out.println("DDESS");
	}
}

class SubDemo extends Demo
{

}

class AbstractDemoD
{
	public static void main(String[] args)
	{
		SubDemo s1 = new SubDemo();
	}
}