import java.util.*;

class Student
{
	private String id;
	private String name;

	Student(String id, String name)
	{
		this.name = name;
		this.id = id;
	}
	
	public String getMessage()
	{
		return this.id + " | " + this.name;
	}
}


class MapDemoA
{
	public static void main(String[] args)
	{
		HashMap<String, List<Student>> czbk1 = new HashMap<String, List<Student>>();

		List<Student> yure = new ArrayList<Student>();
		List<Student> jiuye = new ArrayList<Student>();

		yure.add(new Student("01", "zhangsan"));
		yure.add(new Student("02", "lisi"));
		yure.add(new Student("03", "wangwu"));
		jiuye.add(new Student("01", "zhaoliu"));
		jiuye.add(new Student("02", "sunqi"));
		jiuye.add(new Student("03", "chenba"));

		czbk1.put("yure", yure);
		czbk1.put("jiuye", jiuye);

		Iterator<String> it1 = czbk1.keySet().iterator();
		while(it1.hasNext())
		{
			String roomName = it1.next();
			System.out.println(roomName);

			Iterator<Student> itTemp = czbk1.get(roomName).iterator();
			while(itTemp.hasNext())
			{
				System.out.println(itTemp.next().getMessage());
			}

			System.out.println("---------------------------------");
		}




		HashMap<String, HashMap<String, String>> czbk2 = new HashMap<String, HashMap<String, String>>();

		HashMap<String, String> yure2 = new HashMap<String, String>();
		HashMap<String, String> jiuye2 = new HashMap<String, String>();
		yure2.put("001", "liliu");
		yure2.put("002", "songqi");
		yure2.put("003", "huangba");
		jiuye2.put("001", "zhujiu");
		jiuye2.put("002", "xushi");
		jiuye2.put("003", "chengsan");

		czbk2.put("yure2", yure2);
		czbk2.put("jiuye2", jiuye2);

		Iterator<String> it2 = czbk2.keySet().iterator();
		while(it2.hasNext())
		{
			String roomName = it2.next();
			HashMap<String, String> room = czbk2.get(roomName);
			System.out.println(roomName);
			System.out.println(room.keySet());

			Iterator<String> itTemp = room.keySet().iterator();
			while(itTemp.hasNext())
			{
				String id = itTemp.next();
				System.out.println(id + " : " + room.get(id));
			}

			System.out.println("---------------------------------------");
		}
	}
}