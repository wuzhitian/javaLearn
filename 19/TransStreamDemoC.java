import java.io.*;

class TransStreamDemoC
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("code_demo.txt"), "UTF-8"));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line.toLowerCase()))
			{
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();
		bufw.close();
	}
}