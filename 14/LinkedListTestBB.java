import java.util.*;

interface MyGet
{
	public abstract Object myGet();
}

abstract class MyData implements MyGet
{
	private LinkedList l;

	MyData()
	{
		l = new LinkedList();
	}

	public LinkedList getL()
	{
		return l;
	}

	public void myAdd(Object obj)
	{
		l.offerFirst(obj);
	}

	public boolean isEmpty()
	{
		return l.isEmpty();
	}
}

class Queue extends MyData
{
	Queue()
	{
		super();
	}

	public Object myGet()
	{
		return super.getL().pollLast();
	}
}

class Stack extends MyData
{
	Stack()
	{
		super();
	}

	public Object myGet()
	{
		return super.getL().pollFirst();
	}
}

class LinkedListTestBB
{
	public static void main(String[] args)
	{
		Queue qq = new Queue();
		qq.myAdd("qq01");
		qq.myAdd("qq02");
		qq.myAdd("qq03");
		qq.myAdd("qq04");
		qq.myAdd("qq05");

		while(!qq.isEmpty())
		{
			sop(qq.myGet());
		}
		sop("----------------------");

		Stack ss = new Stack();
		ss.myAdd("ss01");
		ss.myAdd("ss02");
		ss.myAdd("ss03");
		ss.myAdd("ss04");
		ss.myAdd("ss05");

		while(!ss.isEmpty())
		{
			sop(ss.myGet());
		}


	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}