class Student
{
	private int age;
	private String name;

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return this.age;
	}

	private Student()
	{

	}

	private static Student c = new Student();

	public static Student getInstance()
	{
		return c;
	}
}

class SingleDemoA
{
	public static void main(String[] args)
	{
		Student s1 = Student.getInstance();

		s1.setName("lili");
		s1.setAge(52);

		System.out.println(s1.getName()+"...."+s1.getAge());	//lili....52

		Student s2 = Student.getInstance();

		System.out.println(s2.getName()+"...."+s2.getAge());	//lili....52
	}
}