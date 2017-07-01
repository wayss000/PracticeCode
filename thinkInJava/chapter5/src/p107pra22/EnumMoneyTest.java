package p107pra22;
/**
 * 在练习21中的例子中,为enum写一个switch()语句,并对每一个case输出该特定货币的描述.
 * */
public class EnumMoneyTest {
	public static void main(String [] args){
//		Test t = Test.yuan;
		Test t = Test.jiao;
//		Test t = Test.fen;
		
		switch(t){
		case fen:
			System.out.println("分");
			break;
		case jiao:
			System.out.println("角");
			break;
		case yuan:
			System.out.println("元");
			break;
		default:
			System.out.println("没有");
			break;
		}
	}
}

enum Test{
	yuan,jiao,fen;
}

/*
 * 运行结果:
 * 角
 * 
 * 
 * 
 * PS:这里,我对switch()有了新的了解,switch()中的参数,
 * 它可以是int,char等型,当括号中的元素确定了的时候,
 * 也就是确定了switch中case后面的元素类型
 */