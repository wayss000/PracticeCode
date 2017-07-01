package p101pra16;
/**
 * 创建一个String数组对象,然后用for循环打印数组
 * */
public class ShuZu {
	static String [] arr = new String[]{"hello","hi","nihao"};
//	String a[] = new String[10];
	public static void main(String [] args){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
