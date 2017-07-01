package p150pra1;
/**
 * 创建一个Cycle类，它具有子类Unicycle,Bicycle和Tricycle.
 * 演示每一个类型的实例都可以经由ride()方法向上转型为Cycle
 * */
public class Test {
	
	public static void ride(Cycle c){
		System.out.println(c.getClass().getName());
	}
	
	public static void main(String [] args){
		Unicycle u = new Unicycle();
		Bicycle b = new Bicycle();
		Tricycle t = new Tricycle();
		
		ride(u);
		ride(b);
		ride(t);
	}
}


/*
 * 运行结果：
cycle
unicyle
cycle
bicycle
cycle
tricycle
p150pra1.Unicycle
p150pra1.Bicycle
p150pra1.Tricycle

 */