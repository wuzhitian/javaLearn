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