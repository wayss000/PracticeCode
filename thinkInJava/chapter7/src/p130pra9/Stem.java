package p130pra9;
/**
 * 创建一个Root类,令其含有名为Component1,Component2,Component3类的各一个实例
 * 从Root中派生一个类Stem,也含有上述各组成部分
 * 所有的类都应该有可打印出类的相关信息的默认构造器
 * 
 * */
public class Stem extends Root{
	
	Component1 c1 = new Component1();
	Component2 c2 = new Component2();
	Component3 c3 = new Component3();
	
	Stem(){
		System.out.println("stem");
	}
	
	public static void main(String [] args){
		Stem t = new Stem();
	}
}

/*
 *执行结果:
com111
com222
com333
root
com111
com222
com333
stem
 
 PS:初始化Stem的时候会先执行它的基类Root,
 当他的基类初始化完成后才  开始它的 初始化
 * 
 */