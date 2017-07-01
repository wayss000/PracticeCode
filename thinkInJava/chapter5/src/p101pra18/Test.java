package p101pra18;

/**
 * 通过创建对象赋值给应用数组,从而完成练习17
 * 
 * */
public class Test {
	public static void main(String [] args){
		AAA arr[] = new AAA[5];//初始化数组大小为0
		
		for(int i = 0; i < 5; i++){
			arr[i] = new AAA(i+"");
		}
	}
}


class AAA{
	public AAA(String str){
		System.out.println(str+"aaa");
	}
}

/*
 * 执行结果:
0aaa
1aaa
2aaa
3aaa
4aaa
 */