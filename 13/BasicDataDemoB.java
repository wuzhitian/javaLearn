class BasicDataDemoB
{
	public static void main(String[] args)
	{
		Integer a = new Integer(123);
		Integer b = new Integer(123);
		sop("a.equals(b):" + (a.equals(b)));	//true
		sop("a == b:" + (a == b));				//false


		Integer mm = 128;
		Integer nn = 128;
		sop("mm == nn: " + (mm == nn));	//false


		Integer aa = 127;
		Integer bb = 127;
		sop("aa == bb: "+ (aa == bb));	//true


		Integer xx = 4;
		xx = xx + 4;
		sop(xx);		//8
	}


	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}