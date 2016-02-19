import java.util.*;
import java.text.*;

class CalendarDemoA
{
	public static void main(String[] args)
	{
		getTime();

		Log.println("---------------------------------------");

		setTime();

		Log.println("---------------------------------------");

		addTime();

		Log.println("---------------------------------------");

		otherMethod();
	}

	public static void getTime()
	{
		Calendar rightNow = Calendar.getInstance();

		Log.println(rightNow);

		Log.println("YEAR: " + rightNow.get(Calendar.YEAR));
		Log.println("MONTH: " + rightNow.get(Calendar.MONTH));
		Log.println("DAY_OF_MONTH: " + rightNow.get(Calendar.DAY_OF_MONTH));
		Log.println("DAY_OF_WEEK: " + rightNow.get(Calendar.DAY_OF_WEEK));
		Log.println("DAY_OF_WEEK_IN_MONTH: " + rightNow.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		Log.println("WEEK_OF_MONTH : " + rightNow.get(Calendar.WEEK_OF_MONTH ));
		Log.println("DAY_OF_YEAR: " + rightNow.get(Calendar.DAY_OF_YEAR));
		Log.println("HOUR: " + rightNow.get(Calendar.HOUR));
		Log.println("MINUTE: " + rightNow.get(Calendar.MINUTE));
		Log.println("SECOND: " + rightNow.get(Calendar.SECOND));
	}

	public static void setTime()
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(2021, 1, 30);	
		Log.println(rightNow);

		Log.println("YEAR: " + rightNow.get(Calendar.YEAR)); 	//2021
		Log.println("MONTH: " + rightNow.get(Calendar.MONTH));	// 02
		Log.println("DAY_OF_MONTH: " + rightNow.get(Calendar.DAY_OF_MONTH));	//02
	}

	public static void addTime()
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(2035, 0, 22);
		Log.println("YEAR0: " + rightNow.get(Calendar.YEAR));

		rightNow.add(Calendar.YEAR, 18);
		Log.println("YEAR1: " + rightNow.get(Calendar.YEAR));

		rightNow.add(Calendar.YEAR, -28);
		Log.println("YEAR1: " + rightNow.get(Calendar.YEAR));
	}

	public static void otherMethod()
	{
		Calendar rightNow = Calendar.getInstance();

		Log.println(rightNow.getFirstDayOfWeek());
	}
}