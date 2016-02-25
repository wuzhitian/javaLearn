import java.io.*;

class RemoveDirDemoA
{
	public static void main(String[] args)
	{
		File file = new File("D:\\learnSpace\\javaLearn222");
		removeDir(file);
	}

	public static void removeDir(File dir)
	{
		File[] files = dir.listFiles();

		for(int x = 0; x < files.length; x++)
		{
			if(!files[x].isHidden() && files[x].isDirectory())
			{
				removeDir(files[x]);
			}
			else
			{
				System.out.println(files[x].getName() + " : " + files[x].delete());
			}
		}
		dir.delete();
	}
}