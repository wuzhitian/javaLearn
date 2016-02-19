import java.util.*;

class TreeSetTestA
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet(new StrLenComparator());
		ts.add("ac");
		ts.add("bc");
		ts.add("abc");
		ts.add("addebc");
		ts.add("acd");
		ts.add("bdcd");
		ts.add("ebdcd");

		Iterator it = ts.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}

class StrLenComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		String s1 = (String)obj1;
		String s2 = (String)obj2;

		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));

		if(num == 0)
		{
			return s1.compareTo(s2);
		}

		return num;
	}
}