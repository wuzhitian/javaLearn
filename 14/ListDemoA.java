import java.util.*;

class ListDemoA
{
	public static void main(String[] args)
	{
		methodA();
		methodB();
	}

	public static void methodA()
	{
		ArrayList al = new ArrayList();

		al.add("j01");
		al.add("j02");
		al.add("j03");
		al.add("j04");

		sop(al);		//[j01, j02, j03, j04]

		al.add(1, "java02");

		sop(al);		//[j01, java02, j02, j03, j04]

		al.remove(2);

		sop(al);		//[j01, java02, j03, j04]

		for(int x = 0; x < al.size(); x ++)
		{
			sop(al.get(x));
			// j01
			// java02
			// j03
			// j04
		}

		sop(al.indexOf("j03"));		//2

		List sub = al.subList(2, 4);
		sop(sub);			//[j03, j04]
	}

	public static void methodB()
	{
		ArrayList al = new ArrayList();

		al.add("j01");
		al.add("j02");
		al.add("j03");
		al.add("j04");

		ListIterator lt = al.listIterator();

		while (lt.hasNext())
		{
			if(lt.next().equals("j03"))
			{
				lt.set("jjjjj03");
			}
			if(lt.next().equals("j02"))
			{
				lt.add("ooo09");
			}
		}
		sop(al);	//[j01, j02, ooo09, jjjjj03, j04]

		while(lt.hasPrevious())
		{
			sop(lt.previous());
			// j04
			// jjjjj03
			// ooo09
			// j02
			// j01
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}