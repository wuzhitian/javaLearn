class Person
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

}

class Student extends Person
{
	void study()
	{
		System.out.println("good study");
	}
}

class Worker extends Person
{
	void work()
	{
		System.out.println("good word");
	}
}

class ExtendsDemoA
{
	public static void main(String[] args)
	{
		Student s1 = new Student();
		s1.setName("TT");
		System.out.println(s1.getName());	//TT

		Worker w1 = new Worker();
		w1.setName("WW");
		System.out.println(w1.getName());	//WW
	}
}