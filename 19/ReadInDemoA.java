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