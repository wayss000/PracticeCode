package p130pra8;
/**
 * 创建一个基类,它仅有一个非默认的构造器,再创建一个导出类,它带有默认构造器和非默认构造器.
 * 在导出类的构造器中调用基类的构造器
 * */
public class Test extends BaseClass{
	Test(){
		super(1);
		System.out.println("Test Class");
	}
	
	Test(int i){
		super(i);
		System.out.println("Test Class");
	}
}

/*
 * PS:这里在导出类的两个构造器中都得调用基类的构造器方法
 */