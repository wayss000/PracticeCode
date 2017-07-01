package p130pra6;
/**
 * 用Chess.java证明:调用基类构造器必须是你在到处类的构造器中要做的第一件事
 * */
public class Chess extends BoardGame{
	Chess(){
		super(11);
		System.out.println("Chess constructor");
	}
	
	public static void main(String [] args){
		Chess x = new Chess();
	}
}

class Game{
	Game(int i){
		System.out.println("Game constructor");
	}
}

class BoardGame extends Game{
	BoardGame(int i) {
		super(i);
		System.out.println("BoardGame constructor");
	}
}

/*
运行结果:
Game constructor
BoardGame constructor
Chess constructor
 * 
 */