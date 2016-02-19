import java.util.*;

class TreeSetDemoA
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();

		ts.add("abcd");
		ts.add("cdbd");
		ts.add("aaed");
		ts.add("eescd");

		Iterator it = ts.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}