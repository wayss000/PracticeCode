package p155pra6;

import java.util.Random;

/**
 * 练习6:修改Music3.java，使what()方法成为根Object的toString()方法。
 * 试用System.out.println()方法打印Instrument对象（不用向上转型）
 * 答案:改为Instrument.toString()即可
 * 
 * 练习7:向Music3.java中添加一个新的类型Instrument,并验证多态性是否作用于所添加的新类型
 * 
 * 练习8:修改Music3.java,使其可以像Shapes.java中的方式那样随机的创建Instrument对象
 * 答案:(先将原来的数组生成方式注释了)
 * */
public class Music3 {
	public static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	
	public static void tuneAll(Instrument [] e){
		for(Instrument i : e){
			tune(i);
		}
	}
	
	public static void main(String [] args){
//		Instrument [] all = {
//				new Wind(),
//				new Percussion(),
//				new Stringed(),
//				new Brass(),
//				new Woodwind()
//				}; 
		
		Instrument [] all = new Instrument[100];
		
		RandomInstrument ri = new RandomInstrument();//练习8随机生成方法
		for(int i = 0; i < all.length; i++){
			all[i] = ri.getInstrument();
		}
		
		tuneAll(all);
		
		Instrument i = new Instrument();//练习7代码,不知道题中是不是这个意思..这种添加方式
		i.play(Note.MIDDLE_C);
		
//		System.out.println(all[0].what());		//测试what()方法
	}
}

class Instrument{
	void play(Note n){
		System.out.println("Instrument.play()"+n);
	}
	
	String what(){
//		return "Instrument.";
		return this.toString();
	}
	
	void adjust(){
		System.out.println("Adjusting Instrument");
	}
}

class Wind extends Instrument{
	void play(Note n){
		System.out.println("Wind.play()"+n);
	}
	
	String what(){
//		return "Wind.";
		return this.toString();
	}
	
	void adjust(){
		System.out.println("Adjusting Wind");
	}
}

class Percussion extends Instrument{
	void play(Note n){
		System.out.println("Percussion.play()"+n);
	}
	
	String what(){
//		return "Percussion.";
		return this.toString();
	}
	
	void adjust(){
		System.out.println("Adjusting Percussion");
	}
}

class Stringed extends Instrument{
	void play(Note n){
		System.out.println("Stringed.play()"+n);
	}
	
	String what(){
//		return "Stringed.";
		return this.toString();
	}
	
	void adjust(){
		System.out.println("Adjusting Stringed");
	}
}

class Brass extends Wind{
	void play(Note n){
		System.out.println("Brass.play()"+n);
	}
	
	void adjust(){
		System.out.println("Adjusting Brass");
	}
}

class Woodwind extends Wind{
	void play(Note n){
		System.out.println("Woodwind.play()"+n);
	}
	
	String what(){
//		return "Woodwind.";
		return this.toString();
	}
}

class RandomInstrument{//练习8的随机产生类
	private static Random rd = new Random();
	
	public Instrument getInstrument(){
		switch(rd.nextInt(6)){
		default:
		case 0:return new Instrument();
		case 1:return new Wind();
		case 2:return new Percussion();
		case 3:return new Stringed();
		case 4:return new Brass();
		case 5:return new Woodwind();
		}
	}
}