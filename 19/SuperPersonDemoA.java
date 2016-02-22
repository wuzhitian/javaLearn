class Person
{
	public void chifan()
	{
		System.out.println("吃饭");
	}
}

class SuperPerson
{
	private Person p = null;

	SuperPerson(Person p)
	{
		this.p = p;
	}

	public void superChifan()
	{
		System.out.println("开胃菜");
		p.chifan();
		System.out.println("饭后点心");
	}
}

class SuperPersonDemoA
{
	public static void main(String[] args)
	{
		Person p = new Person();
		// p.chifan();
		SuperPerson sp = new SuperPerson(p);

		sp.superChifan();
	}
}