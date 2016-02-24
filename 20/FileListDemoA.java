import java.io.*;

class FileListDemoA
{
	public static void main(String[] args) throws IOException
	{
		// listRoot();
		list();
	}

	public static void list() throws IOException
	{
		File file = new File("D:\\");

		String[] names = file.list();

		for(String name : names)
		{
			System.out.println(name);
		}


		// File file2 = new File("AA");
		// String[] names2 = file2.list();
		// for(String name2 : names2)		//java.lang.NullPointerException
		// {
		// 	System.out.println(name2);
		// }

		File file3 = new File("AA");
		file3.mkdirs();
		String[] names3 = file3.list();
		for(String name3 : names3)
		{
			System.out.println("name3: " + name3);
		}

		// File file4 = new File("AA.txt");
		// file4.createNewFile();
		// String[] names4 = file4.list();
		// for(String name4 : names4)	//java.lang.NullPointerException
		// {
		// 	System.out.println("name4: " + name4);
		// }
	}

	public static void listRoot()
	{
		File[] files = File.listRoots();

		for(File file : files)
		{
			System.out.println(file);
		}
	}
}