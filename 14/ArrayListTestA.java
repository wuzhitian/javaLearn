import java.util.*;

class ArrayListTestA
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java03");
		al.add("java03");
		al.add("java02");

		sop(al);		//java01, java02, java01, java03, java03, java02]
		al = singleElementArray(al);
		sop(al);		//[java01, java02, java03]
	}
	public static ArrayList singleElementArray(ArrayList al)
	{
		ArrayList resultAl = new ArrayList();

		Iterator it = al.iterator();

		while(it.hasNext())
		{
			Object obj = it.next();
			if(!resultAl.contains(obj))
			{
				resultAl.add(obj);
			}
		}

		return resultAl;
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}