class SingleAA
{
	private int age = 0;
	private String name = "LOIIII";

	public void say()
	{
		System.out.println(this.age + " ... " + this.name);
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return this.age;
	}

	private SingleAA()
	{

	}

	public static SingleAA c = new SingleAA();

	public static SingleAA getInstance()
	{
		return c;
	}
}

class SingleDemoA
{
	public static void main(String[] args)
	{
		SingleAA s1 = SingleAA.getInstance();
		s1.say();	//0 ... LOIIII
		s1.setAge(50);
		System.out.println(s1.getAge());	//50

		SingleAA s2 = SingleAA.getInstance();
		System.out.println(s2.getAge());	//50
	}
}