import java.util.*;

class LinkedListDemoA
{
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();

		l.offerFirst("java01");
		l.offerFirst("java02");
		l.offerFirst("java03");
		l.offerFirst("java04");

		sop(l);		//[java04, java03, java02, java01]

		sop(l.peekFirst());		//java04
		sop(l.peekFirst());		//java04
		sop(l.peekLast());		//java01

		sop(l.size());

		sop(l.pollFirst());		//java04;
		sop(l.size());
		sop(l.pollFirst());		//java03;

		while(!l.isEmpty())
		{
			sop(l.pollFirst());
			// java02
			// java01
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}