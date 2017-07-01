package p107pra21;
/**
 * 创建一个enum类型,包含纸币的面值类型,通过values()循环兵打印每一个值以及其ordinal()
 * */
public class EnumMoney {
	public static void main(String [] args){
		for(Test t : Test.values()){
			System.out.println(t.ordinal());
		}
	}
}


enum Test{
	yuan,jiao,fen;
}


/*
 *运行结果:(应该看看Enum源码)
0
1
2
 */