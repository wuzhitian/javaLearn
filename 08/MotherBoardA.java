class MotherBoard
{
	public void run()
	{
		System.out.println("MotherBoard run");
	}

	public void runNetCard(NetCard c)
	{
		c.open();
		c.close();
	}
}

class NetCard
{
	public void open()
	{
		System.out.println("NetCard open");
	}

	public void close()
	{
		System.out.println("NetCard close");
	}
}

class MotherBoardA
{
	public static void main(String[] args)
	{
		MotherBoard m = new MotherBoard();
		m.run();
		m.runNetCard(new NetCard());
	}
}