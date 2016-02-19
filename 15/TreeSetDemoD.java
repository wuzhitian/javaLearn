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

class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		Student s1 = (Student)obj1;
		Student s2 = (Student)obj2;

		int num = s1.getName().compareTo(s2.getName());

		if(num == 0)
		{
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}

class TreeSetDemoD
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet(new MyComparator());

		ts.add(new Student("lili021", 21));
		ts.add(new Student("lili021", 22));
		ts.add(new Student("lili022", 21));
		ts.add(new Student("lili023", 23));
		ts.add(new Student("lili022", 22));


		Iterator it = ts.iterator();

		while(it.hasNext())
		{
			Student s = (Student)it.next();

			System.out.println(s.getName()+"..||.."+s.getAge());
		}
	}
}