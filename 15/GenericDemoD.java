import java.util.*;

class Demo<T>
{

	private T t;
	public void setSome(T t)
	{
		this.t = t;
	}
	public T getSome()
	{
		return this.t;
	}

	public <Q> void show(Q q)
	{
		System.out.println(q);
	}

	public <W> void print(W w)
	{
		System.out.println(w);
	}

	public static <S> void sayHi(S s)
	{
		System.out.println(s);
	}

	// public static void sayHello(T t)
	// 无法从静态上下文中引用非静态类型变量 T
	// {
	// 	System.out.println(t);
	// }
}

class GenericDemoD
{
	public static void main(String[] args)
	{
		Demo<String> d = new Demo<String>();
		d.show(43);
		d.show("SSSS");
		d.print("WWWW");

		// d.setSome(444);		//Error：ClassCastException
		d.setSome("OOOO");
		System.out.println(d.getSome());	//"OOOO"

		Demo.sayHi("Hellowwwwwwww");	//Hellowwwwwwww
	}
}