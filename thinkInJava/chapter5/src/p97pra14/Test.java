package p97pra14;
/**
 * 编写一个拥有两个静态字符域的类,其中一个域在定义出初始化,另一个在静态块中初始化
 * 现在,加入一个静态方法打印两个域的值,证明两个字符域在使用前就已经初始化了
 * */
public class Test {
	static String str1 = "Hello";
	static String str2;
	static String str3;
	static{
		str2 = "World";
	}
	
	public static void main(String [] args){
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}

/*对于str2,若在main方法之后初始化,它变为空了.
 *对比str3,就显而易见了
 * */
 