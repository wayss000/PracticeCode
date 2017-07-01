package p136pra13;
/**
 * 创建一个类,它应带有一个被重载了三次的方法,继承产生了一个新类,并添加了一个该方法的新的重载定义
 * 展示这四个方法在导出类中都可以用
 * */
public class Test extends BaseClass{
	public void fun(String str){
		System.out.println("导出类中重载fun()方法"+str);
	}
	
	public static void main(String [] args){
		Test t = new Test();
		t.fun();
		t.fun(1);
		t.fun(1,2);
		t.fun("HaHa");
	}
}

/*
 *运行结果:
 默认无参数的
一个参数的构造方法1
两个参数的构造方法1  2
导出类中重载fun()方法HaHa

 * 
 */