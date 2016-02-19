abstract class Employee
{
	private String name;
	private int id;
	private int pay;

	Employee(String name, int id, int pay)
	{
		this.name = name;
		this.id = id;
		this.pay = pay;
	}

	public void getCommonMessage()
	{
		System.out.println(this.name + "..." + this.id + "..." + this.pay);
	}

	public abstract void getMyMessage();

	public abstract void work();
}

class Manager extends Employee
{
	private int bonus;
	Manager(String name, int id, int pay, int bonus)
	{
		super(name, id, pay);
		this.bonus = bonus;
	}

	public void work()
	{
		System.out.println("Manager work");
	}

	public void getMyMessage()
	{
		System.out.println("Manager bonus:" + this.bonus);
	}
}

class ProEmployee extends Employee
{
	private String skill;

	ProEmployee(String name, int id, int pay, String skill)
	{
		super(name, id, pay);
		this.skill = skill;
	}

	public void work()
	{
		System.out.println("ProEmployee work!");
	}

	public void getMyMessage()
	{
		System.out.println("ProEmployee skill is "+ this.skill);
	}
}

class ReviewAbstactClass
{
	public static void main(String[] args)
	{
		Manager m = new Manager("MM", 1, 10000, 2000);
		m.getCommonMessage();
		m.getMyMessage();
		m.work();

		ProEmployee p = new ProEmployee("PP", 2, 7777, "Java");
		p.getCommonMessage();
		p.getMyMessage();
		p.work();

	}
}