package pack;

import packa.PackageDemoA;
import packb.PackageDemoB;

class PackageDemo
{
	public static void main(String[] args)
	{
		System.out.println("Hello world! PackageDemo.");
		PackageDemoA a = new PackageDemoA();
		a.run();

		PackageDemoB b = new PackageDemoB();
		b.run();
		// b.show();	//错误
	}
}
