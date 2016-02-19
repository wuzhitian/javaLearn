abstract class Animal
{
	public abstract void shout();
}

class Cat extends Animal
{
	public void shout()
	{
		System.out.println("miao");
	}

	public void eat()
	{
		System.out.println("eat fish");
	}
}

class Dog extends Animal
{
	public void shout()
	{
		System.out.println("wang");
	}
	public void eat()
	{
		System.out.println("eat bone");
	}
}

class DuotaiDemoB
{
	public static void main(String[] args)
	{

		Animal cat = new Cat();
		foo(cat);

		Animal dog = new Dog();
		foo(dog);
		

	}

	public static void foo(Animal a)
	{
		a.shout();

		if(a instanceof Cat)
		{
			Cat b = (Cat)a;
			b.eat();
		}else if(a instanceof Dog)
		{
			Dog b = (Dog)a;
			b.eat();
		}
	}
}