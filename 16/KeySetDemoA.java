import java.util.*;

class KeySetDemoA
{
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "ZS01");
		map.put("02", "ZS02");
		map.put("03", "ZS03");
		map.put("04", "ZS04");
		map.put("05", "ZS05");


		Set<String> keyset = map.keySet();
		System.out.println(keyset);		//[01, 02, 03, 04, 05]

		map.put("06", "ZS06");
		map.put("07", "ZS07");
		System.out.println(keyset);		//[01, 02, 03, 04, 05, 06, 07]


		Iterator<String> it = keyset.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			String value = map.get(key);
			System.out.println("key: "+key+", value: "+ value);
			// key: 01, value: ZS01
			// key: 02, value: ZS02
			// key: 03, value: ZS03
			// key: 04, value: ZS04
			// key: 05, value: ZS05
			// key: 06, value: ZS06
			// key: 07, value: ZS07
		}

	}
}