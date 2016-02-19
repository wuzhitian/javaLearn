class Fu
{
	int num = 4;
}
class Zi extends Fu
{
	int num = 5;
	void showZi()
	{
		System.out.println(this.num);
	}
	void showFu()
	{
		System.out.println(super.num);
	}
}

class ExtendsDemoB
{
	public static void main(String[] args)
	{
		Zi z1 = new Zi();
		z1.showZi();	//5
		z1.showFu(); 	//4
	}
}