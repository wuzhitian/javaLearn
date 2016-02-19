interface Inter
{
	public static final int NUM = 55;

	public abstract void show();
}

interface InterA
{
	public static final int NUM = 88;

	public abstract int show();
}

class Test implements Inter, InterA
{
	//返回类型int与void不兼容
	public void show()
	{

	}
}

class InterfaceDemoA
{
	public static void main(String[] args)
	{
		Test t1 = new Test();
		System.out.println(t1.NUM);	
		// 错误: 对NUM的引用不明确
		// System.out.println(t1.NUM);
	    //                        ^
		// Inter 中的变量 NUM 和 InterA 中的变量 NUM 都匹配
		System.out.println(Inter.NUM);
	}
}