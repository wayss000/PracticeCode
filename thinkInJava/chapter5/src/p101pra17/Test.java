package p101pra17;
/**
 * 创建类,它具有一个接受String类型参数的构造器,并能在构造阶段打印该参数;
 * 创建该类对象的引用数组,但是不实际去创建对象赋值给该数组.
 * 观察构造器中的参数是否打印出来.
 * */
public class Test {
	public static void main(String [] args){
		AAA arr[];
	}
}


class AAA{
	public AAA(String str){
		System.out.println(str+"aaa");
	}
}

/*
 * 结果为:
 * (什么也不显示)
 * 
 * 实在看不懂题是什么意思(也不知道是翻译的问题还是我的问题),
 * 既然只让创建一个数组对象的引用,不让赋值,那肯定不会调用构造方法,更别说含有参数的构造方法
 * 
 * 结论:没打印
 */