import java.io.*;

class FileWriterDemoCC
{
	public static void main(String[] args)
	{
		FileWriter fw = null;
		try
		{
			fw = new FileWriter("demo.txt", true);

			for(int x = 67; x < 75; x++)
			{
				// fw.write((char)x + "\r\n");
				char[] buf = new char[]{'a', 'e', 'i', 'o', 'u'};
				fw.write(buf);
				fw.write("\r\n");
			}
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fw != null)
				{
					fw.close();
				}
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}
}