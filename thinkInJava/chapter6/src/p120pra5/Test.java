package p120pra5;
/**
 * 创建一个带有public，protected,private和包访问权限域，以及方法成员的类
 * 创建该类的一个对象，看看在你试图调用所有类成员时，会得到什么类型的编译信息
 * */

/**
 * Test为测试类，同包下，TestClass为目标类
 * */
public class Test {
	public static void main(String [] args){
		TestClass ts = new TestClass();
		ts.str1 = "str1";
		ts.str2 = "str2";
//		ts.str3 = "str3";	//The field TestClass.str3 is not visible
		
		ts.fun1();
		ts.fun2();
//		ts.fun3();			//The method fun3() from the type TestClass is not visible
	}
}


/*
 * 总结：同一包下，不同类中，protected可以访问，private不能访问，public始终可以访问
 * 
 */