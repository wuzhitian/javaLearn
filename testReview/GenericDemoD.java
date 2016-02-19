import java.util.*;

class Demo<TT>
{
	private TT t;

	public void setSome(TT t)
	{
		this.t = t;
	}

	public TT getSome()
	{
		return this.t;
	}

	public <QQ> void show(QQ q)
	{
		System.out.println(q);
	}

	public static <SS> void sayHello(SS s)
	{
		System.out.println(s);
	}
}

class GenericDemoD
{
	public static void main(String[] args)
	{
		Demo<String> d = new Demo<String>();
		d.setSome("DDDDDD");
		System.out.println(d.getSome());

		d.show(55555);
		d.show("55555");

		Demo.sayHello("777777");
		Demo.sayHello(888888);
	}
}