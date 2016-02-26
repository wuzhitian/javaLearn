[TOC]

# IO 流

## IO 流基础

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

-------------------------------------------


## File对象

### 概述

(20/FileDemoA)

```java
import java.io.*;

class FileDemoA
{
	public static void main(String[] args)
	{
		//将a.txt封装成file对象。
		//可以将已有的和未出现的文件或者文件夹封装成对象。
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
```

### 1 File 对象功能

1. 创建
	`boolean createNewFile()`;
	`boolean mkdir()`;
	`boolean mkdirs()`;

2. 删除
	`boolean delete()`; 
	`void deleteOnExit()`;

3. 判断
	`boolean canExecute()`;
	`boolean exists()`;
	`boolean isFile()`;
	`boolean isDirectory()`;
	`boolean isHidden()`;
	`boolean isAbsolute()`;

4. 获取文件信息
	`String getName()`;
	`String getPath()`;
	`String getParent()`;
	`String getAbsolutePath()`;
	`File getAbsoluteFile()`;
	`long lastModified()`;
	`long length()`;

5. 修改
	`boolean renameTo(File f)`

#### 1.1 创建和删除

** 创建 **
`boolean createNewFile()`：在指定位置创建文件，如果该文件已经存在，则不创建，返回false。和输出流不一样，输出流对象一创建文件。而且文件已经存在，会覆盖。

`boolean mkdir()`：创建此抽象路径名指定的目录。

`boolean mkdirs()`：创建多级文件夹目录。

** 删除 **
`boolean delete()`： 删除失败会返回 `false`。
`void deleteOnExit()`：在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。

(20/FileCreateDeleteDemoA)

```java
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

		//这里需要注意的是，File对象的delete是删除被实例化的具体文件或文件夹。
		//如 File f5 = new File("aaa\\bbb\\ccc\\ddd\\eee");
		//f5.mkdirs();
		//f5.delete();	//这时删除的仅仅是末尾的eee文件夹
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
```

#### 1.2 判断

* `boolean canExecute()`;
* `boolean exists()`;
* `boolean isFile()`;
* `boolean isDirectory()`;
* `boolean isHidden()`;
* `boolean isAbsolute()`;

**注意：**在判断文件对象是否是文件或者目录时，必须要先判断奶文件对象封装的内容是否存在。通过 `exists` 判断。

(20/FileJudgeDemoA)

```java
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
```

#### 1.3 获取文件信息

* `String getName()`;
* `String getPath()`;
	实例化`File`对象时，传参的是绝对路径就返回绝对路径，相对路径就返回相对路径。
* `String getParent()`;
	该方法返回的是绝对路径的父目录。如果获取的是相对路径，返回 `null`。
	如果相对路径中有上一层目录（如 `"aa\\bb.txt"`），那么该目录就是返回结果，即（`"aa"`）；
* `String getAbsolutePath()`;
* `File getAbsoluteFile()`;
* `long lastModified()`;
* `long length()`;
	此抽象路径名表示的文件的长度(即文件大小)，以字节为单位；如果文件不存在，则返回 0L。

(20/FileGetInfoDemoA)

```java
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
```

#### 1.4 修改
	
* `boolean renameTo(File f)`

(20/FileRenameToDemoA)

```java
import java.io.*;

class FileRenameToDemoA
{
	public static void main(String[] args) throws IOException
	{
		File f1 = new File("f1.txt");
		f1.createNewFile();
		File f2 = new File("f2.txt");

		f1.renameTo(f2);
	}
}
```

### 2. 文件列表

#### 2.1 `list()` `listRoots()`

* `String[] list()`;
	调用 `list` 方法的 `file` 对象必须是封装了一个已存在的目录。
	如果此抽象路径名不表示一个目录，或者发生 I/O 错误，则返回 null。

* `File[] listRoot()`;
	列出可用的文件系统根。 (盘符分区)

(20/FileListDemoA)

```java
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
```

#### 2.2 `list(FilenameFilter file)`

(20/FileListDemoB)

```java
import java.io.*;

class FileListDemoB
{
	public static void main(String[] args) throws IOException
	{
		File temp = new File("temp.txt");
		File absPath = temp.getAbsoluteFile();
		temp.deleteOnExit();


		File parentFile = absPath.getParentFile();
		String[] javaNames = parentFile.list(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				return name.endsWith("class");
			}
		});

		for(String name : javaNames)
		{
			System.out.println(name);
		}

	}
}
```

#### 2.3 列出某文件夹下所有内容（递归）

(20/FileListDemoC)

```java
import java.io.*;

class FileListDemoC
{
	public static void main(String[] args)
	{
		File file = new File("D:\\learnSpace\\javaLearn");

		showDir(file);
	}

	public static void showDir(File dir)
	{
		System.out.println("Dir::  " + dir);
		File[] f = dir.listFiles();
		for(int x = 0; x < f.length; x++)
		{
			if(f[x].isDirectory())
			{
				showDir(f[x]);
			}
			else
			{
				System.out.println(f[x]);
			}
		}
	}
}
```

##### 2.3.1 关于递归

递归要注意：
1，限定条件。
2，要注意递归的次数，尽量避免内存溢出。

(20/RecursionDemoA)

```java
class RecursionDemoA
{
	public static void main(String[] args)
	{
		toBin(9);
		System.out.println(getSum(50));
	}
	public static void toBin(int num)
	{
		if(num > 0)
		{
			System.out.println(num%2);
			toBin(num/2);
		}
	}

	public static int getSum(int num)
	{
		if(num == 1)
		{
			return num;
		}
		else
		{
			return num + getSum(num - 1);
		}
	}
}
```

##### 2.3.2 列出文件夹下所有内容（带层次结构）

(20/FileListDemoD)

```java
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
```

#### 2.4 删除带内容的目录

删除原理：
在 windows 中，删除内容是从里往外删的。
既然是从里往外删除。就需要用到递归。

(20/RemoveDirDemoA)

```java
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
```

#### 2.5 创建文件列表

```java
import java.io.*;
import java.util.*;

class JavaFileListDemoA
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("D:\\learnSpace\\Java");
		List<File> list = new ArrayList<File>();

		getFileList(file, list);

		System.out.println(list.size());

		File javaFileList = new File("javaFileList.txt");
		writeToFile(list, javaFileList);

	}

	public static void getFileList(File dir, List<File> list)
	{
		File[] files = dir.listFiles();
		System.out.println(dir);
		for(File file : files)
		{
			if(file.isDirectory())
			{
				getFileList(file, list);
			}
			else
			{
				if(file.getName().endsWith(".java"))
				{
					list.add(file);
				}
			}
		}
	}

	public static void writeToFile(List<File> list, File file) throws IOException
	{
		BufferedWriter bufw = null;

		try
		{
			bufw = new BufferedWriter(new FileWriter(file));
			for(File f : list)
			{
				bufw.write(f.getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(IOException e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch(IOException e)
			{
				throw e;
			}
		}
	}
}
```

## Properties

常用方法：

* `void setProperty(String key, String value)`;
* `Set<String> stringPropertyNames()`;
* 
* `void load(InputStream in)`;
* `void load(Reader reader)`;
* 
* `void store(OutputStream out, String comments)`;
* `void store(Writer writer, String comments)`;


### 1.1 Properties 简述

`Properties` 是 `hashtable` 的子类。
也就是说它具备 `map` 集合的特点。而且它里面存储的键值对都是字符串。
是集合中和IO技术相结合的集合容器。
该对象特点：可以用于键值对形式的配置文件。
加载数据是，需要数据有固定格式：`键=值`;

### 1.2 Properties 存取

(20/PropertiesDemoA)

```java
import java.io.*;
import java.util.*;

class PropertiesDemoA
{
	public static void main(String[] args)
	{
		Properties props = new Properties();
		props.setProperty("zhangsan", "20");
		props.setProperty("lisi", "30");

		Set<String> names = props.stringPropertyNames();
		for(String name : names)
		{
			System.out.println(name + " :: " + props.getProperty(name));
		}
	}
}
```

### 1.3 Properties 存取配置文件

`void setProperty(String key, String value)`;
`Set<String> stringPropertyNames()`;

`void load(InputStream in)`;
`void load(Reader reader)`;

`void store(OutputStream out, String comments)`;
`void store(Writer writer, String comments)`;

(20/PropertiesDemoB)

```java
import java.io.*;
import java.util.*;

class PropertiesDemoB
{
	public static void main(String[] args) throws IOException
	{
		// method_1();
		loadDemo();
	}

	public static void method_1() throws IOException
	{
		Properties props = new Properties();

		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			String[] arr = line.split("=");
			props.setProperty(arr[0], arr[1]);
			// System.out.println(line);
		}

		Set<String> names = props.stringPropertyNames();

		for(String name : names)
		{
			System.out.println(name + " = " + props.getProperty(name));
		}
	}

	public static void loadDemo() throws IOException
	{
		Properties props = new Properties();
		FileReader fr = new FileReader("info.txt");
		FileInputStream fis = new FileInputStream("info.txt");
		// props.load(new FileReader("info.txt"));
		props.load(fis);

		System.out.println(props);

		props.setProperty("zhangsan", "zhangsan");

		FileWriter fw = new FileWriter("info.txt");
		// FileOutputStream fos = new FileOutputStream("info.txt");

		props.store(fw, "hh");


		fw.close();
		fr.close();
	}
}
```

### 1.4 Properties 练习

需求：记录程序运行次数，提示注册。

(20/PropertiesExerciseDemoA)

```java
import java.io.*;
import java.util.*;

class PropertiesExerciseDemoA
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("count.ini");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileReader fr = new FileReader(file);

		Properties props = new Properties();

		props.load(fr);

		
		int count = 0;
		String value = props.getProperty("time");

		if(value != null)
		{
			count = Integer.parseInt(value);
			if(count >= 5)
			{
				System.out.println("Time out!!!");
				return;
			}
		}
		count++;
		props.setProperty("time", count+"");

		FileWriter fw = new FileWriter(file);

		props.store(fw, "");

		fr.close();
		fw.close();

		System.out.println("Welcome!");
	}
}
```

## 打印流 PrintWriter & PrintStream

字节打印流：`PrintStream`
构造函数可以接收的参数类型
1. `file` 对象。`File`
2. 字符串路径。`String`
3. 字节输出流。`OutputStream`


字符打印流：`PrintWriter`
构造函数可以接收的参数类型
1. `file` 对象。`File`
2. 字符串路径。`String`
3. 字节输出流。`OutputStream`
4. 字符输出流。`Writer`

(20/PrintWriterDemoA)

```java
import java.io.*;

class PrintWriterDemoA
{
	public static void main(String[] args) throws IOException
	{
		// method_1();
		// method_2();
		method_3();
	}

	public static void method_1() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(System.out);

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			pw.println(line.toUpperCase());
			pw.flush();
		}

		bufr.close();
		pw.close();
	}

	public static void method_2() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintStream pw = new PrintStream(new File("Print.txt"));

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			pw.println(line.toUpperCase());
			pw.flush();
		}

		bufr.close();
		pw.close();
	}

	public static void method_3() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

		PrintStream pw = new PrintStream(new FileOutputStream("Print.txt"), true);

		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			pw.println(line.toUpperCase());
		}

		bufr.close();
		pw.close();
	}
}
```

## 合并流 `SequenceInputStream`

(20/SequenceInputStreamDemoA)

```java
import java.io.*;
import java.util.*;

class SequenceInputStreamDemoA
{
	public static void main(String[] args) throws IOException
	{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("11.txt"));
		v.add(new FileInputStream("22.txt"));
		v.add(new FileInputStream("33.txt"));

		Enumeration<FileInputStream> en = v.elements();
		
		SequenceInputStream sis = new SequenceInputStream(en);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(sis));

		String line = null;

		BufferedWriter bufw = new BufferedWriter(new FileWriter("44.txt"));

		while((line = bufr.readLine()) != null)
		{
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();
		bufw.close();
	}
}
```

## 分割流

`byte[] buf = new byte[1024 * 1024];` 字节流，限制分卷大小。 


(20/SplitFileDemoA)

```java
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
```

## 对象的序列化 ObjectOutputStream & ObjectInputStream

**强烈建议** 

	所有可序列化类都显式声明 serialVersionUID 值，
	原因是计算默认的 serialVersionUID 对类的详细信息具有较高的敏感性，
	根据编译器实现的不同可能千差万别，
	这样在反序列化过程中可能会导致意外的 InvalidClassException。
	因此，为保证 serialVersionUID 值跨不同 java 编译器实现的一致性，
	序列化类必须声明一个明确的 serialVersionUID 值。
	还强烈建议使用 private 修饰符显示声明 serialVersionUID（如果可能），
	原因是这种声明仅应用于直接声明类 -- serialVersionUID 字段作为继承成员没有用处

`static` 修饰的成员是不能被序列化的。
`transient` 修饰的成员是不能被序列化的。

(21/Person)

```java
import java.io.*;

class Person implements Serializable
{
	private static final long serialVersionUID = 42L;

	private String name;
	private int age;
	// private int agee;
	transient String country = "default";
	static String sex = "man";

	Person(String name, int age, String country, String sex)
	{
		this.name = name;
		this.age = age;
		this.country = country;
		this.sex = sex;
	}

	public String toString()
	{
		return this.name + " : " + this.age + " : " + this.country + " : " + this.sex;
	}
}
```

(21/ObjectStreamDemoA)

```java
import java.io.*;

class ObjectStreamDemoA
{
	public static void main(String[] args) throws Exception
	{
		// writeObj();
		readObj();
	}

	public static void writeObj() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.object"));
		oos.writeObject(new Person("lili", 10, "cn", "AA"));
		oos.writeObject(new Person("yiyi", 20, "en", "BB"));
		oos.writeObject(new Person("cici", 30, "kr", "CC"));

		oos.close();
	}
	public static void readObj() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.object"));

		Person p1 = (Person)ois.readObject();
		Person p2 = (Person)ois.readObject();
		Person p3 = (Person)ois.readObject();

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		ois.close();
	}
}
```

## 管道流 PipedInputStream & PipedOutputStream

```java
import java.io.*;

class Read implements Runnable
{
	private PipedInputStream in;

	Read(PipedInputStream in)
	{
		this.in = in;
	}

	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];

			System.out.println("Before read, no data, blocking");

			int len = in.read(buf);

			System.out.println("After read, have data, block end");

			String s = new String(buf, 0, len);

			System.out.println(s);

			in.close();
		}
		catch(IOException e)
		{
			throw new RuntimeException("Piped read failed!");
		}
	}
}

class Write implements Runnable
{
	private PipedOutputStream out;

	Write(PipedOutputStream out)
	{
		this.out = out;
	}

	public void run()
	{
		try
		{
			System.out.println("Begin to write, wait 3 seconds");

			Thread.sleep(3000);

			out.write("Piped lai la".getBytes());

			out.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Piped write failed!");
		}
	}
}

class PipedStreamDemoA
{
	public static void main(String[] args) throws Exception
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);

		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
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

