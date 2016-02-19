abstract class Demo
{
	abstract void studyA();
	abstract void studyB();
}

class BaseStudent extends Demo
{
	void studyA()
	{
		System.out.println("BaseStudent studyA");
	}

	void studyB()
	{
		System.out.println("BaseStudent studyB");
	}
}

class AbstractDemoA
{
	public static void main(String[] args)
	{
		BaseStudent s1 = new BaseStudent();
		s1.studyA();

		new BaseStudent().studyB();
	}
}