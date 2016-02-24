import java.io.*;

class MyFileNameFilter implements FileFilter
{
	boolean accept(File f, String name)
	{
		
	}
}

class FileListDemoB
{
	public static void main(String[] args) throws IOException
	{
		File temp = new File("temp.txt");
		File absPath = temp.getAbsoluteFile();
		temp.deleteOnExit();


		File parentFile = absPath.getParentFile();
		String[] javaNames = parentFile.list();

		for(String name : javaNames)
		{
			System.out.println(name);
		}

	}
}