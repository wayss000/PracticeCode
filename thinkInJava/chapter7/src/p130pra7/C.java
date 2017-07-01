package p130pra7;
/**
 * 修改练习5,是A和B以带参数的构造器取代默认的构造器,为C写一个构造器,并在其中执行所有的初始化.
 * 
 * */
public class C extends A{
	
	B b = new B(0);
	
	C(){
		super(1);
	}
	
	public static void main(String [] args){
		C c = new C();
	}
}

/*
 * 运行结果：
A
B

PS：程序从 main方法开始，先new一个C类，C类会首先执行 自己的基类 构造器方法也就显示A，然后在C中，有一个成员变量B，产生B的时候会执行B的构造方法也就显示B了
 */