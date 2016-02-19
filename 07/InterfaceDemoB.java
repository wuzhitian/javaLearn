interface Singer
{
	public abstract void sing();
}

interface Runner
{
	public abstract void run(int distance);
}

class Student
{
	public void study()
	{
		System.out.println("Student study");
	}
}

class BaseStudent extends Student implements Singer
{
	public void sing()
	{
		System.out.println("BaseStudent sing: ");
	}

}

class AdvStudent extends Student implements Singer, Runner
{
	public void sing()
	{
		System.out.println("AdvStudent sing: ");
	}

	public void run(int distance)
	{
		System.out.println("AdvStudent run: " + distance);
	}
}

class InterfaceDemoB
{
	public static void main(String[] args)
	{
		BaseStudent b1 = new BaseStudent();
		b1.study();			//Student study
		b1.sing();			//BaseStudent sing: 

		AdvStudent a1 = new AdvStudent();
		a1.study();			//Student study
		a1.sing();			//AdvStudent sing:
		a1.run(111222);		//AdvStudent run: 111222
	}
}