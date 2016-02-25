import java.io.*;

class FileListDemoC
{
	public static void main(String[] args)
	{
		File file = new File("D:\\learnSpace\\javaLearn");

		showDir(file);
	}

	public static void showDir(File dir)
	{
		System.out.println("Dir::  " + dir);
		File[] f = dir.listFiles();
		for(int x = 0; x < f.length; x++)
		{
			if(f[x].isDirectory())
			{
				showDir(f[x]);
			}
			else
			{
				System.out.println(f[x]);
			}
		}
	}
}