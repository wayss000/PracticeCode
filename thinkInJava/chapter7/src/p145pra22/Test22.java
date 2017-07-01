package p145pra22;
/**
 * 创建一个final类并尝试继承它
 * */
//public class Test22 extends Base{		//The type Test22 cannot subclass the final class Base被final修饰的类不能被继承

public class Test22{

}

final class Base{
	Base(){
		System.out.println("Base");
	}
}