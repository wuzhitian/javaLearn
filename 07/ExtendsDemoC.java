class Tel
{
	void show()
	{
		System.out.println("number");
	}
}
class NewTel extends Tel
{
	void show()
	{
		super.show();
		System.out.println("name");
		System.out.println("pic");
	}
}

class ExtendsDemoC
{
	public static void main(String[] args)
	{
		NewTel t1 = new NewTel();
		t1.show();
	}
}