class DD
{
	private String name;
	private int age;

	private void say()
	{
		System.out.println("DD say");
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}

class AA extends DD
{

}

class TestSuperPrivate
{
	public static void main(String[] args)
	{
		AA a1 = new AA();

		System.out.println(a1.getName());	//null
		a1.setName("DEAAAA");
		System.out.println(a1.getName());	//DEAAAA
	}
}