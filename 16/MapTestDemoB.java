import java.util.*;

class MyComparatorA implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		int num = new Integer(s2.getAge()).compareTo(new Integer(s1.getAge()));
		if(num == 0)
		{
			return s2.getName().compareTo(s2.getName());
		}
		return num;
	}
}

class MyComparatorB implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if(num == 0)
		{
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}

class MapTestDemoB
{
	public static void main(String[] args)
	{
		TreeMap<Student, String> sts = new TreeMap<Student, String>();
		sts.put(new Student("YY01", 11), "Beijing");
		sts.put(new Student("YY04", 14), "Nanjing");
		sts.put(new Student("YY02", 12), "Tianjin");
		sts.put(new Student("YY05", 15), "Guangzhou");
		sts.put(new Student("YY03", 13), "Wuhan");

		printColl(sts, " ^---^ ");

		System.out.println("---------------------------------");

		TreeMap<Student, String> stsA = new TreeMap<Student, String>(new MyComparatorA());

		stsA.put(new Student("BB02", 12), "BBBB");
		stsA.put(new Student("CC03", 13), "CCCC");
		stsA.put(new Student("AA01", 11), "AAAA");
		stsA.put(new Student("EE05", 15), "EEEE");
		stsA.put(new Student("DD04", 14), "DDDD");

		printColl(stsA, " **----** ");

		System.out.println("---------------------------------");
		
		TreeMap<Student, String> stsB = new TreeMap<Student, String>(new MyComparatorB());

		stsB.put(new Student("BB02", 12), "BBBB");
		stsB.put(new Student("CC03", 13), "CCCC");
		stsB.put(new Student("AA01", 11), "AAAA");
		stsB.put(new Student("EE05", 15), "EEEE");
		stsB.put(new Student("DD04", 14), "DDDD");

		printColl(stsB, " **----** ");

	}

	public static void printColl(TreeMap<Student, String> sts, String sperator)
	{
		Set<Student> set = sts.keySet();

		Iterator<Student> it = set.iterator();

		while(it.hasNext())
		{
			Student s = it.next();

			System.out.println(s.getMessage() + sperator + sts.get(s));
		}
	}
}