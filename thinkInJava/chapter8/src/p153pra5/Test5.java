package p153pra5;

/**
 * 以练习1为基础，在Cycle中添加wheels()方法，它将返回轮子的数。修改ride()方法，让它调用wheels()方法，并验证多态起作用了。
 * */
public class Test5 {
	
	public static void ride(Cycle c){
		System.out.println(c.getClass().getName()+"轮子数量:"+c.wheels());
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
