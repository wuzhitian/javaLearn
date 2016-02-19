class DemoB
{
	public static void main(String[] args)
	{
		int x = 4;
		// int x = 5;	// 已在方法 main(String[])中定义了变量 x
		System.out.println(x);

		// byte y = 100000;	//不兼容的类型: 从int转换到byte可能会有损失
		byte y = (byte)(100000);
		int yy     = 1000000;
		int yyy    = 1000000000;
		//int yyyy   = 10000000000;	//过大的数: 10000000000
		int yyyyy  = (int)10000000000l;	
		System.out.println(y);		//-96
		System.out.println(yy);		//1000000
		System.out.println(yyy);	//1000000000
		// System.out.println(yyyy);
		System.out.println(yyyyy);	//1410065408

		long l = 4;
		System.out.println(l);

		long ll = 4l;
		System.out.println(ll);

		// float f = 2.3;	//不兼容的类型: 从double转换到float可能会有损失(Java默认浮点数类型为double)
		// System.out.println(f);
		
		float ff = 2.3f;
		System.out.println(ff);

		byte b = 2;
		// b = b + 2;	//不兼容的类型: 从int转换到byte可能会有损失(Java默认整数类型为int)
		b = (byte)(b + 2);	//类型强制转换
		System.out.println(b);
		

		byte bb = 2;
		int aa = 4;
		aa = aa + bb;	//Java自动类型提升，小范围向大范围转，合法
		System.out.println(aa);
		

		System.out.println('a'+1);		//98
		System.out.println((char)98);	//'b'
		System.out.println((char)0);

		
		// 负数取模只看被模数（左边）；
		System.out.println(-1%5); //-1
		System.out.println(-1%-5); //-1
		System.out.println(1%-5); //-1
		System.out.println(2%-5); //2


		int aaaa = 3, bbbb;
		bbbb = aaaa++;	//先赋值，后自加；
		System.out.println(aaaa);	//4
		System.out.println(bbbb);	//3

		int aaaaa = 3, bbbbb;
		bbbbb = ++aaaaa;	//先自加，后赋值；
		System.out.println(aaaaa);	//4
		System.out.println(bbbbb);	//4


		System.out.print("Hello\nworld");

		// char ccc = '我';
		// System.out.println(ccc);
		

		short s = 4;
		// s = s + 4;	//丢失精度;
		s+=4;		//会自动转换类型;
		System.out.println(s);
	}
}