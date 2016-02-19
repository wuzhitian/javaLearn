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
		if(!(obj instanceof Student))
		{
			throw new RuntimeException("Obj is not instanceof Student");
		}

		Student s = (Student)obj;

		int result = this.age - s.age;

		if(result == 0)
		{
			return this.name.compareTo(s.name);
		}
		return result;
	}
}


class TreeSetDemoB
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add(new Student("lili01", 31));
		ts.add(new Student("lili05", 35));
		ts.add(new Student("lilb03", 33));
		ts.add(new Student("lila02", 32));
		ts.add(new Student("lila02", 32));
		ts.add(new Student("lilb03", 33));
		ts.add(new Student("lilb04", 34));

		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			Student s = (Student)it.next();

			sop(s.getName()+"..||.."+s.getAge());
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}