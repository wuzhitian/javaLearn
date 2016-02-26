import java.io.*;

class Read implements Runnable
{
	private PipedInputStream in;

	Read(PipedInputStream in)
	{
		this.in = in;
	}

	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];

			System.out.println("Before read, no data, blocking");

			int len = in.read(buf);

			System.out.println("After read, have data, block end");

			String s = new String(buf, 0, len);

			System.out.println(s);

			in.close();
		}
		catch(IOException e)
		{
			throw new RuntimeException("Piped read failed!");
		}
	}
}

class Write implements Runnable
{
	private PipedOutputStream out;

	Write(PipedOutputStream out)
	{
		this.out = out;
	}

	public void run()
	{
		try
		{
			System.out.println("Begin to write, wait 3 seconds");

			Thread.sleep(3000);

			out.write("Piped lai la".getBytes());

			out.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Piped write failed!");
		}
	}
}

class PipedStreamDemoA
{
	public static void main(String[] args) throws Exception
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);

		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
	}
}