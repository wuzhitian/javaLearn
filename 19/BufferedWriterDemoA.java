import java.io.*;

class BufferedWriterDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter("buf.txt", true);

		BufferedWriter bufw = new BufferedWriter(fw);

		for(int x = 0; x < 5; x++)
		{
			bufw.write("abcde" + x);
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
	}
}