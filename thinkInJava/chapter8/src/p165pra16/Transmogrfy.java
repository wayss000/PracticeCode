package p165pra16;
/**
 * 练习16:遵循Transmogrify.java这个例子,创建一个Starship类,包含一个AlertStatus引用,此引用可以只是 三种不同的状态,纳入一些可以改变这些状态的方法.
 * */
public class Transmogrfy {
	
	public static void main(String [] args){
//		Stage stage = new Stage();
//		stage.performPlay();
//		stage.change();
//		stage.performPlay();
		
		Starship ss = new Starship();
		ss.AlertStatus.act();
		ss.toHappyActor();
		ss.AlertStatus.act();
		ss.toSadActor();
		ss.AlertStatus.act();
	}
}

class Actor{
	public void act(){}
}

class HappyActor extends Actor{
	public void act(){
		System.out.println("HappyActor");
	}
}

class SadActor extends Actor{
	public void act(){
		System.out.println("SadActor");
	}
}

class Stage{
	private Actor actor = new HappyActor();
	public void change(){
		actor = new SadActor();
	}
	
	public void performPlay(){
		actor.act();
	}
}

class Starship{
	public Actor AlertStatus = new Actor();
	public void toHappyActor(){
		AlertStatus = new HappyActor();
	}
	
	public void toSadActor(){
		AlertStatus = new SadActor();
	}
	
	public void toActor(){
		AlertStatus = new Actor();
	}
	
}