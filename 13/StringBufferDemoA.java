class StringBufferDemoA
{
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("321").append(true).append("ddd");

		sop(sb);				//321trueddd

		sb.insert(1, "uuuu");
		sop(sb);				//3uuuu21trueddd
		sop(sb.toString());		//3uuuu21trueddd
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}