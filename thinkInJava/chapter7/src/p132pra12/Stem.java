package p132pra12;
/**
 * 练习9:
 * 创建一个Root类,令其含有名为Component1,Component2,Component3类的各一个实例
 * 从Root中派生一个类Stem,也含有上述各组成部分
 * 所有的类都应该有可打印出类的相关信息的默认构造器
 * 
 * 练习12:
 * 把一个dispose()方法的层次结构添加到练习9的所有类中.//dispose()方法是这部分所讲的关于释放内存的内容
 * 
 * */
public class Stem extends Root{
	
	Component1 c1 = new Component1();
	Component2 c2 = new Component2();
	Component3 c3 = new Component3();
	
	Stem(){
		System.out.println("stem");
	}
	
	public void dispose(){
		c1 = null;
		c2 = null;
		c3 = null;
		System.out.println("stem dispose");
		super.dispose();
	}
	
	public static void main(String [] args){
		Stem t = new Stem();
		t.dispose();
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
stem dispose
root dispose

 PS:初始化Stem的时候会先执行它的基类Root,
 当他的基类初始化完成后才  开始它的 初始化
 
 对于dispose()方法,先释放子类的,在释放基类的
 
 * 
 */