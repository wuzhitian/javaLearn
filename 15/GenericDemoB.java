import java.util.*;

class Student implements Comparable<Student>
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

	public int compareTo(Student s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num == 0)
		{
			return this.name.compareTo(s.name);
		}
		return num;
	}
}

class MyComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		int num = new Integer(s2.getAge()).compareTo(new Integer(s1.getAge()));
		if(num == 0)
		{
			return s2.getName().compareTo(s1.getName());
		}
		return num;
	}
}

class GenericDemoB
{
	public static void main(String[] args)
	{
		TreeSet<Student> ts = new TreeSet<Student>();

		ts.add(new Student("aaa", 41));
		ts.add(new Student("aba", 42));
		ts.add(new Student("ama", 42));
		ts.add(new Student("caa", 43));
		ts.add(new Student("baa", 43));
		ts.add(new Student("aan", 43));
		ts.add(new Student("aaa", 44));

		Iterator<Student> it = ts.iterator();

		while(it.hasNext())
		{
			Student s = it.next();
			sop(s.getName() + "::|||::"+s.getAge());
		}

		sop("----------------------------");

		TreeSet<Student> ts2 = new TreeSet<Student>(new MyComparator());

		ts2.add(new Student("aaa", 41));
		ts2.add(new Student("aba", 42));
		ts2.add(new Student("ama", 42));
		ts2.add(new Student("caa", 43));
		ts2.add(new Student("baa", 43));
		ts2.add(new Student("aan", 43));
		ts2.add(new Student("aaa", 44));

		Iterator<Student> it2 = ts2.iterator();

		while(it2.hasNext())
		{
			Student s = it2.next();
			sop(s.getName() + "::|||::"+s.getAge());
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}