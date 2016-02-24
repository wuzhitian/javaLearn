import java.io.*;

class FileCreateDeleteDemoA
{
	public static void main(String[] args) throws IOException
	{
		File f1 = new File("a.txt");
		sop("create: " + f1.createNewFile());

		sop("delete: " + f1.delete());

		f1.deleteOnExit();

		File f2 = new File("aa\\bb\\cc");
		File f3 = new File("aa");
		sop("f2.mkdir:" + f2.mkdir());
		sop("f2.mkdirs:" + f2.mkdirs());
		sop("f3.mkdir:" + f3.mkdir());

		f2.delete();
		f3.deleteOnExit();
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}