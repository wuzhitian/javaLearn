import java.io.*;

class FileRenameToDemoA
{
	public static void main(String[] args) throws IOException
	{
		File f1 = new File("f1.txt");
		f1.createNewFile();
		File f2 = new File("f2.txt");

		f1.renameTo(f2);
	}
}