class Person
{
	{
		cry();
	}
	private String name;
	private int age;

	public void cry()
	{
		System.out.println("Cry: My name is " + name + ", my age is " + age);
	}

	Person (int a)
	{
		age = a;
	}

	Person(String n, int a)
	{
		name  = n;
		age = a;
	}
}

class PersonDemoC
{
	public static void main(String[] args)
	{
		Person p1 = new Person(22);	//Cry: My name is null, my age is 0
		p1.cry();	//Cry: My name is null, my age is 22

		Person p2 = new Person("Lisi", 88);	//Cry: My name is null, my age is 0
		p2.cry();	//Cry: My name is Lisi, my age is 88
	}
}
