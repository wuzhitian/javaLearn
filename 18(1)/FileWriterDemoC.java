import java.io.*;

class FileWriterDemoC
{
	public static void main(String[] args)
	{
		FileWriter fw = null;

		try
		{
			fw = new FileWriter("demo.txt", true);
			fw.write("\r\nAAAAAAA");
		}
		catch(IOException e)
		{
			System.out.println("catch: " + e.toString());
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
				System.out.println("catch: " + e.toString());
			}
		}
	}
}