import java.util.*;

class ForDemoA
{
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("aaa1");
		al.add("aaa2");
		al.add("aaa3");
		al.add("aaa4");

		for(String s : al)
		{
			Log.println(s);
		}

		ListIterator<String> lIt = al.listIterator();
		while(lIt.hasNext())
		{
			Log.println("lIt : " + lIt.next());
			lIt.set("bbbB");
		}
		Log.println(al);	//[bbbB, bbbB, bbbB, bbbB]



		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			Log.println("it : " + it.next());
			it.remove();
		}
		Log.println(al);	//[]




		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		hm.put(4, "d");

		Set<Integer> keySet = hm.keySet();

		for(Integer i : keySet)
		{
			Log.println(i + "::::" +hm.get(i));
		}


		for(Integer i : hm.keySet())
		{
			Log.println(i + ":" +hm.get(i));
		}


		Set<Map.Entry<Integer, String>> me = hm.entrySet();
		for(Map.Entry<Integer, String> m : me)
		{
			Log.println(m.getKey() +" --------- "+m.getValue());
		}

		for(Map.Entry<Integer, String> mm : hm.entrySet())
		{
			Log.println(mm.getKey() + ":::::::::" + mm.getValue());
		}
	}
}