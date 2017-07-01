package p155pra9;
/**
 * 练习9:创建Rodent(啮齿动物):Mouse(老鼠),Berbil(鼹鼠),Hamster(大鼹鼠)等这样一个继承层次结构.
 * 在基类Rodent中,提供对所有Rodent都通用的方法,在导出类中,根据特定的Rodent类型覆盖这些方法,以便他们执行不同的行为.
 * 创建一个Robent数组,填充不同额Robent类型,然后调用基类方法,观察发生了什么.
 * 
 * 练习12:修改练习9,使其能够演示基类和导出类的初始化顺序.然后向基类和导出类中添加成员变量,并说明构建期间初始化发生的顺序.
 * 
 * 练习14:修改练习12,使其某个成员对象变为具有引用计数的共享对象,并证明它可以正确运行
 * 答案:将Robent.java设置为具有引用计数的共享对象,(在这里有一个失误,就是直接在上一个练习的基础上修改代码了,没有备份..)
 * 	(心得!心得!心得!)PS:这里说一下子类初始化的时候,都是调用父类的默认构造方法初始化,并且,在继承中,如果一个父类没有默认构造方法,它的导出类中会报错,提示直接父类没有默认构造函数
 * */
public class Test9 {
	private static Robent rb = new Robent();	//设置为共享对象
	
	public static void main(String [] args){
		Robent [] r = {
//				new Robent(),
				new Mouse(rb),
				new Berbil(rb),
				new Hamster(rb)
				};
		
		for(Robent i : r){
			i.dispose();
		}
		//练习12测试时,先注释for循环
		//练习12运行结果(我手动添加了空行,以便清除的分析)
		//四个对象,分了四段
/*		Robent.chushihua
 * 
		Robent.chushihua
		Mouse.chushihua
		
		Robent.chushihua
		Mouse.chushihua
		Berbil.chushihua
		
		Robent.chushihua
		Mouse.chushihua
		Berbil.chushihua
		Hamster.chushihua*/
	}
}

class Robent{
	private int ref = 0;	//练习14的应用计数
	
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

class Mouse extends Robent{
	private Robent r;
	
	public Mouse(){
		System.out.println("Mouse.chushihua");
	}
	
	public Mouse(Robent r){
		System.out.println("Mouse.chushihua");
		this.r = r;
		this.r.addRef();
	}
	
	public void dispose(){
		r.dispose();
	}
	
	public void name(){
		System.out.println("Mouse");
	}
}

class Berbil extends Mouse{
	private Robent r;
	
	public Berbil(){
		System.out.println("Berbil.chushihua");
	}
	
	public Berbil(Robent r){
		System.out.println("Berbil.chushihua");
		this.r = r;
		this.r.addRef();
	}
	
	public void dispose(){
		r.dispose();
	}
	
	public void name(){
		System.out.println("Berbil");
	}
}

class Hamster extends Berbil{
	private Robent r;
	
	public Hamster(){
		
	}
	
	public Hamster(Robent r){
		System.out.println("Hamster.chushihua");
		this.r = r;
		this.r.addRef();
	}
	
	public void dispose(){
		r.dispose();
	}
	
	public void name(){
		System.out.println("Hamster");
	}
}

/*
 * 运行结果:
Robent
Mouse
Berbil
Hamster
 
 PS:导出类会各自执行自己的那么()方法,而不是基类中的.
 *
 */