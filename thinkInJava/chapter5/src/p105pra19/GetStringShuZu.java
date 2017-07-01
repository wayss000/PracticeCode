package p105pra19;
/**
 * 写一个类,可以接受可变参数String列表
 * 验证你可以向该方法传递一个用逗号分隔的String列表,或是一个String[]
 * */
public class GetStringShuZu {
	public static void main(String [] args){
//		这种方法是传递一个String[] 数组
		String arr[] = new String[]{"aaa","bbb","ccc"};
		
//		不知道题中说的逗号分隔的String列表指的是什么
//		故,没有完成向该类传递String列表
//		PS:不知道main方法中是怎么接受的
		Test t = new Test(arr);
	}
}



class Test{
	public Test(String [] arr){
		for(String str:arr){
			System.out.println(str);
		}
	}
}