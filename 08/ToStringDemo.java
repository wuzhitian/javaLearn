class Demo
{

}

class ToStringDemo
{
	public static void main(String[] args)
	{
		Demo d1 = new Demo();
		System.out.println(d1.hashCode());
		System.out.println(Integer.toHexString(d1.hashCode()));
		System.out.println(d1.toString());
		System.out.println(d1.());
	}
}