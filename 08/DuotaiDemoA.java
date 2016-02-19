abstract class Animal
{
	public abstract void eat();
	public abstract void shout();
}

class Cat extends Animal
{
	public void eat()
	{
		System.out.println("eat fish");
	}
	public void shout()
	{
		System.out.println("miao miao");
	}
}

class Dog extends Animal
{
	public void eat()
	{
		System.out.println("eat bone");
	}
	public void shout()
	{
		System.out.println("wang wang");
	}
}

class DuotaiDemoA
{
	public static void main(String[] args)
	{
		shout(new Cat());
		shout(new Dog());
	}

	public static void shout(Animal a)
	{
		a.shout();
	}
}