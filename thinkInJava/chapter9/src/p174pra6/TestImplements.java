package p174pra6;
/**
 * 练习6:证明借口内的所有方法都自动是public
 * 
 * 说明:在TestInterface中,三个方法的声明都没有用public修饰,但是却能在另外的一个包中访问,
 * 因此可以推断,接口中的所有方法都是默认的public修饰
 * 
 * */
import p174pra5.TestInterface;

public class TestImplements implements TestInterface{
	public void fun(){}
	public void fun2(){}
	public void fun3(){}
}
