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


class LinkedListTestB
{
	public static void main(String[] args)
	{
		Queue qq = new Queue();
		qq.myAdd("java01");
		qq.myAdd("java02");
		qq.myAdd("java03");
		qq.myAdd("java04");

		while(!qq.isEmpty())
		{
			sop(qq.myGet());
			// java01
			// java02
			// java03
			// java04
		}



		Stack ss = new Stack();
		ss.myAdd("JJ01");
		ss.myAdd("JJ02");
		ss.myAdd("JJ03");
		ss.myAdd("JJ04");

		while(!ss.isEmpty())
		{
			sop(ss.myGet());
			// JJ04
			// JJ03
			// JJ02
			// JJ01
		}
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}