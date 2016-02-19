package pack;

import packa.PackageA;
import packb.PackageB;


class Package
{
	public static void main(String[] args)
	{
		PackageA a = new PackageA();
		a.run();

		PackageB b = new PackageB();
		b.run();
	}
}