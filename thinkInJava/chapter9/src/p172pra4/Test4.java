package p172pra4;
/**
 * 创建一个不包含任何方法的抽象类,从它那里导出一个类,并添加一个方法.创建一个静态方法,他可以接受指向基类的引用,将其向下转型到导出类,然后在调用该静态方法.
 * 在main()中,展现他的运行情况.
 * 然后为基类中的方法加上abstract声明,这样就不再需要向下转型
 * */
public abstract class Test4 {

}

class DaoChuTest4 extends Test4{
	public void fun(){
		
	}
	public static void fun22(Test4 t){
		t = new DaoChuTest4();
//		fun22();
	}
}

//看不懂题目意思啊