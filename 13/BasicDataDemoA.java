class BasicDataDemoA
{
	public static void main(String[] args)
	{
		sop(Integer.MAX_VALUE);				//	2147483647
		sop(Integer.MIN_VALUE);				//	-2147483648
		sop(Integer.TYPE);					//	int
		sop(Integer.SIZE);					//	32
		sop(Integer.parseInt("432"));		//  432

		sop(Integer.parseInt("110", 2));	//  6
		sop(Integer.parseInt("170", 8));	//  120
		sop(Integer.parseInt("110", 10));	//  110
		sop(Integer.parseInt("1a0", 16));	//  416

		sop(Integer.toBinaryString(6));		//  110
		sop(Integer.toHexString(699));		//  2bb
		sop(Integer.toOctalString(4432));	//  10520



		sop(Boolean.parseBoolean("true"));	//  true
		sop(Boolean.parseBoolean("tRue"));	//  true
		sop(Boolean.parseBoolean("false"));	//  false
		sop(Boolean.parseBoolean(""));		//  false
		sop(Boolean.parseBoolean("aaa"));	//  false



		sop(Double.parseDouble("122.112"));	//  122.112


		Integer num = new Integer("4432");
		sop(num);					//  4432
		sop(num.intValue());		//  4432
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}