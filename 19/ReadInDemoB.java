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