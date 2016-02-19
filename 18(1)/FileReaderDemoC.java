import java.io.*;

class FileReaderDemoC
{
	public static void main(String[] args)
	{
		FileReader fr = null;

		try
		{
			fr = new FileReader("FileReaderDemoAA.java");

			char[] buf = new char[1024];
			int num = 0;

			while((num = fr.read(buf)) != -1)
			{
				System.out.print(new String(buf));
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