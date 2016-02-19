// class Person
// {
// 	int age;
// 	void speak()
// 	{
// 		System.out.println("age: "+age);
// 	}
// }
// class PersonDemoA
// {
// 	public static void main(String[] args)
// 	{
// 		Person p = new Person();
// 		p.age = 20;
// 		p.speak();	//age: 20
// 	}
// }




class Person
{
	private int age;
	void speak()
	{
		System.out.println("age: "+age);
	}

	public void setAge(int personAge)
	{
		if(personAge > 0 && personAge < 130)
		{
			age = personAge;
			speak();
		}
		else
		{
			System.out.println("invalid age");
		}
	}
	public int getAge()
	{
		return age;
	}
}

class PersonDemoA
{
	public static void main(String[] args)
	{
		Person p = new Person();
		p.setAge(30);	//age: 30
		p.speak();		//age: 30
		p.setAge(-1);		//invalid age
		System.out.println(p.getAge());	//30
	}
}