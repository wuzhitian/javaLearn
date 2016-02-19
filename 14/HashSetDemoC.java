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

	public int hashCode()
	{
		System.out.println(this.name+"...hashCode");
		return this.name.hashCode() + this.age*45;
	}

	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
		{
			return false;
		}

		Person p = (Person)obj;

		System.out.println(this.name+"...equals..."+p.name);

		return this.name.equals(p.name) && this.age == p.age;
	}
}



class HashSetDemoC
{
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		hs.add(new Person("lili01", 41));
		hs.add(new Person("lili02", 42));
		hs.add(new Person("lili01", 41));
		hs.add(new Person("lili03", 43));
		hs.add(new Person("lili04", 44));

		sop("a3 contains:: " + hs.contains(new Person("lili03", 43)));
		sop("a3 remove:: " + hs.remove(new Person("lili03", 43)));

		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"|||"+p.getAge());
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}