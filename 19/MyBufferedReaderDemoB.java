import java.io.*;

class MyBufferedReader extends Reader
{
	private Reader r = null;
	MyBufferedReader(Reader r)
	{
		this.r = r;
	}

	public String myReadLine() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int ch = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\r')
			{
				continue;
			}
			if(ch == '\n')
			{
				return sb.toString();
			}
			sb.append((char)ch);
		}

		if(sb.length() != 0)
		{
			return sb.toString();
		}

		return null;
	}

	public void myClose() throws IOException
	{
		r.close();
	}

	public int read(char[] cbuf, int off, int len) throws IOException
	{
		return r.read(cbuf, off, len);
	}

	public void close() throws IOException
	{
		r.close();
	}
}

class MyBufferedReaderDemoB
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("buf.txt");

		MyBufferedReader mybufr = new MyBufferedReader(fr);

		String line = null;

		while((line = mybufr.myReadLine()) != null)
		{
			System.out.println(line);
		}

		mybufr.myClose();
	}
}