import java.io.*;

class FileReaderDemoB
{
	public static void main(String[] args)
	{
		FileReader fr = null;

		try
		{
			fr = new FileReader("demo.txt");

			char[] buf = new char[3];

			int num = 0;

			while ((num = fr.read(buf)) != -1)
			{
				System.out.println("TypeA: num: " + num + "  string: " + new String(buf));
				System.out.println("TypeB: num: " + num + "  string: " + new String(buf, 0, num));
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
				if(fr != null)
				{
					fr.close();
				}
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}
}