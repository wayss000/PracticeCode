package p153pra234;

public class Circle extends Shape{
	public void draw(){
		System.out.println("circle.draw()");
	}
	public void erase(){
		System.out.println("circle.erase()");
	}
	@Override public void print(){
		System.out.println("circle.print()");
	}
}
