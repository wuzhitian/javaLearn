class Person
{
	private String name;
	private int age;

	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public int getAge()
	{
		return this.age;
	}

	public boolean compare(Person p)
	{
		return this.age == p.getAge();
	}
}
class PersonDemoE
{
	public static void main(String[] args)
	{
		Person p1 = new Person("LL", 10);

		Person p2 = new Person("KK", 22);

		System.out.println(p2.compare(p1));	//false
	}
}