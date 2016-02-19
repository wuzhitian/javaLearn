import java.util.*;

class GenericDemoA
{
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("java01");
		al.add("jav02");
		al.add("ja03");
		al.add("j04");
		al.add("java05");

		Iterator<String> it = al.iterator();

		while(it.hasNext())
		{
			String s = it.next();

			System.out.println(s+"::"+s.length());
		}
	}
}