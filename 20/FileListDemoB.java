import java.io.*;

class FileListDemoB
{
	public static void main(String[] args) throws IOException
	{
		File temp = new File("temp.txt");
		File absPath = temp.getAbsoluteFile();
		temp.deleteOnExit();


		File parentFile = absPath.getParentFile();
		String[] javaNames = parentFile.list(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith("class");
			}
		});

		for(String name : javaNames)
		{
			System.out.println(name);
		}

	}
}