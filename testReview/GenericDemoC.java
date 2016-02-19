import java.util.*;

class Student
{
	private String name;

	Student(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}
}

class Worker
{
	private int age;

	Worker(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return this.age;
	}
}

class Tool<TT>
{
	private TT g;

	public void setObject(TT g)
	{
		this.g = g;
	}

	public TT getObject()
	{
		return this.g;
	}
}

class GenericDemoC
{
	public static void main(String[] args)
	{
		Tool<Student> t1 = new Tool<Student>();
		t1.setObject(new Student("lili"));
		Student s = t1.getObject();
		System.out.println(s.getName());

		Tool<Worker> t2 = new Tool<Worker>();
		t2.setObject(new Worker(666));
		Worker w = t2.getObject();
		System.out.println(w.getAge());
	}
}