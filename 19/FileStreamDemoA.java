import java.io.*;

class FileStreamDemoA
{
	public static void main(String[] args) throws IOException
	{
		writeFile();
		// readFileA();
		// readFileB();
		readFileC();
	}

	public static void readFileA() throws IOException
	{
		FileInputStream fis = new FileInputStream("stream.txt");

		int b;

		while((b = fis.read()) != -1)
		{
			System.out.println((char)b);
		}
		fis.close();
	}

	public static void readFileB() throws IOException
	{
		FileInputStream fis = new FileInputStream("stream.txt");

		byte[] buf = new byte[1024];

		int len;

		while((len = fis.read(buf)) != -1)
		{
			System.out.println(new String(buf, 0, len));
		}

		fis.close();
	}

	public static void readFileC() throws IOException
	{
		FileInputStream fis = new FileInputStream("stream.txt");

		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		System.out.println(new String(buf));

		fis.close();
	}

	public static void writeFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("stream.txt");

		fos.write("aabbccdd".getBytes());

		fos.close();
	}
}