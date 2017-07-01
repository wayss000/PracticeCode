package p168pra17;
/**
 * 练习17:使用练习1的中Cycle的层次结构,在Unicycle和Bicycle中添加balance()方法,而Tricycle中不添加.创建所有这三种类型的实例,并将它们向上转型为Cycle数组.
 * 在 该数组的每一个元素上都尝试,调用balance(),并观察结果.
 * 	答案:有错误,因为Cycle基类没有balance()方法
 * 然后将他们向下转型,再次调用balance(),观察将所产生什么.
 * 	
 * */
public class Test17 {
	public static void main(String [] args){
		Cycle c[] = {
				new Cycle(),
				new Bicycle(),
				new Tricycle(),
				new Unicycle(),
		};
		
		//Cycle基类没有balance()方法,下面4行代码编译不通过
//		c[0].balance();
//		c[1].balance();
//		c[2].balance();
//		c[3].balance();
		
		//向下转型后,有balance()方法的就可以编译通过,没有balance()方法的类,编译会报错
		((Bicycle)c[1]).balance();
//		((Tricycle)c[2]).balance();	//报错,编译不通过 
		((Unicycle)c[3]).balance();
	}
}
