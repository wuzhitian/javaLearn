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