import java.io.*;
import java.util.*;

class PropertiesDemoB
{
	public static void main(String[] args) throws IOException
	{
		// method_1();
		loadDemo();
	}

	public static void method_1() throws IOException
	{
		Properties props = new Properties();

		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			String[] arr = line.split("=");
			props.setProperty(arr[0], arr[1]);
			// System.out.println(line);
		}

		Set<String> names = props.stringPropertyNames();

		for(String name : names)
		{
			System.out.println(name + " = " + props.getProperty(name));
		}
	}

	public static void loadDemo() throws IOException
	{
		Properties props = new Properties();
		FileReader fr = new FileReader("info.txt");
		FileInputStream fis = new FileInputStream("info.txt");
		// props.load(new FileReader("info.txt"));
		props.load(fis);

		System.out.println(props);

		props.setProperty("zhangsan", "zhangsan");

		FileWriter fw = new FileWriter("info.txt");
		// FileOutputStream fos = new FileOutputStream("info.txt");

		props.store(fw, "hh");


		fw.close();
		fr.close();
	}
}