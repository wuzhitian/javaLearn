import java.util.*;

class EntrySetDemoA
{
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "ZS01");
		map.put("02", "ZS02");
		map.put("03", "ZS03");
		map.put("04", "ZS04");
		map.put("05", "ZS05");

		Set<Map.Entry<String, String>> entryset = map.entrySet();

		System.out.println(entryset);	//[01=ZS01, 02=ZS02, 03=ZS03, 04=ZS04, 05=ZS05]

		Iterator<Map.Entry<String, String>> it = entryset.iterator();

		while(it.hasNext())
		{
			Map.Entry<String, String> me = it.next();
			System.out.println("Key: "+me.getKey()+" Value: "+me.getValue());

			// Key: 01 Value: ZS01
			// Key: 02 Value: ZS02
			// Key: 03 Value: ZS03
			// Key: 04 Value: ZS04
			// Key: 05 Value: ZS05
		}

	}
}