package pack;

class PackageDemo
{
	public static void main(String[] args)
	{
		System.out.println("Hello world! PackageDemo.");
		packa.PackageDemoA a = new packa.PackageDemoA();
		a.run();

		packb.PackageDemoB b = new packb.PackageDemoB();
		b.run();
		// b.show();	//错误
	}
}