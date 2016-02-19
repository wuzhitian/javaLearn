import java.util.*;

class SystemDemoA
{
	public static void main(String[] args)
	{
		Properties props = System.getProperties();

		for(Object key : props.keySet())
		{
			Object value = (String)props.get(key);

			Log.println(key + " :-----: " + value);
		}




		System.setProperty("myKey", "myValueeeeeeeeee");

		String myValue = System.getProperty("myKey");
		Log.println("myValue : " + myValue);

		Log.println("v :" + System.getProperty("v"));
	}
}