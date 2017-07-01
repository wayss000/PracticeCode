package p147pra24;
/**
 * 在Beetle.java中，从Beetle类继承产生一个具体类型的“甲壳虫”。
 * 其形式与现有类相同，跟踪并解释其输出结果。
 * 
 * PS：这段代码同时解释了练习23
 * */
public class JiaKeChong extends Beetle{
	
	private int p = printInit("JiaKeChong.p initialized");
	
	private static int x3 = printInit("static JiaKeChong.x3 initialized");
	
	public JiaKeChong(){
		System.out.println("j,p = " + j+"  "+p);
	}
	
	public static void main(String [] args){
//		Beetle b = new Beetle();
		System.out.println("JiaKeChong main");
		JiaKeChong jkc = new JiaKeChong();
		
		//练习23：证明类加载器的动作仅发生一次
		//证明方法：下面又创建了两个JiaKeChong类，console显示如下
		JiaKeChong jkc2 = new JiaKeChong();
		JiaKeChong jkc3 = new JiaKeChong();
		
		/*
static Insect.x1 initialized
static Beetle.x2 initialized
static JiaKeChong.x3 initialized
JiaKeChong main
Insect.i initialized
i = 47,j =  0
Beetle.k initialized
k = 47
j = 39
JiaKeChong.p initialized
j,p = 39  47
//下面为多出的，可以看出，除了静态代码没有再次初始化之外，所有的基类也都同时再次初始化
//也就是说，类加载器只加载一次，但是每次产生新对象，都会初始化所有基类
Insect.i initialized
i = 47,j =  0
Beetle.k initialized
k = 47
j = 39
JiaKeChong.p initialized
j,p = 39  47
Insect.i initialized
i = 47,j =  0
Beetle.k initialized
k = 47
j = 39
JiaKeChong.p initialized
j,p = 39  47

		*/
	}
}

class Insect{
	private int i = printInit("Insect.i initialized");
	protected int j;
	
	Insect(){
		System.out.println("i = " + i + ",j =  " + j);
		j = 39;
	}
	
	private static int x1 = printInit("static Insect.x1 initialized");
	
	static int printInit(String s){
		System.out.println(s);
		return 47;
	}
}

class Beetle extends Insect{
	private int k = printInit("Beetle.k initialized");
	
	public Beetle(){
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}
	
	private static int x2 = printInit("static Beetle.x2 initialized");
	
//	public static void main(String [] args){
//		System.out.println("Beetle constructor");
//		Beetle b = new Beetle();
//	}
}


/*
 * 运行结果：（这个结果是代码中没有添加练习23之前的）
static Insect.x1 initialized			//最顶层  基类  静态变量的初始化
static Beetle.x2 initialized			//次层  基类  静态变量的初始化
static JiaKeChong.x3 initialized		//导出类（直接子类） 静态变量的初始化
JiaKeChong main							//导出类（直接子类）main方法的第一行
Insect.i initialized					//（第二行为生成一个导出类对象）先初始化最顶层基类的 成员变量
i = 47,j =  0							//（第二行为生成一个导出类对象）和初始化（或者叫执行）最顶层基类的 构造方法
Beetle.k initialized					//再初始化次顶层 基类 的成员变量
k = 47									//和执行次顶层  基类的构造方法
j = 39									//次顶层  基类的构造方法
JiaKeChong.p initialized				//导出类（当前子类）的成员变量的初始化
j,p = 39  47							//导出类（当前子类）的构造方法
  
  
  
 * 
 * /
 */