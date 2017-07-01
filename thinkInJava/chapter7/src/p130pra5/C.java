package p130pra5;
/**
 * 创建两个带有默认构造器的类A和B，从A中继承产生一个新类C，并在C中创建一个B类的成员，不要给C编写构造器。
 * 创建一个C类对象并观察其结果。
 * */
public class C extends A{
	
	B b = new B();
	
	C(){
		System.out.println("C");
	}
	
	public static void main(String [] args){
		C c = new C();
	}
}

/*
 * 运行结果：
A
B
C

PS：程序从 main方法开始，先new一个C类，C类会首先执行 自己的基类 构造器方法也就显示A，
然后在C中，有一个成员变量B，产生B的时候会执行B的构造方法也就显示B了
最后,执行C类的默认构造器,打印出C
 */