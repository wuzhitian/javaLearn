import java.io.*;

class LineNumberReaderDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("BufferedWriterDemoA.java");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;

		lnr.setLineNumber(100);
		while((line = lnr.readLine()) != null)
		{
			System.out.println(lnr.getLineNumber() + " : " + line);
		}

		lnr.close();
	}
}