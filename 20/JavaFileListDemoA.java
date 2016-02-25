import java.io.*;
import java.util.*;

class JavaFileListDemoA
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("D:\\learnSpace\\Java");
		List<File> list = new ArrayList<File>();

		getFileList(file, list);

		System.out.println(list.size());

		File javaFileList = new File("javaFileList.txt");
		writeToFile(list, javaFileList);

	}

	public static void getFileList(File dir, List<File> list)
	{
		File[] files = dir.listFiles();
		System.out.println(dir);
		for(File file : files)
		{
			if(file.isDirectory())
			{
				getFileList(file, list);
			}
			else
			{
				if(file.getName().endsWith(".java"))
				{
					list.add(file);
				}
			}
		}
	}

	public static void writeToFile(List<File> list, File file) throws IOException
	{
		BufferedWriter bufw = null;

		try
		{
			bufw = new BufferedWriter(new FileWriter(file));
			for(File f : list)
			{
				bufw.write(f.getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(IOException e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch(IOException e)
			{
				throw e;
			}
		}
	}
}