### 02 JAVA基础语法

##### 2.1 关键字

##### 2.2 标识符

##### 2.3 注释

##### 2.4 进制转换

* 二进制转十六进制（四位二进制位表示一位十六进制）；
* 二进制转八进制（三位二进制表示一位八进制）；
* 负数的二进制表现形式
	6 ---> 110
	-6: 6的二进制取反+1（取反：1变成0，0变成1）

##### 2.4 常量与变量

整数：

* byte: 8位二进制；
* short: 16位二进制；
* int: 32位二进制；
* long: 64位二进制

Java默认浮点数类型为double
Java默认整数类型为int
Java自动类型提升，小范围向大范围转

-1%5 = -1;
-2%5 = -2;
2%-5 = 2;
负数取模只看被模数（左边）


char c = '我';	//没问题，一个汉字两个字节，char类型也是两个字节;

	n = n + m; m = n - m; n = n - m;

	a = a ^ b; b = a ^ b; a = a ^ b;

````java
	class Demo
	{
		public static void main(String[] args)
		{
			int x = 56;

			int a = x & 15;

			int b = x >>= 4 & 15;

			int c = x >>= 4 & 15;

			System.out.println(a+", "+b+", "+c);
		}
	}
````