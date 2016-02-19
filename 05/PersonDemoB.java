class Person
{
	private String name;
	private int age;

	Person()
	{
		System.out.println("A: My name is " + name + ",my age is " + age);
	}
	Person(String n)
	{
		name = n;
		System.out.println("B: My name is " + name + ",my age is " + age);
	}
	Person(String n, int a)
	{
		name = n;
		age = a;
		System.out.println("C: My name is " + name + ",my age is " + age);
	}

	public void cry()
	{
		System.out.println("My name is " + name + ",my age is " + age);
	}

	public void setName(String n)
	{
		name = n;
	}
}

class PersonDemoB
{
	public static void main(String[] args)
	{
		Person p1 = new Person();	//A: My name is null,my age is 0
		p1.cry();		//My name is null,my age is 0

		Person p2 = new Person("Li");	//B: My name is Li,my age is 0
		p2.cry();		//My name is Li,my age is 0

		Person p3 = new Person("Wang", 50);	//C: My name is Wang,my age is 50
		p3.cry();		//My name is Wang,my age is 50

		p3.setName("Wang Wuuuuuu");
		p3.cry();	//My name is Wang Wuuuuuu,my age is 50
	}
}