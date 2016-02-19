abstract class Student
{
	abstract void study();

	void studyA()
	{
		System.out.println("Student study");
	}
}
class BaseStudent extends Student
{
	void study()
	{
		System.out.println("BaseStudent study");
	}
}

class AbstractDemoB
{
	public static void main(String[] args)
	{
		BaseStudent s1 = new BaseStudent();
		s1.study();			//BaseStudent study
		s1.studyA();		//Student study
	}
}