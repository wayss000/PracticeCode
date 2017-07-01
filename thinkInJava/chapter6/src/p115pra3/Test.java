package p115pra3;
/**
 * 两个包debug和debugoff中有一个相同名字的类，该类有一个debug方法，其中一个显示发送个控制台的String参数，另一个什么也不做
 * */

import static debug.Demo.debug;
//import static debugoff.Demo.*;


public class Test {
	public static void main(String [] args){
		debug();
	}
}

/*
运行结果：
debug包中
*/

/*
 * 个人感觉这道题是让读者明白如何静态导入（导入具体的静态方法）
 * 同时，让读者明白，一个包中是不允许import两个相同名字的类
 */