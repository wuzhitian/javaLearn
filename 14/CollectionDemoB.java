import java.util.*;

class CollectionDemoB
{
	public static void main(String[] args)
	{
		ArrayList al1 = new ArrayList();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");

		Iterator it = al1.iterator();

		while(it.hasNext())
		{
			sop(it.next());
		}


		sop(it.hasNext());	//false
		al1.add("java5");
		sop(al1);
		sop(it.hasNext());	//true
		// sop(it.next());	//ConcurrentModificationException


		for(Iterator itt = al1.iterator(); itt.hasNext();)
		{
			sop(itt.next());
		}

		// int x = 0;
		// Iterator ittt = al1.iterator();
		// while(x < 5)
		// {
		// 	sop(ittt.next());
		// 	al1.add("java6");
		// 	x++;
		// }

	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}