import java.io.*;

class Person implements Serializable
{
	private static final long serialVersionUID = 42L;

	private String name;
	private int age;
	// private int agee;
	transient String country = "default";
	static String sex = "man";

	Person(String name, int age, String country, String sex)
	{
		this.name = name;
		this.age = age;
		this.country = country;
		this.sex = sex;
	}

	public String toString()
	{
		return this.name + " : " + this.age + " : " + this.country + " : " + this.sex;
	}
}