class Person
{
	String name;
	Person ()
	{
		System.out.println("init Person without argument");
	}
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}

class Student extends Person
{
	Student()
	{

	}

	Student(String name)
	{
		super(name);
	}
}

class ExtendsDemoE
{
	public static void main(String[] args)
	{
		Student s1 = new Student("Lioli");
		System.out.println(s1.getName());	//Lioli

		Student s2 = new Student();	//init Person without argument
	}
}