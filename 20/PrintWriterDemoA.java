import java.io.*;

class PrintWriterDemoA
{
	public static void main(String[] args) throws IOException
	{
		// method_1();
		// method_2();
		method_3();
	}

	public static void method_1() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			pw.println(line.toUpperCase());
			pw.flush();
		}

		bufr.close();
		pw.close();
	}

	public static void method_2() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintStream pw = new PrintStream(new File("Print.txt"));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			pw.println(line.toUpperCase());
			pw.flush();
		}

		bufr.close();
		pw.close();
	}

	public static void method_3() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintStream pw = new PrintStream(new FileOutputStream("Print.txt"), true);

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			pw.println(line.toUpperCase());
		}

		bufr.close();
		pw.close();
	}
}