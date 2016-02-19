class Car
{
	String color = "red";

	int num = 4;

	void run()
	{
		System.out.println(color+"....."+num);
	}
}
class CarD
{
	public static void main(String[] args)
	{
		Car c1 = show(new Car());
		c1.run();	//yellow.....10
	}
	public static Car show(Car c)
	{
		c.color = "yellow";
		c.num = 10;
		return c;
	}
}