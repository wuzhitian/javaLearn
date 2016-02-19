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

	public String getMessage()
	{
		return this.name +"..."+ this.age;
	}

	public int compareTo(Student s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num == 0)
		{
			return this.name.compareTo(s.name);
		}
		else
		{
			return num;
		}
	}

	public int hashCode()
	{
		return this.name.hashCode() + this.age * 43;
	}

	// public boolean equals(Student s)			!!!!!!!
	// {
	// 	return this.name.equals(s.name) && this.age == s.age;
	// }
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
		{
			throw new ClassCastException("Obj is not the instance of Sutdent");
		}
		Student s = (Student)obj;

		return this.name.equals(s.name) && this.age == s.age;

	}
}


class MapTestDemoA
{
	public static void main(String[] args)
	{
		Map<Student, String> sts = new HashMap<Student, String>();

		sts.put(new Student("YY01", 11), "Beijin");
		sts.put(new Student("YY02", 12), "Shanghai");
		sts.put(new Student("YY02", 12), "Nanjing");
		sts.put(new Student("YY03", 13), "Tianjin");
		sts.put(new Student("YY04", 14), "Wuhan");
		sts.put(new Student("YY05", 15), "Guangzhou");

		// System.out.println(sts);
		
		Set<Student> keyset = sts.keySet();

		Iterator<Student> itk = keyset.iterator();
		while(itk.hasNext())
		{
			Student s = itk.next();
			System.out.println(s.getMessage() +"---"+sts.get(s));
		}

		System.out.println("---------------------------------------");

		Set<Map.Entry<Student, String>> entrySet = sts.entrySet();
		Iterator<Map.Entry<Student, String>> ite = entrySet.iterator();
		while(ite.hasNext())
		{
			Map.Entry<Student, String> e = ite.next();

			Student key = e.getKey();
			String addr = e.getValue();

			System.out.println(key.getMessage() +"||||"+ addr);
		}
	}
}