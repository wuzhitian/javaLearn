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