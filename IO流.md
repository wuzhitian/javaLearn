[TOC]

## IO 流

### 概述

字节流 & 字符流
输入流 & 输出流

字符流：有缓冲区
FileReader
FileWriter

BufferedReader
BufferedWriter

字节流：没有缓冲区
InputStream
OutputStream

### 1. 字符流


#### 1.2 FileWriter 简单示例

(18(1)/FileWriterDemoA)

```java
import java.io.*;

class FileWriterDemoA
{
	public static void main(String[] args) throws IOException
	{
		//创建一个 FileWriter 对象。该对象一被初始化就必须要明确被操作的文件。
		//而且该文件会被创建到指定的目录下，如果该目录已有同名文件，将被覆盖。
		//其实该步就是明确数据要存放的目的地。
		FileWriter fw = new FileWriter("demo.txt");

		//调用 write 方法，将字符串写入到流中。
		fw.write("aaaa");

		//刷新流对象中的缓冲中的数据。
		//将数据刷到目的地中。
		//
		fw.flush();

		fw.write("\nbbbb");

		fw.flush();

		fw.write(" ccc");
		

		//关闭流资源，但是关闭前会刷新一次内部的缓冲中的数据。
		//将数据刷到目的地中。
		fw.close();

		//close 和 flush 的区别：flush 刷新后，流可以继续使用，close 刷新后，流将关闭。
	}
}
```

#### 1.2 IO 异常的处理方式

两个异常处理：
创建异常：存储路径不存在；
关闭异常：所要关闭的流不存在。

(18(1)/FileWriterDemoB)

```java
import java.io.*;

class FileWriterDemoB
{
	public static void main(String[] args)
	{
		FileWriter fw = null;
		try
		{
			fw = new FileWriter("demo.txt");
			fw.write("abcdefg");
		}
		catch(IOException e)
		{
			System.out.println("catch: " + e.toString());
		}
		finally
		{
			try
			{
				if(fw != null)
				{
					fw.close();
				}
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}

	}
}
```

#### 1.3 文件续写

演示对已有文件的数据续写。

	FileWriter(String fileName, boolean append) 
	根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。

(18(1)/FileWriterDemoC)

```java
import java.io.*;

class FileWriterDemoC
{
	public static void main(String[] args)
	{
		FileWriter fw = null;

		try
		{
			fw = new FileWriter("demo.txt", true);
			fw.write("\r\nAAAAAAA");
		}
		catch(IOException e)
		{
			System.out.println("catch: " + e.toString());
		}
		finally
		{
			try
			{
				if(fw != null)
				{
					fw.close();
				}
			}
			catch(IOException e)
			{
				System.out.println("catch: " + e.toString());
			}
		}
	}
}
```

#### 1.4 文件读取(FileReader)

##### 1.4.1 单个字符读取 `read()`

调用读取流对象的 `read` 方法。
`read()` 一次读一个字符。而且会自动往下读。

(18(1)/FileReaderDemoA)

```java
import java.io.*;

class FileReaderDemoA
{
	public static void main(String[] args)
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader("demo.txt");


			// int ch = 0;
			// while((ch = fr.read()) != -1)
			// {
			// 	System.out.println((char)ch);
			// }
			

			while(true) 
			{
				int ch = fr.read();
				if(ch == -1)
				{
					break;
				}
				System.out.println((char)ch);
			}
			
		}
		catch(IOException e)
		{
			System.out.println("catch: " + e.toString());
		}
		finally
		{
			try
			{
				if(fr != null)
				{
					fr.close();
				}
			}
			catch(IOException e)
			{
				System.out.println("catch: "+ e.toString());
			}
		}
	}
}
```

##### 1.4.2 字符数组读取 `read(char[])`

(18(1)/FileReaderDemoB)

```java
import java.io.*;

class FileReaderDemoB
{
	public static void main(String[] args)
	{
		FileReader fr = null;

		try
		{
			fr = new FileReader("demo.txt");

			char[] buf = new char[3];

			int num = 0;

			while ((num = fr.read(buf)) != -1)
			{
				System.out.println("num: " + num + "  string: " + new String(buf, 0, num));
			}
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fr != null)
				{
					fr.close();
				}
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}
}
```

##### 1.4.3 文件读取练习

控制台打印java文件

(18/FileReaderDemoC)

```java
import java.io.*;

class FileReaderDemoC
{
	public static void main(String[] args)
	{
		FileReader fr = null;

		try
		{
			fr = new FileReader("FileReaderDemoAA.java");

			char[] buf = new char[1024];
			int num = 0;

			while((num = fr.read(buf)) != -1)
			{
				System.out.print(new String(buf));
			}
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fr != null)
				{
					fr.close();
				}
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}
}
```

#### 1.5 文件的复制

(18(1)/FileCopyDemoA)

```java
import java.io.*;

class FileCopyDemoA
{
	public static void main(String[] args)
	{
		FileReader fr = null;
		FileWriter fw = null;

		try
		{
			fr = new FileReader("FileWriterDemoB.java");
			fw = new FileWriter("FileWriterDemoB.txt");

			char[] buf = new char[1024];
			int len = 0;
			while((len = fr.read(buf)) != -1)
			{
				fw.write(buf, 0, len);
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			if(fr != null)
			{
				try
				{
					fr.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
			if(fw != null)
			{
				try
				{
					fw.close();
				}
				catch(IOException e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}
```

#### 1.6 Buffered

##### 1.6.1 BufferedWriter

缓冲区的出现是为了提高流的操作效率而出现的。
所以在创建缓冲区之前，必须要现有流对象。
该缓冲区中提供了一个跨平台的换行，`newLine()`。

(19/BufferedWriterDemoA)

```java
import java.io.*;

class BufferedWriterDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter("buf.txt", true);

		BufferedWriter bufw = new BufferedWriter(fw);

		for(int x = 0; x < 5; x++)
		{
			bufw.write("abcde" + x);
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
	}
}
```

##### 1.6.2 BufferedReader

字符读取流缓冲区：
该缓冲区提供了一个一次读一行的方法 `readLine()`，方便于对文本数据的读取。
当 `readLine()` 返回空值 `null` 表示已读到文件末尾。
`readLine()` 返回只返回每行回车符之前的内容，不包含回车符。

```java
import java.io.*;

class FileReaderDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("buf.txt");

		//为了提高效率。加入缓冲技术。
		//将字符读取流对象作为参数传递给缓冲对象的构造函数。
		BufferedReader bufr = new BufferedReader(fr);

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			System.out.println(line);
		}

		fr.close();
	}
}
```

##### 1.6.3 Buffered 复制文件示例

(19/CopyFileByBufDemoA)

```java
import java.io.*;

class CopyFileByBufDemoA
{
	public static void main(String[] arg)
	{
		BufferedReader bufr = null;
		BufferedWriter bufw = null;

		try
		{
			bufr = new BufferedReader(new FileReader("buf.txt"));
			bufw = new BufferedWriter(new FileWriter("buf_copy.txt"));

			String line = null;

			while((line = bufr.readLine()) != null)
			{
				bufw.write(line);
				bufw.newLine();
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally
		{
			try
			{
				if(bufr != null)
				{
					bufr.close();
				}
			}
			catch(IOException e)
			{
				throw new RuntimeException("关闭读取文件失败");
			}
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch(IOException e)
			{
				throw new RuntimeException("关闭写入文件失败");
			}
		}
	}
}
```

##### 1.6.4 readLine() 方法原理

`readLine()` 方法的原理
无论是读一行，获取读取多个字符。其实最终都是在硬盘上一个一个读取。
所以最终使用的还是 `read()` 方法，一次读一个的方法。

##### 1.6.5 自定义MyBufferedReader()

(19/MyBufferedReaderDemoA)

```java
import java.io.*;

class MyBufferedReader
{
	private FileReader r = null;
	MyBufferedReader(FileReader r)
	{
		this.r = r;
	}

	public String myReadLine() throws IOException
	{
		//定义一个临时容器。原BufferReader封装的是字符数组。
		//为了方便演示，定义一个StringBuilder容器。
		//因为最终还是要将数据变成字符串。
		StringBuilder sb = new StringBuilder();
		int ch = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\r')
			{
				continue;
			}
			if(ch == '\n')
			{
				return sb.toString();
			}
			sb.append((char)ch);
		}

		if(sb.length() != 0)
		{
			return sb.toString();
		}

		return null;
	}

	public void myClose() throws IOException
	{
		r.close();
	}
}

class MyBufferedReaderDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("buf.txt");

		MyBufferedReader mybufr = new MyBufferedReader(fr);

		String line = null;

		while((line = mybufr.myReadLine()) != null)
		{
			System.out.println(line);
		}

		mybufr.myClose();
	}
}
```

##### 1.6.6 LineNumberReader()

继承自 `BufferedReader`

`setLineNumber(int lineNumber)` 设置初始行号; 
`getLineNumber()` 获取行号;

(19/LineNumberReaderDemoA)

```java
import java.io.*;

class LineNumberReaderDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("BufferedWriterDemoA.java");

		LineNumberReader lnr = new LineNumberReader(fr);

		String line = null;

		lnr.setLineNumber(100);
		while((line = lnr.readLine()) != null)
		{
			System.out.println(lnr.getLineNumber() + " : " + line);
		}

		lnr.close();
	}
}
```

##### 1.6.7 MyLineNumberReader

(19/MyLineNumberReaderDemoA)

```java
import java.io.*;

class MyLineNumberReader
{
	private Reader r;

	private int lineNumber;

	MyLineNumberReader(Reader r)
	{
		this.r = r;
	}

	public String myReaderLine() throws IOException
	{
		lineNumber++;

		StringBuilder sb = new StringBuilder();

		int ch = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\r')
			{
				continue;
			}
			else if(ch == '\n')
			{
				return sb.toString();
			}
			else {
				sb.append((char)ch);
			}
		}
		if(sb.length() != 0)
		{
			return sb.toString();
		}
		return null;
	}

	public void setLineNumber(int number)
	{
		this.lineNumber = number;
	}

	public int getLineNumber()
	{
		return this.lineNumber;
	}

	public void myClose() throws IOException
	{
		r.close();
	}
}

class MyLineNumberReaderDemoA
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("BufferedWriterDemoA.java");

		MyLineNumberReader mlnr = new MyLineNumberReader(fr);

		String line = null;

		mlnr.setLineNumber(100);

		while((line = mlnr.myReaderLine()) != null)
		{
			System.out.println(mlnr.getLineNumber() + ":" + line);
		}

		mlnr.myClose();
	}
}
```

### 2. 字节流

#### 2.1 FileInputStream、FileOutputStream

`available()` 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数。

(19/FileStreamDemoA)

```java
import java.io.*;

class FileStreamDemoA
{
	public static void main(String[] args) throws IOException
	{
		writeFile();
		// readFileA();
		// readFileB();
		readFileC();
	}

	public static void readFileA() throws IOException
	{
		FileInputStream fis = new FileInputStream("stream.txt");

		int b;

		while((b = fis.read()) != -1)
		{
			System.out.println((char)b);
		}
		fis.close();
	}

	public static void readFileB() throws IOException
	{
		FileInputStream fis = new FileInputStream("stream.txt");

		byte[] buf = new byte[1024];

		int len;

		while((len = fis.read(buf)) != -1)
		{
			System.out.println(new String(buf, 0, len));
		}

		fis.close();
	}

	public static void readFileC() throws IOException
	{
		FileInputStream fis = new FileInputStream("stream.txt");

		byte[] buf = new byte[fis.available()];

		fis.read(buf);

		System.out.println(new String(buf));

		fis.close();
	}

	public static void writeFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("stream.txt");

		fos.write("aabbccdd".getBytes());

		fos.close();
	}
}
```

#### 2.2 复制图片

(19/CopyPicDemoA)

```java
 import java.io.*;

 class CopyPicDemoA
 {
 	public static void main(String[] args)
 	{
 		FileInputStream fis = null;
 		FileOutputStream fos = null;

 		try
 		{
	 		fis = new FileInputStream("1.png");
	 		fos = new FileOutputStream("2.png");

	 		byte[] buf = new byte[1024];
	 		int len;

	 		while((len = fis.read(buf)) != -1)
	 		{
	 			fos.write(buf);
	 		}
 		}
 		catch(IOException e)
 		{
 			throw new RuntimeException("CopyFail");
 		}
 		finally
 		{
 			try
 			{
 				if(fis != null)
 				{
 					fis.close();
 				}
 			}
 			catch(IOException e)
 			{
 				System.out.println("Input close failed!");
 			}

 			try
 			{
 				if(fos != null)
 				{
 					fos.close();
 				}
 			}
 			catch(IOException e)
 			{
 				System.out.println("Output close failed!");
 			}
 		}
 	}
 }
```

#### 2.3 复制MP3 Buffered

字节流缓冲区

(19/CopyMp3DemoA)

```java
import java.io.*;

class CopyMp3DemoA
{
	public static void main(String[] args) throws IOException
	{
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("1.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("2.mp3"));

		int n;

		while((n = bufis.read()) != -1)
		{
			bufos.write(n);
		}

		bufis.close();
		bufos.close();
	}
}
```


















## 设计模式

### 装饰设计模式

#### 装饰设计模式示例

由 `BufferedReader` 引出

当想要 **对已有的对象进行功能增强** 时，
可以定义类，将已有对象传入，基于已有的功能，并提供加强功能。
那么自定义的该类成为装饰类。

装饰类通常会通过构造方法接收被装饰的对象。
并基于被装饰的对象的功能，提供更强的功能。

(19/SuperPersonDemoA)

```java
class Person
{
	public void chifan()
	{
		System.out.println("吃饭");
	}
}

class SuperPerson
{
	private Person p = null;

	SuperPerson(Person p)
	{
		this.p = p;
	}

	public void superChifan()
	{
		System.out.println("开胃菜");
		p.chifan();
		System.out.println("饭后点心");
	}
}

class SuperPersonDemoA
{
	public static void main(String[] args)
	{
		Person p = new Person();
		// p.chifan();
		SuperPerson sp = new SuperPerson(p);

		sp.superChifan();
	}
}
```

#### 装饰设计模式和继承的区别：

MyReader //专门用于读取数据的类
	|--MyTextReader
		|--MyBufferTextReader
	|--MyMediaReader
		|--MyBufferMediaReader
	|--MyDataReader
		|--MyBufferDataReader

```java
//伪代码
class MyBufferReader()
{
	MyBufferReader(MyTextReader text)
	{}
	MyBufferReader(MyMediaReader media)
	{

	}
}
```

上面这个类，拓展性很差。
找到其参数的共同类型。通过多态的形式。可以提高扩展性。

MyReader //专门用于读取数据的类。
	|--MyTextReader 
	|--MyMediaReader
	|--MyDataReader

```java
class MyBufferReader extends MyReader
{
	private MyReader r;
	MyBufferReader(MyReader r)
	{
		this.r = r;
	}
}
```

装饰模式比继承模式要灵活。避免了继承体系臃肿。
而且降低了类与类之间的关系。

装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。
所以装饰类和被装饰通常都是属于一个体系中的。

