package p138pra14;
/**
 * 在Car.java中给Engine添加一个service()方法,并在main()中调用该方法
 * */

class Engine{
	public void start(){}
	public void rev(){}
	public void stop(){}
	public void service(){	//自定义的方法
		System.out.println("车启动");
	}
}

class Whell{
	public void inflate(int psi){
		
	}
}

class Window{
	public void roolup(){}
	public void rooldown(){}
}

class Door{
	public Window window = new Window(){};
	public void open(){}
	public void close(){}
}

public class Car {
	public Engine engine = new Engine();
	public Whell [] whell = new Whell[4];
	public Door
		left = new Door(),
		right = new Door();
	
	public Car(){
		for(int i = 0; i < 4; i++){
			whell[i] = new Whell();
		}
	}
	
	public static void main(String [] args){
		Car car = new Car();
		car.left.window.roolup();
		car.whell[0].inflate(72);
		car.engine.service();//车car的引擎engine启动
	}
}


//PS:个人觉得这道题目的在于练习使用       对象.对象(属性).方法()