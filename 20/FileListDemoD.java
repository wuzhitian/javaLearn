import java.io.*;

class FileListDemoD
{
	public static void main(String[] args)
	{
		File f = new File("D:\\learnSpace\\javaLearn");
		showDir(f, 0);
	}
	public static void showDir(File dir, int level)
	{
		System.out.println(getLevel(level) + dir.getName());
		level++;
		File[] files = dir.listFiles();

		for(int x = 0; x < files.length; x++)
		{
			if(files[x].isDirectory())
			{
				showDir(files[x], level);
			}
			else
			{
				System.out.println(getLevel(level) + files[x].getName());
			}
		}

	}
	public static String getLevel(int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|----");
		for(int x = 0; x < level; x++)
		{
			sb.insert(0, "    ");
		}
		return sb.toString();
	}
}