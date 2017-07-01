package p171pra1;
/**
 * 将练习9的Robent类修改为抽象类,只要有可能,九江Rodent中的方法修改为抽象方法.
 * */
public abstract class Robent{
	private int ref = 0;	//练习14的应用计数
	
	public abstract void fun();	//抽象方法,用abstract修饰的方法只有声明,而没有函数体.
	
	public void addRef(){
		ref++;
	}
	
	public void dispose(){
		if(--ref == 0){
			System.out.println("Dispose Robent");
		}
	}
	
	public Robent(){
		System.out.println("Robent.chushihua");
	}
	
	public void name(){
		System.out.println("Robent");
	}
}