package p171pra3;
/**
 * 创建一个基类,让它包含抽象方法print(),并在导出类中覆盖该方法,覆盖后的方法版本可以打印导出类中定义的某个整体变量的值,
 * 在定义该变量之处,富裕它非零值.在基类的构造器中调用这个方法,现在在main()方法中,创建一个导出类对象,然后调用它的print()方法.解释发生的情形.
 * */
public abstract class BaseClass {
	
	public BaseClass(){
		print();
	}
	
	public abstract void print();
	
	public static void main(String [] args){
		DaoChuBase dcb = new DaoChuBase();
		dcb.print();
	}
}

class DaoChuBase extends BaseClass{
	
	private int i = 5;
	
	public void print(){
		System.out.println(i);
	}
}

/*
 * 运行结果:
0
5

我的解释:再创建DaoChuBase时,首先会创建它的基类,而基类在初始化时会调用print()方法,
(难道会调用子类中已经实现的print()方法???经过别人提醒,用Debug观察了一下,确实是,基类在调用print()时,确实会跑到导出类中,调用导出类已经实现了的print()方法)所以打印出0
而导出类在调用print方法时,顺理成章的打印出5.
 * 
 */