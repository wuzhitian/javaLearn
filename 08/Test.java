class Demo
{
	private int num;

	Demo (int num)
	{
		this.num = num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	public int getNum()
	{
		return this.num;
	}

}

class Test
{
	public static void main(String[] args)
	{
		Demo d1 = new Demo(4);
		System.out.println(d1.getNum());	//4

		Demo d2 = new Demo(5);
		System.out.println(d2.getNum());	//5

		Demo d3 = d1;
		System.out.println(d3.getNum());	//4

		d3.setNum(66);
		System.out.println(d3.getNum());	//66
		System.out.println(d1.getNum());	//66

		
		// Class a = d1.getClass();
		// System.out.println(a.getMethods());



	}
}