import java.util.*;

interface Inter<T>
{
	public void show(T t);

	public <W> void print(W w);
}

class DemoA implements Inter<String>
{
	public void show(String t)
	{
		System.out.println(t);
	}

	public <W> void print(W w)
	{
		System.out.println(w);
	}
}

class DemoB<E> implements Inter<E>
{
	public void show(E e)
	{
		System.out.println(e);
	}

	public <W> void print(W w)
	{
		System.out.println(w);
	}
}

class GenericDemoE
{
	public static void main(String[] args)
	{
		DemoA d1 = new DemoA();
		// d1.show(333);	//classCastException
		d1.show("hhh");
		d1.print("fff");
		d1.print(321);

		DemoB<Integer> d2 = new DemoB<Integer>();
		// d2.show("aaa");	//classCastException
		d2.show(444);
		d2.print("EEE");
		d2.print(888);
	}
}