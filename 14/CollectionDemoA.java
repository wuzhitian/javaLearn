import java.util.*;

class CollectionDemoA
{
	public static void main(String[] args)
	{
		// methodA();
		methodB();
	}

	public static void methodA()
	{
		ArrayList al1 = new ArrayList();

		al1.add("java01");
		al1.add("java02");
		al1.add("java03");

		sop(al1);						// [java01, java02, java03]
		sop(al1.size());				// 3

		sop(al1.remove("java02"));		// true
		sop(al1.remove("java04"));		// false
		sop(al1);						// [java01, java03]
		sop(al1.contains("java01"));	// true

		al1.clear();
		sop(al1);						// []
		sop(al1.isEmpty());				// true
	}

	public static void methodB()
	{
		ArrayList al1 = new ArrayList();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");

		ArrayList al2 = new ArrayList();
		al2.add("java3");
		al2.add("java4");
		al2.add("java5");
		al2.add("java6");

		al1.retainAll(al2);

		sop(al1);						// [java3, java4]
		sop(al2);						// [java3, java4, java5, java6]



		ArrayList al3 = new ArrayList();
		al3.add("java1");
		al3.add("java2");
		al3.add("java3");
		al3.add("java4");

		ArrayList al4 = new ArrayList();
		al4.add("java3");
		al4.add("java4");
		al4.add("java5");
		al4.add("java6");

		al3.removeAll(al4);
		sop(al3);						// [java1, java2]
		sop(al4);						// [java3, java4, java5, java6]



		ArrayList al5 = new ArrayList();
		al5.add("java1");
		al5.add("java2");
		al5.add("java3");
		al5.add("java4");

		ArrayList al6 = new ArrayList();
		al6.add("java3");
		al6.add("java4");
		al6.add("java5");
		al6.add("java6");

		al5.addAll(al6);
		sop(al5);	//[java1, java2, java3, java4, java3, java4, java5, java6]
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}