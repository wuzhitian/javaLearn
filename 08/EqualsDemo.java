class Demo
{

}

class EqualsDemo
{
	public static void main(String[] args)
	{
		Demo d1 = new Demo();
		Demo d2 = new Demo();
		Demo d3 = d1;

		logEquals(d1, d2);	//false
		logEquals(d1, d3);	//true 

	}
	public static void logEquals(Object o1, Object o2)
	{
		System.out.println(o1.equals(o2));
	}
}