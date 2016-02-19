class Car
{
	String color = "red";

	int num = 4;

	void run()
	{
		System.out.println(color+"...."+num);
	}
}

class CarA
{
	public static void main(String[] args)
	{
		Car c1 = new Car();

		c1.run();	//red....4

		c1.num = 5;

		c1.run();	//red....5

		Car c2 = c1;

		c2.color = "green";	//green....4

		c1.run();

		// c2.num = "AA";	//不兼容的类型: String无法转换为int

		c1.run();
	}
}