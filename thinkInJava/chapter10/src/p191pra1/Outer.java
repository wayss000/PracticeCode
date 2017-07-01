package p191pra1;
/**
 * 创建一个名为Outer的类,它包含一个名为Inner的类,在Outer中添加一个方法,它返回一个Inner类型的对象,
 * 在main()中,创建并初始化一个指向某个Inner对象的引用.
 * */
public class Outer {
	
	public Outer(){
		System.out.println("Outer");
	}
	
	
	public Inner fun(){
		return new Inner();
	}
	
	public static void main(String [] args){
		Inner i = new Outer().fun();
	}
	
	class Inner{
		Inner(){
			System.out.println("Inner");
		}
	}
}


/*
运行结果:
Outer
Inner
说明:先创建一个Outer实例,Outer的实例中的fun方法创建Inner实例
 */