package p129pra2;

public class Detergent extends Cleanser {

	public void scrub(){
		append("Detergent.scrub()");
		super.scrub();
	}
	
	public void foam(){
		append("foam()");
	}
	
	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();

		System.out.println(x);
		
		System.out.println("Testubg base class:");
		Cleanser.main(args);//Get新技能：main方法这样用，学习了
	}

}

/*
 * 运行结果：
Cleanserdilute()apply()Detergent.scrub()scrub()foam()
Testubg base class:
Cleanserdilute()apply()scrub()
 * 
 * 
 * PS：可以看出，子类有scrub()方法，所以就直接执行子类的scrub()方法，不再执行父类中的scrub()方法了，
 * 而子类没有dilute()方法和apply()方法，就直接执行父类中的该方法了
 * 
 * 
 */