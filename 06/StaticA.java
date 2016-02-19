class Person
{
	String name;
	static String country = "CN";

	Person(String name)
	{
		this.name = name;
	}

	public void show()
	{
		System.out.println(this.name+"....."+this.country);
	}

	public static void showB()
	{
		// System.out.println(this.name);		//错误: 无法从静态上下文中引用非静态 变量 name
	}

	public static void showC()
	{
		System.out.println(country);
	}

	public void haha()
	{
		System.out.println("hahaaaaa");
	}
}

class StaticA
{
	public static void main(String[] args)
	{
		Person p1 = new Person("Lili");
		p1.show();	//Lili.....CN
		System.out.println(p1.country);		//CN
		System.out.println(Person.country);	//CN

		Person.showB();
		Person.showC();	//CN
	}
}