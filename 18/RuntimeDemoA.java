class RuntimeDemoA
{
	public static void main(String[] args) throws Exception
	{
		Runtime r = Runtime.getRuntime();
		Process p1 = r.exec("notepad.exe RuntimeDemoA.java");

		Thread.sleep(4000);
		p1.destroy();
	}
}