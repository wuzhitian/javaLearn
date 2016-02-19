class MainDemoA
{
	public static void main(String[] args)
	{
		// System.out.println()
		printArr(args);	//错误: 无法从静态上下文中引用非静态 方法 printArr(String[])
	}
	public void printArr(String[] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		}
	}
}