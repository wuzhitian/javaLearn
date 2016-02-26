import java.io.*;
import java.util.*;

class SplitFileDemoA
{
	public static void main(String[] args) throws IOException
	{
		File f = new File("splitFile\\1.mp3");
		splitFile(f);
		

		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("splitFile\\1.part"));
		v.add(new FileInputStream("splitFile\\2.part"));
		v.add(new FileInputStream("splitFile\\3.part"));
		v.add(new FileInputStream("splitFile\\4.part"));
		Enumeration<FileInputStream> en = v.elements();

		File mergyFile = new File("splitFile\\111.mp3");

		mergy(en, mergyFile);


		
		mergy2();
	}

	public static void mergy2() throws IOException
	{
		ArrayList<FileInputStream> arrs = new ArrayList<FileInputStream>();
		for(int x = 1; x < 5; x++)
		{
			arrs.add(new FileInputStream("splitFile\\" + x + ".part"));
		}

		Iterator<FileInputStream> it = arrs.iterator();

		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>(){
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}
			public FileInputStream nextElement()
			{
				return it.next();
			}
		};

		SequenceInputStream sis = new SequenceInputStream(en);

		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("splitFile\\22222.mp3"));

		byte[] buf = new byte[1024];

		int len = 0;

		while((len = sis.read(buf)) != -1)
		{
			bufos.write(buf);
			bufos.flush();
		}

		sis.close();
		bufos.close();
	}

	public static void splitFile(File file) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);

		byte[] buf = new byte[1024 * 1024];

		int len = 0, count = 1;

		FileOutputStream fos = null;

		while((len = fis.read(buf)) != -1)
		{
			fos = new FileOutputStream("splitFile\\" + (count++) + ".part");
			fos.write(buf, 0, len);
			fos.close();
		}

		fis.close();
	}

	public static void mergy(Enumeration<FileInputStream> en, File file) throws IOException
	{
		SequenceInputStream sis = new SequenceInputStream(en);

		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream(file));

		byte[] buf = new byte[1024*1024];

		int len = 0;

		while((len = sis.read(buf)) != -1)
		{
			bufos.write(buf, 0, len);
			bufos.flush();
		}

		bufos.close();
		sis.close();

	}
}