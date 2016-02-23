import java.io.*;

class TransStreamDemoD
{
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("BufferedWriterDemoA.java"));
		System.setOut(new PrintStream("setIn&setOut.txt"));

		LineNumberReader lnfr = new LineNumberReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while((line = lnfr.readLine()) != null)
		{
			if("over".equals(line.toLowerCase()))
			{
				break;
			}
			bufw.write(lnfr.getLineNumber() + " : " + line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		lnfr.close();
		bufw.close();
	}
}