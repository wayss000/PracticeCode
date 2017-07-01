package p142pra19;
/**
 * 创建一个含有指向某对象的空白final引用的类,再多有构造器内部都执行空白的final的初始化动作.
 * 说明java却白final在使用前必须被初始化,且一旦被初始化既无法改变.
 * */
public class Test19 {
	private final int i;
	
	public Test19(){
		i = 1;	//没有这个赋值,空白private final int i;  会出错
//		i = 2;	//The final field i may already have been assigned
	}
}
