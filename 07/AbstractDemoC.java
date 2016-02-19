abstract class Employee
{
	private String name;
	private int id;
	private int pay;

	Employee(String name,int id, int pay)
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
		System.out.println("Manage\'s bonus is " + this.bonus);
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
		System.out.println("ProEmployee work");
	}

	public void getMyMessage()
	{
		System.out.println("My skill is " + this.skill);
	}
}

class AbstractDemoC
{
	public static void main(String[] args)
	{
		Manager m1 = new Manager("jingli", 10, 20, 30);
		m1.getCommonMessage();	//jingli...10...20
		m1.work();				//Manager work
		m1.getMyMessage();		//Manage's bonus is 30

		ProEmployee p1 = new ProEmployee("dagong", 11, 22, "Java");
		p1.getCommonMessage();	//dagong...11...22
		p1.work();				//ProEmployee work
		p1.getMyMessage();		//My skill is Java
	}
}