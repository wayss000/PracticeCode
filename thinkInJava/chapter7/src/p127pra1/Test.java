package p127pra1;
/**
 * 创建一个简单类，在另一个类中，将一个引用定义为第一个类的对象，运用惰性初始化来实例化这个对象。
 * 惰性初始化：正在要使用这些对象之前进行初始化
 * */
public class Test {
	Test1 t1 ;
	
	
	public static void main(String [] args){
		Test t = new Test();
		t.t1 = new Test1();
	}
}


/*
 * 运行结果：
 * This is test1
 * 
 */