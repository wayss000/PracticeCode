package p144pra21;
/**
 * 创建一个带final方法的类.由此继承产生一个类并尝试覆盖该方法.
 * */
public class Test21 extends Base{
//	public void fun(){}		//Cannot override the final method from Base被final修饰的方法不可以被覆盖
	public void fun(int i){	//可以被重载
		
	}
}


class Base{
	public final void fun(){
		System.out.println("Base fun()");
	}
}