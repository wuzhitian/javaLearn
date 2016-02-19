import java.util.*;

class HashSetDemoB
{
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		hs.add("hs01");
		hs.add("hs02");
		hs.add("hs02");
		hs.add("hs03");
		hs.add("hs03");
		hs.add("hs04");
		hs.add("hs05");

		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next());
			// hs05
			// hs01
			// hs02
			// hs03
			// hs04
		}
	}
}