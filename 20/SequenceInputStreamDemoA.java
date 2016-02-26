import java.io.*;
import java.util.*;

class SequenceInputStreamDemoA
{
	public static void main(String[] args) throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("11.txt"));
		v.add(new FileInputStream("22.txt"));
		v.add(new FileInputStream("33.txt"));

		Enumeration<FileInputStream> en = v.elements();
		
		SequenceInputStream sis = new SequenceInputStream(en);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(sis));

		String line = null;

		BufferedWriter bufw = new BufferedWriter(new FileWriter("44.txt"));

		while((line = bufr.readLine()) != null)
		{
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();
		bufw.close();
	}
}