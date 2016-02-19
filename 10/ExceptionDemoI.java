interface Shape
{
	public void getArea();
}

class IllegalValueException extends RuntimeException
{
	IllegalValueException(String msg)
	{
		super(msg);
	}
}

class Rectangle implements Shape
{
	private int length, width;
	Rectangle(int length, int width)
	{
		if(length <=0 || width <= 0)
		{
			throw new IllegalValueException("IllegalValue");
		}
		this.length = length;
		this.width = width;
	}

	public void getArea()
	{
		System.out.println(length * width);
	}
}

class Circle implements Shape
{
	private int radius;
	public static final double PI = 3.14;
	Circle(int radius)
	{
		if(radius <= 0)
		{
			throw new IllegalValueException("IllegalValue");
		}
		this.radius = radius;
	}

	public void getArea()
	{
		System.out.println(radius * radius * PI);
	}
}

class ExceptionDemoI
{
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle(-1, 2);
		r.getArea();

		Circle c = new Circle(-5);
		c.getArea();

		System.out.println("over");
	}
}