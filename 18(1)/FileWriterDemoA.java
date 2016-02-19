import java.io.*;

class FileWriterDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter("demo.txt");

		fw.write("aaaa");

		fw.flush();

		fw.write("\nbbbb");

		fw.flush();

		fw.write(" ccc");

		fw.close();
	}
}