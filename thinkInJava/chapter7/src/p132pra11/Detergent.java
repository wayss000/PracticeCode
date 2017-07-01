package p132pra11;
/**
 * 修改Detergent,让它使用代理
 * */
public class Detergent {
	
	private Cleanser c = new Cleanser();
	
	public void scrub(){
		c.append("Detergent.scrub()");
		c.scrub();
	}
	
	public void foam(){
		c.append("foam()");
	}
	
	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.c.dilute();
		x.c.apply();
		x.scrub();
		x.foam();

		System.out.println(x);
		
		System.out.println("Testubg base class:");
		Cleanser.main(args);//Get新技能：main方法这样用，学习了
	}

}

/*
 * 运行结果：
p132pra11.Detergent@2a139a55
Testubg base class:
Cleanserdilute()apply()scrub()
 * 
 * 
 * PS：其实代理,我觉得就是,把一个类,作为另一个类的属性,在另一个类中,使用那个类的方法
 * 
 * 
 */