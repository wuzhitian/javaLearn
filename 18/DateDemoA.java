import java.util.*;
import java.text.*;

class DateDemoA
{
	public static void main(String[] args)
	{
		Date d = new Date();
		Log.println(d);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String time = sdf.format(d);

		Log.println(time);

	}
}