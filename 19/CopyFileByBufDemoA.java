import java.io.*;

class CopyFileByBufDemoA
{
	public static void main(String[] arg)
	{
		BufferedReader bufr = null;
		BufferedWriter bufw = null;

		try
		{
			bufr = new BufferedReader(new FileReader("buf.txt"));
			bufw = new BufferedWriter(new FileWriter("buf_copy.txt"));

			String line = null;

			while((line = bufr.readLine()) != null)
			{
				bufw.write(line);
				bufw.newLine();
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			try
			{
				if(bufr != null)
				{
					bufr.close();
				}
			}
			catch(IOException e)
			{
				throw new RuntimeException("关闭读取文件失败");
			}
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch(IOException e)
			{
				throw new RuntimeException("关闭写入文件失败");
			}
		}
	}
}