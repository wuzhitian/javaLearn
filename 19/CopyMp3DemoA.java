import java.io.*;

class CopyMp3DemoA
{
	public static void main(String[] args) throws IOException
	{
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("1.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("2.mp3"));

		int n;

		while((n = bufis.read()) != -1)
		{
			bufos.write(n);
		}

		bufis.close();
		bufos.close();
	}
}