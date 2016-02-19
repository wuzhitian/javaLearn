import java.util.*;

class Student implements Comparable
{
	private String name;
	private int age;

	Student(String name, int age)
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

	public int compareTo(Object obj)
	{
		// return 1;
		// return 0;
		return -1;
	}
}

class TreeSetDemoC
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add(new Student("lili023", 33));
		ts.add(new Student("lili021", 31));
		ts.add(new Student("lili023", 33));
		ts.add(new Student("lili020", 30));

		Iterator it = ts.iterator();
		while (it.hasNext())
		{
			Student s = (Student)it.next();

			System.out.println(s.getName()+"......"+s.getAge());
		}

	}
}