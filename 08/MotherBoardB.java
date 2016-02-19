interface PCI
{
	public void open();
	public void close();
}

class NetCard implements PCI
{
	public void open()
	{
		System.out.println("NetCard run");
	}

	public void close()
	{
		System.out.println("NetCard close");
	}
}

class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("SoundCard run");
	}
	public void close()
	{
		System.out.println("SoundCard close");
	}
}

class MotherBoardBBB
{
	public void run()
	{
		System.out.println("MotherBoardBBB run");
	}

	public void usePCI(PCI c)
	{
		if(c != null)
		{
			c.open();
			c.close();
		}
	}
}

class MotherBoardB
{
	public static void main(String[] args)
	{
		MotherBoardBBB m = new MotherBoardBBB();
		m.run();
		m.usePCI(new NetCard());
		m.usePCI(new SoundCard());
	}
}