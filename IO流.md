[TOC]

## IO 流

### 1. String

#### 1.1 概述

字节流 & 字符流
输入流 & 输出流

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
