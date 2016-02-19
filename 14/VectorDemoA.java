import java.util.*;

class VectorDemoA
{
	public static void main(String[] args)
	{
		Vector v = new Vector();
		v.add("java1");
		v.add("java2");
		v.add("java3");
		v.add("java4");

		Enumeration en = v.elements();

		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
			// java1
			// java2
			// java3
			// java4
		}
	}
}