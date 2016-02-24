import java.io.*;

class FileGetInfoDemoA
{
	public static void main(String[] args) throws IOException
	{
		File f1 = new File("D:\\test.txt");
		sop("f1 getPath:"+ f1.getPath());    //f1 getPath:D:\test.txt
		sop("f1 getName:"+ f1.getName());    //f1 getName:test.txt
		sop("f1 getParent:"+ f1.getParent());    //f1 getParent:D:\
		sop("f1 getAbsolutePath:"+ f1.getAbsolutePath());    //f1 getAbsolutePath:D:\test.txt
		sop("f1 getAbsoluteFile:"+ f1.getAbsoluteFile());    //f1 getAbsoluteFile:D:\test.txt
		sop("f1 lastModified:"+ f1.lastModified());    //f1 lastModified:0
		sop("f1 length:"+ f1.length());    //f1 length:0


		File f2 = new File("test2.txt");

		f2.createNewFile();

		sop("f2 getPath:"+ f2.getPath());	//f2 getPath:test2.txt
		sop("f2 getName:"+ f2.getName());	//f2 getName:test2.txt
		sop("f2 getParent:"+ f2.getParent());	//f2 getParent:null
		sop("f2 getAbsolutePath:"+ f2.getAbsolutePath());	//f2 getAbsolutePath:D:\learnSpace\javaLearn\20\test2.txt
		sop("f2 getAbsoluteFile:"+ f2.getAbsoluteFile());	//f2 getAbsoluteFile:D:\learnSpace\javaLearn\20\test2.txt
		sop("f2 lastModified:"+ f2.lastModified());	//f2 lastModified:0
		sop("f2 length:"+ f2.length());	//f2 length:0

		File f3 = new File("bb\\test3.txt");

		sop("f3 getPath:"+ f3.getPath());		//f3 getPath:bb\test3.txt
		sop("f3 getName:"+ f3.getName());		//f3 getName:test3.txt
		sop("f3 getParent:"+ f3.getParent());		//f3 getParent:bb
		sop("f3 getAbsolutePath:"+ f3.getAbsolutePath());		//f3 getAbsolutePath:D:\learnSpace\javaLearn\20\bb\test3.txt
		sop("f3 getAbsoluteFile:"+ f3.getAbsoluteFile());		//f3 getAbsoluteFile:D:\learnSpace\javaLearn\20\bb\test3.txt
		sop("f3 lastModified:"+ f3.lastModified());		//f3 lastModified:0
		sop("f3 length:"+ f3.length());		//f3 length:0


	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}