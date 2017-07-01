package p153pra234;
/**
 * 练习2：在几何图形的示例中，添加@override注解
 * （不明白，是在Shape中添加@override吗？）
 * 
 * 练习3：在基类Shape.java中添加一个新方法，用于打印一条消息，但导出类不要覆盖这个方法。
 * 请解释发生了什么:每一个导出类都会执行基类中的那个方法
 * 
 * 现在在其中一个导出类中覆盖该方法，而在其他的导出类不予覆盖，观察又有什么发生：
 * 在Circle类中覆盖了print()方法,结果导致Circle类执行的是自己的print()方法，其余导出类执行的还是基类中的print()方法
 * 
 * 最后，在所有的导出类中覆盖这个方法。（没有尝试，但是实际效果肯定是所有的导出类都执行自己的print()方法）
 * 
 * 练习4,：向Shapes.java中添加一个新的Shape类型，并在main()方法中验证：多态对新类型的作用是否与在旧类型中的一样。
 * (添加了静态的sp变量，但是没看懂题中所说的新类型和旧类型是什么？)
 * 
 * */
public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	
	private static Shape sp = null;
	
	public static void main(String [] args){
		Shape s[] = new Shape[9];
		sp = new Square();
		
		sp.print();;
		
		for(int i = 0; i < s.length; i++){
			s[i] = gen.next();
		}
		
		System.out.println("for:");
		for(Shape shape : s){
			shape.draw();
			shape.print();
		}
	}
}
/*
 * 练习2运行结果：
triangel.draw()
triangel.draw()
square.draw()
triangel.draw()
square.draw()
triangel.draw()
square.draw()
triangel.draw()
circle.draw()

 
 */