import java.io.*;

class FileReaderDemoAA
{
	public static void main(String[] args)
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader("demo.txt");

			while(true)
			{
				int ch = fr.read();

				if(ch == -1)
				{
					break;
				}
				System.out.println((char)ch);
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