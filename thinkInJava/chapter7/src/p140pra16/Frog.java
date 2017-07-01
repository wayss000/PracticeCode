package p140pra16;
/**
 * 创建一个名为Amphibian的类,由此继承产生一个称为Frog的类.
 * 在基类中设置适当的方法.在main()中,创建一个Frog并向上转型至Amphibian,然后说明所有方法都可工作
 * */
public class Frog extends Amphibian{
	
	@Override public void name(){		//练习17,覆盖基类中的方法
		System.out.println("青蛙");
	}
	
	public void sound(){
		System.out.println("呱呱");
	}
	
	public static void main(String [] args){
		Amphibian a = null;
		a = new Frog();		//创建Frog对象,向上转型至Amphibian
		a.name();			//父类和子类都有的方法,执行子类的
		a.weight();			//父类有的方法直接执行父类的
//		a.sound();			//子类有,而父类没有的方法,编译出错
		
//		Frog f = new Amphibian(); 	//父类不能向下转型为子类
	}
}

/*
 *运行结果:
 *
 两栖动物
青蛙
weight
 *
 */