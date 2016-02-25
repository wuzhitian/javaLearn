import java.io.*;
import java.util.*;

class PropertiesDemoA
{
	public static void main(String[] args)
	{
		Properties props = new Properties();
		props.setProperty("zhangsan", "20");
		props.setProperty("lisi22", "31");
		props.setProperty("lisi33", "32");
		props.setProperty("lisi44", "33");
		Set<String> names = props.stringPropertyNames();

		BufferedWriter bufw = null;
		try
		{
			bufw = new BufferedWriter(new FileWriter("info.txt"));
			for(String name : names)
			{
				bufw.write(name+":"+props.getProperty(name));
				bufw.newLine();
				bufw.flush();
				// System.out.println(name + " :: " + props.getProperty(name));
			}
		}
		catch(IOException e)
		{
			System.out.println("failed");
		}
		finally
		{
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch(IOException e)
			{
				System.out.println("close failed");
			}
		}

	}
}