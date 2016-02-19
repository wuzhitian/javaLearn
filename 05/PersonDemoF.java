class Person
{
	private String name;
	private int age;

	Person(String name)
	{
		this.name = name;
	}
	Person(int age)
	{
		this.age = age;
	}
	Person(String name, int age)
	{
		this(name);
		this(age);
		this.age = age;
	}
	public void cry()
	{
		System.out.println("Cry: My name is " + name + ", my age is " + age);
	}
}

class PersonDemoF
{
	public static void main(String[] args)
	{
		Person p1 = new Person("LL", 30);
		p1.cry();	//Cry: My name is LL, my age is 30
	}
}