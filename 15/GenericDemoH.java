import java.util.*;

class Person
{
	private String name;
	private int age;

	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return this.name;
	}

	public int getAge()
	{
		return this.age;
	}
}

class Student extends Person
{
	Student(String name, int age)
	{
		super(name, age);
	}
}

class Worker extends Person
{
	Worker(String name, int age)
	{
		super(name, age);
	}
}


class GenericDemoH
{
	public static void main(String[] args)
	{
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("aba", 11));
		al.add(new Student("abb", 12));
		al.add(new Student("abc", 13));
		al.add(new Student("abd", 14));

		printColl(al);
	}

	public static void printColl(ArrayList<? extends Person> al)
	{
		Iterator<? extends Person> it = al.iterator();

		while(it.hasNext())
		{
			Person p = it.next();
			System.out.println(p.getName() + "--||--" + p.getAge());
		}
	}
}