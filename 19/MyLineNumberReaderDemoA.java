import java.io.*;

class MyLineNumberReader
{
	private Reader r;

	private int lineNumber;

	MyLineNumberReader(Reader r)
	{
		this.r = r;
	}

	public String myReaderLine() throws IOException
	{
		lineNumber++;

		StringBuilder sb = new StringBuilder();

		int ch = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\r')
			{
				continue;
			}
			else if(ch == '\n')
			{
				return sb.toString();
			}
			else {
				sb.append((char)ch);
			}
		}
		if(sb.length() != 0)
		{
			return sb.toString();
		}
		return null;
	}

	public void setLineNumber(int number)
	{
		this.lineNumber = number;
	}

	public int getLineNumber()
	{
		return this.lineNumber;
	}

	public void myClose() throws IOException
	{
		r.close();
	}
}

class MyLineNumberReaderDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("BufferedWriterDemoA.java");

		MyLineNumberReader mlnr = new MyLineNumberReader(fr);

		String line = null;

		mlnr.setLineNumber(100);

		while((line = mlnr.myReaderLine()) != null)
		{
			System.out.println(mlnr.getLineNumber() + ":" + line);
		}

		mlnr.myClose();
	}
}