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

	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person)){
			return false;
		}

		Person p = (Person)obj;

		System.out.println(this.name+"....."+p.name);

		return this.name.equals(p.getName()) && this.age == p.getAge();
		
		// return this.name.equals(p.name) && this.age == p.age;
	}
}
class ArrayListTestB
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();

		al.add(new Person("lili01", 31));
		al.add(new Person("lili02", 32));
		al.add(new Person("lili02", 32));
		al.add(new Person("lili04", 34));
		al.add(new Person("lili04", 34));
		al.add(new Person("lili05", 35));

		al = singleEleArrayList(al);

		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"::"+p.getAge());
		}

		sop("remove:::"+al.remove(new Person("lili02", 32)));	//true
		sop("remove:::"+al.remove(new Person("lili03", 32)));	//false
	}

	public static ArrayList singleEleArrayList(ArrayList al)
	{
		ArrayList resultAL = new ArrayList();

		Iterator it = al.iterator();

		while(it.hasNext())
		{
			Person p = (Person)it.next();
			if(!resultAL.contains(p))
			{
				resultAL.add(p);
			}
		}
		return resultAL;
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}