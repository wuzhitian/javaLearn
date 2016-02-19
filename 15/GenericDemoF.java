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

class MyComparator implements Comparator<Person>
{
	public int compare(Person p1, Person p2)
	{
		return p1.getName().compareTo(p2.getName());
	}
}

class GenericDemoF
{
	public static void main(String[] args)
	{
		TreeSet<Student> tss = new TreeSet<Student>(new MyComparator());
		tss.add(new Student("ss1", 11));
		tss.add(new Student("ss3", 13));
		tss.add(new Student("ss2", 12));
		tss.add(new Student("ss5", 15));
		tss.add(new Student("ss4", 14));

		printColl(tss);



		TreeSet<Worker> tsw = new TreeSet<Worker>(new MyComparator());
		tsw.add(new Worker("ww1", 21));
		tsw.add(new Worker("ww5", 25));
		tsw.add(new Worker("ww3", 23));
		tsw.add(new Worker("ww4", 24));
		tsw.add(new Worker("ww2", 22));

		printColl(tsw);
	}

	public static void printColl(TreeSet<? extends Person> al)
	{
		Iterator<? extends Person> it = al.iterator();

		while(it.hasNext())
		{
			Person p = it.next();
			System.out.println(p.getName()+"--||--"+p.getAge());
		}
	}
}