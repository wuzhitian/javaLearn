import java.io.*;

class FileJudgeDemoA
{
	public static void main(String[] args) throws IOException
	{
		File f1 = new File("aa.txt");
		sop(f1.isFile());
		sop(f1.exists());
		sop(f1.createNewFile());
		sop(f1.isFile());
		sop(f1.isDirectory());
		sop(f1.isAbsolute());

		File f2 = new File("aaa//bbb//ccc");

		sop(f2.exists());
		sop(f2.isFile());
		sop(f2.mkdirs());
		sop(f2.isFile());
		sop(f2.isDirectory());
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}