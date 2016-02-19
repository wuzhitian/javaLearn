import java.util.*;

class HashMapDemoA
{
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "ZhangSan");
		map.put("02", "LiSi");
		map.put("03", "WangWu");
		map.put("04", "ZhaoLiu");

		System.out.println(map);	//{01=ZhangSan, 02=LiSi, 03=WangWu, 04=ZhaoLiu}

		// containsKey(K key)
		System.out.println(map.containsKey("01"));		//true

		System.out.println(map.containsKey("08"));		//false

		// containsKey(V value)
		System.out.println(map.containsValue("LiSi"));	//true
		
		System.out.println(map.containsValue("Heimi"));	//false

		// remove()
		System.out.println(map.remove("03"));	//WangWu

		System.out.println(map.remove("09"));	//null

		System.out.println(map);	//{01=ZhangSan, 02=LiSi, 04=ZhaoLiu}

		// get()
		System.out.println(map.get("05"));		//null

		System.out.println(map.get("04"));		//ZhaoLiu

		// put()
		System.out.println(map.put("01", "Lili"));		//ZhangSan

		System.out.println(map.put("06", "Wuwu")); 		//null

		System.out.println(map.put(null, "Ulili"));		//null
		System.out.println(map.put("05", null));		//null


		System.out.println(map);
		//{null=Ulili, 01=Lili, 02=LiSi, 04=ZhaoLiu, 05=null, 06=Wuwu}

		// values()
		Collection<String> coll = map.values();

		System.out.println(coll);		//[Ulili, Lili, LiSi, ZhaoLiu, null, Wuwu]

		Iterator<String> it = coll.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
			// Ulili
			// Lili
			// LiSi
			// ZhaoLiu
			// null
			// Wuwu
		}
	}
}