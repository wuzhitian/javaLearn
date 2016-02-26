import java.io.*;

class ObjectStreamDemoA
{
	public static void main(String[] args) throws Exception
	{
		// writeObj();
		readObj();
	}

	public static void writeObj() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.object"));
		oos.writeObject(new Person("lili", 10, "cn", "AA"));
		oos.writeObject(new Person("yiyi", 20, "en", "BB"));
		oos.writeObject(new Person("cici", 30, "kr", "CC"));

		oos.close();
	}
	public static void readObj() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.object"));

		Person p1 = (Person)ois.readObject();
		Person p2 = (Person)ois.readObject();
		Person p3 = (Person)ois.readObject();

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		ois.close();
	}
}