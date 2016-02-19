import java.io.*;

class FileReaderDemoA
{
	public static void main(String[] args)
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader("demo.txt");


			// int ch = 0;
			// while((ch = fr.read()) != -1)
			// {
			// 	System.out.println((char)ch);
			// }
			

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
			System.out.println("catch: " + e.toString());
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
				System.out.println("catch: "+ e.toString());
			}
		}
	}
}