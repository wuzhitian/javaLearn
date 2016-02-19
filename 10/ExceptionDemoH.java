class AException extends Exception
{
	AException(String msg)
	{
		super(msg);
	}
}
class AaException extends AException
{
	AaException(String msg)
	{
		super(msg);
	}
}

class BException extends Exception
{
	BException(String msg)
	{
		super(msg);
	}
}

class Fu
{
	public void fooA() throws AException
	{

	}
	public void fooB() throws AException
	{

	}
	public void fooC()
	{

	}
}

class Test
{
	public void foo(Fu f)
	{
		try
		{
			f.fooA();
		}
		catch(AException e)
		{
			System.out.println(e.toString());
		}
	}
}

class Zi extends Fu
{
	public void fooA() throws AaException
	{

	}

	// public void fooB() throws BException
	// {
			// 错误：
			// Zi中的fooB()无法覆盖Fu中的fooB()
	    	// public void fooB() throws BException
			// 被覆盖的方法未抛出BException
			// 
			// 子类覆盖方法时，抛出的异常必须是父类方法抛出的异常的类或者子类
	// }

	// public void fooC() throws AException
	// {
			// 错误：
			// Zi中的fooC()无法覆盖Fu中的fooC()
	        // public void fooC() throws AException
			// 被覆盖的方法未抛出AException
			// 
			// 子类覆盖方法时，如果父类该方法没有异常抛出，
			// 那么子类该方法也不能抛出异常
	// }
}

class ExceptionDemoH
{
	public static void main(String[] args)
	{
		Test t = new Test();
		t.foo(new Fu());
	}
}