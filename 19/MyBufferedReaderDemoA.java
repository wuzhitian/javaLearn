import java.io.*;

class MyBufferedReader
{
	private FileReader r = null;
	MyBufferedReader(FileReader r)
	{
		this.r = r;
	}

	public String myReadLine() throws IOException
	{
		//定义一个临时容器。原BufferReader封装的是字符数组。
		//为了方便演示，定义一个StringBuilder容器。
		//因为最终还是要将数据变成字符串。
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
}

class MyBufferedReaderDemoA
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