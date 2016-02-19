import java.io.*;

class FileCopyDemoA
{
	public static void main(String[] args)
	{
		FileReader fr = null;
		FileWriter fw = null;

		try
		{
			fr = new FileReader("FileWriterDemoB.java");
			fw = new FileWriter("FileWriterDemoB.txt");

			char[] buf = new char[1024];
			int len = 0;
			while((len = fr.read(buf)) != -1)
			{
				fw.write(buf, 0, len);
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			if(fr != null)
			{
				try
				{
					fr.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
			if(fw != null)
			{
				try
				{
					fw.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}