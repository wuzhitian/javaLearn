import java.util.*;

class Demo
{
	public int hashCode()
	{
		return 15;
	}
}

class HashSetDemoA
{
	public static void main(String[] args)
	{
		Demo d1 = new Demo();
		Demo d2 = new Demo();
		sop(d1);	//Demo@f
		sop(d2);	//Demo@f
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}