import java.io.*;
import java.util.*;

class PropertiesExerciseDemoA
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("count.ini");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileReader fr = new FileReader(file);

		Properties props = new Properties();

		props.load(fr);

		
		int count = 0;
		String value = props.getProperty("time");

		if(value != null)
		{
			count = Integer.parseInt(value);
			if(count >= 5)
			{
				System.out.println("Time out!!!");
				return;
			}
		}
		count++;
		props.setProperty("time", count+"");

		FileWriter fw = new FileWriter(file);

		props.store(fw, "");

		fr.close();
		fw.close();

		System.out.println("Welcome!");

	}
}