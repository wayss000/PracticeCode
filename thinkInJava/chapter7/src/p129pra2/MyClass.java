package p129pra2;
/**
 * 从Detergent中集成产生一个类，覆盖scrub()并添加一个名为sterilize()的新方法
 * 
 * */
public class MyClass extends Detergent{
	
	public void scrub(){
		append("MyClass.scrub()");
		super.scrub();
	}
	
	public void sterilize(){
		append("sterilize()");
	}
	
	public static void main(String [] args){
		MyClass mc = new MyClass();
		mc.dilute();
		mc.apply();
		mc.scrub();
		mc.sterilize();
		
		System.out.println(mc);
	}
}

/*
 * 执行结果：
	Cleanserdilute()apply()MyClass.scrub()Detergent.scrub()scrub()sterilize()
	
PS：可以看出，对于scrub()方法，先执行MyClass中的，在执行它的父类Detergent中的，最后执行它父类的父类Cleanser中的
 */