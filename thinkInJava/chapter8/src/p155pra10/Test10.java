package p155pra10;
/**
 * 创建一个包含两个方法的基类.在第一个方法中可以调用第二个方法.然后产生一个继承自该该基类的导出类,且覆盖基类中的第二个方法.
 * 对该导出类创建一个对象,将它向上转型到基类型,并调用第一个方法,解释发生的情况.
 * */
public class Test10 {
	public static void main(String [] args){
		Base b = new DaoChuLei();
		b.fun111();
	}
}

class Base{
	public void fun111(){
		System.out.println("Base.fun111()");
		fun222();
	}
	
	public void fun222(){
		System.out.println("Base.fun222()");
	}
}

class DaoChuLei extends Base{
	public void fun222(){
		System.out.println("DaoChuLei.fun222()");
	}
}

/*运行结果:
Base.fun111()
DaoChuLei.fun222()

 * PS:由于导出类中没有fun111()方法,故调用基类中的.
 * 当fun111()方法执行到调用fun222()时,
 * 由于导出类中已经将fun222()方法覆盖了,
 * 此时就执行导出类中的fun222()方法,而不是继续执行基类的了.
 * 
 */