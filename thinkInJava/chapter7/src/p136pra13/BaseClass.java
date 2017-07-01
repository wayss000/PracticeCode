package p136pra13;

public class BaseClass {
	public void fun(){
		System.out.println("默认无参数的");
	}
	
	public void fun(int i){
		System.out.println("一个参数的构造方法"+i);
	}
	
	public void fun(int i, int j){
		System.out.println("两个参数的构造方法"+i+"  "+j);
	}
}
