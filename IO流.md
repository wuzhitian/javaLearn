[TOC]

## IO 流

### 概述

字节流 & 字符流
输入流 & 输出流

字符流：有缓冲区
`FileReader`
`FileWriter`

`BufferedReader`
`BufferedWriter`

字节流：没有缓冲区
`InputStream`
`OutputStream`

`BufferedInputStream`
`BufferedOutputStream`

字符流 -> 字节流 `OutputStreamWriter`
字节流 -> 字符流 `InputStreamReader`

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

#### 2.4 MyBufferedInputStream

### 3. 读取键盘录入

#### 3.1 读取键盘录入示例

`public static final InputStream in`

(19/ReadInDemoA)

```java
 import java.io.*;

 class ReadInDemoA
 {
 	public static void main(String[] args) throws IOException
 	{
 		InputStream in = System.in;

 		int ch = 0;

 		while((ch = in.read()) != -1)
 		{
 			System.out.println((char)ch + " : " + ch);
 		}

 		in.close();
 	}
 }
```

(19/ReadInDemoB)

```java
import java.io.*;

class ReadInDemoB
{
	public static void main(String[] args) throws IOException
	{
		InputStream in = System.in;

		StringBuilder sb = new StringBuilder();

		while(true)
		{
			int ch = in.read();
			if(ch == '\r')
			{
				continue;
			}
			else if (ch == '\n')
			{
				String s = sb.toString().toLowerCase();
				if("over".equals(s))
				{
					break;
				}
				else
				{
					System.out.println(sb.toString().toUpperCase());
					sb.delete(0, sb.length());
				}
			}
			else
			{
				sb.append((char)ch);
			}
		}

		in.close();
	}
}
```

#### 3.2 读取转换流 InputStreamReader

InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。

(19/TransStreamDemoA)

```java
import java.io.*;

class TransStreamDemoA
{
	public static void main(String[] args) throws IOException
	{
		//获取键盘录入对象
		InputStream in = System.in;
	
		//将字节流对象转成字符流对象，使用转换流。InputStreamReader
		InputStreamReader isr = new InputStreamReader(in);

		//为了提高效率，将字符串进行缓冲区技术高效操作。使用BufferedReader
		BufferedReader bufr = new BufferedReader(isr);

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line.toLowerCase()))
			{
				break;
			}
			System.out.println(line.toUpperCase());
		}

		bufr.close();
	}
}
```

#### 3.3 写入转换流 OutputStreamWriter

OutputStreamWriter 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。

(19/TransStreamDemoB)

```java
import java.io.*;

class TransStreamDemoB
{
	public static void main(String[] args) throws IOException
	{
		// InputStream in = System.in;
		// InputStreamReader isr = new InputStreamReader(in);
		// BufferedReader bufr = new BufferedReader(isr);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		// OutputStream out = System.out;
		// OutputStreamWriter osw = new OutputStreamWriter(out);
		// BufferedWriter bufw = new BufferedWriter(osw);
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line.toLowerCase()))
			{
				break;
			}

			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();

	}
}
```

#### 3.4 流操作规则

##### 3.4.1 基本规律

1. 需求：显示键盘录入
源：键盘录入。
目的：控制台。

2. 需求：想把键盘录入的数据存储到一个文件中。
源：键盘。
目的：文件

3. 需求：想要将一个文件的数据打印在控制台上。
源：文件
目的：控制台

通过三个明确来完成。

	1. 明确源和目的。
		* 源：输入流。(`InputStream` `Reader`)
		* 目的：输出流。(`OutputStream` `Writer`)
	2. 操作的数据是否是纯文本。
		* 是：字符流。 (`Reader`, `Writer`)
		* 不是：字节流。(`InputStream`, `OutputStream`)
	3. 当体系明确后，再明确要使用那个具体的对象。
	 	* 通过设备来区分：
	 	* 源设备：内存，硬盘，键盘
	 	* 目的设备：内存，硬盘，控制台

---------------------------------------

需求：将一个文本文件中的数据存储到另一个文件中。复制文件。
分析：

	源： 因为是源，所以使用输入流。(`InputStream` 或 `Reader`)
	文本文件：是，所以使用 `Reader`。
	设备： 硬盘。确定使用 `FileReader`。
	是否提高效率：是。使用 `BufferedReader`

	目的：使用输出流。(`OutputStream` 或 `Writer`)
	文本文件：是，所以使用 `Writer`。
	设备： 硬盘。确定使用 `FileWriter`。
	是否提高效率：是。使用 `BufferedWriter`。

```java
FileReader fr = new FileReader("demo.txt");
BufferedReader bufr = new BufferedReader(fr);

FileWriter fw = new FileWriter("demo_copy.txt");
BufferedWriter bufw = new BufferedWriter(fw);

String line = null;

while((line = bufr.readLine()) != null)
{
	bufw.write(line);
}

bufw.close();
bufr.close();

```

---------------------------------------

练习：复制图片文件，提高效率

```java
//伪代码
FileInputStream fis = new FileInputStream("demo.jpg");
BufferedInputStream bufis = new BufferedInputStream(fis);

FileOutputStream fos = new FileOutputStream("demo_copy.jpg");
BufferedOutputStream bufos = new BuferedOutputStream(fos);

byte[] by = new byte[1024];
int len;

while((len = bufis.read(by)) != -1)
{
	bufos.write(by, 0, len);
}

bufis.close();
bufos.close();

```

---------------------------------------

##### 3.4.2 基本规律-2（指定编码表）

---------------------------------------

需求：将键盘录入的数据保存到一个文件中。

这个需求中有源和目的都存在。

**源：** `InputStream` `Reader`
是不是纯文本？是！`Reader` (因为为了操作键盘的文本数据方便，所以一般都将键盘输入的 **字节流** 转换成 **字符流** 然后按照字符串操作是最方便的。)

设备：键盘。对应的对象是 `System.in`。
所以既然明确了 `Reader`，那么就将 `System.in` 转换成 `Reader`。
用了 `Reader` 体系中的转换流，`InputStreamReader`

```java
InputStreamReader isr = new InputStreamReader(System.in);
//提高效率
BufferedReader bufr = new BufferedReader(isr);
```

**目的：** `OutputStream` `Writer`
是不是纯文本？是！`Writer`

设备：硬盘。用 `FileWriter`

```java
FileWriter fw = new FileWriter("recordKeyboard.txt");
//提高效率
BufferedWriter bufw = new BufferedWriter(fw);
```

****************

扩展：指定保存录入数据文件的编码表。

**目的：** `OutputStream` `Writer`
是否是存文本？是！`Writer`。
设备：硬盘。使用 `FileWriter`。

但是 `FileWriter` 是使用jdk默认的编码表。而只有转换流才可以指定编码表。
所以要使用 `OutputStreamWriter`。
而该转换流对象要接收一个字节输入流。而且还可以操作的文件的字节输出流。`FileOutputStream`。

```java
OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("demo.txt", "urf-8"));
//提高效率
BufferedWriter bufw = new BufferedWriter(osw);
```

所以，转换流是字符字节之间的桥梁。通常，涉及到字符编码转换时，需要用到转换流。

(19/TransStreamDemoC)

```java
import java.io.*;

class TransStreamDemoC
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("code_demo.txt"), "UTF-8"));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line.toLowerCase()))
			{
				break;
			}
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();
		bufw.close();
	}
}
```


****************




---------------------------------------


### 4. 改变标准输入输出设备

`System.setIn()` 和 `System.setOut()`

(19/TransStreamDemoD)

```java
import java.io.*;

class TransStreamDemoD
{
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("BufferedWriterDemoA.java"));
		System.setOut(new PrintStream("setIn&setOut.txt"));

		LineNumberReader lnfr = new LineNumberReader(new InputStreamReader(System.in));

		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;

		while((line = lnfr.readLine()) != null)
		{
			if("over".equals(line.toLowerCase()))
			{
				break;
			}
			bufw.write(lnfr.getLineNumber() + " : " + line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		lnfr.close();
		bufw.close();
	}
}
```

### 5. 异常的日志信息生成

(19/ExceptionIofoDemoA)

```java
import java.io.*;
import java.util.*;
import java.text.*;

class ExceptionIofoDemoA
{
	public static void main(String[] args)
	{
		try
		{
			int[] arr = new int[3];
			System.out.println(arr[3]);
		}
		catch(Exception e)
		{
			PrintStream ps = null;
			try
			{
				ps = new PrintStream("ExceptionInfo.txt");
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String s = sdf.format(d);

				ps.println(d.toString());
				System.setOut(ps);
			}
			catch(IOException ex)
			{
				throw new RuntimeException("Create ExceptionInfo.txt failed");
			}
			e.printStackTrace(System.out);
		}
	}
}
```

### 6. 系统信息

`Properties props = System.getProperties()`
`props.list(System.out)`

(19/SystemInfoDemoA)

```java
import java.util.*;
import java.io.*;

class SystemInfoDemoA
{
	public static void main(String[] args) throws IOException
	{
		Properties props = System.getProperties();

		props.list(new PrintStream("SystemInfo.txt"));
	}
}
```

### 7.






















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

