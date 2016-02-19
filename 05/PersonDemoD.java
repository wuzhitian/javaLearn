class Person
{
	private String name;
	private int age;

	Person(String name)
	{
		this.name = name;
	}
	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public void cry()
	{
		System.out.println("Cry: My name " + name + ", my age is " + age);
	}
	public void cryThis()
	{
		System.out.println("CryThis: My name " + this.name + ", my age is " + this.age);
	}
}
class PersonDemoD
{
	public static void main(String[] args)
	{
		Person p1 = new Person("LL");
		p1.cry();			//Cry: My name LL, my age is 0
		p1.cryThis();		//CryThis: My name LL, my age is 0

		Person p2 = new Person("KK", 322);
		p2.cry();			//Cry: My name KK, my age is 322
		p2.cryThis();		//CryThis: My name KK, my age is 322
	}
}