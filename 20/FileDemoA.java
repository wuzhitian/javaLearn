import java.io.*;

class FileDemoA
{
	public static void main(String[] args)
	{
		File f1 = new File("a.txt");
		File f2 = new File("c://abc", "abc.txt");
		File f3 = new File("d://abc");

		String d = "e://";
		File f4 = new File(d, "d.txt");
		File f5 = new File("c:"+File.separator+"abc"+File.separator+"abc.txt");

		sop(f1);
		sop(f2);
		sop(f3);
		sop(f4);
		sop(f5);
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}