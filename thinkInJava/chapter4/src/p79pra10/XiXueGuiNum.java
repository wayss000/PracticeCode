package p79pra10;

import java.security.GeneralSecurityException;

/**
 * 吸血鬼数字，位数为偶数，可以是吸血鬼数字的1/2个数字组合相乘得到。
 * 末尾两个数字同时为0则不是吸血鬼数字
 * 现在求4位数字的吸血鬼数字
 * */
public class XiXueGuiNum {
	public static void main(String [] args){
		for(int i = 1001; i <= 9999; i++){
			int a,b,c,d;//分别获取4个数字
			a = i / 1000;
			b = i % 1000 / 100;//或者b = (i - a*1000)/100;
			c = (i - a*1000 - b*100)/10;
			d = i % 10;

			if(c == 0 && d == 0){
				continue;
			}
			if(0 == getNum(i,a,b,c,d)){
				continue;
			}else{
				System.out.println(getNum(i, a, b, c, d));
			}
		}
	}
	
	public static int getNum(int i,int a,int b,int c,int d){
		//将4个数字的排列组合与i作比较，相等即为吸血鬼数字
		if(i == ((a*10+b)*(c*10+d))){
			return i;
		}
		if(i == ((a*10+b)*(d*10+c))){
			return i;
		}
		if(i == ((a*10+c)*(b*10+d))){
			return i;
		}
		if(i == ((a*10+c)*(d*10+b))){
			return i;
		}
		if(i == ((a*10+d)*(c*10+b))){
			return i;
		}
		if(i == ((a*10+d)*(b*10+c))){
			return i;
		}
		if(i == ((b*10+a)*(c*10+d))){
			return i;
		}
		if(i == ((b*10+a)*(d*10+c))){
			return i;
		}
		if(i == ((b*10+c)*(a*10+d))){
			return i;
		}
		if(i == ((b*10+c)*(d*10+a))){
			return i;
		}
		if(i == ((b*10+d)*(a*10+c))){
			return i;
		}
		if(i == ((b*10+d)*(c*10+a))){
			return i;
		}
		if(i == ((c*10+b)*(a*10+d))){
			return i;
		}
		if(i == ((c*10+b)*(d*10+a))){
			return i;
		}
		if(i == ((c*10+d)*(a*10+b))){
			return i;
		}
		if(i == ((c*10+d)*(b*10+10))){
			return i;
		}
		if(i == ((c*10+a)*(b*10+d))){
			return i;
		}
		if(i == ((c*10+a)*(d*10+b))){
			return i;
		}
		if(i == ((d*10+b)*(c*10+a))){
			return i;
		}
		if(i == ((d*10+b)*(a*10+c))){
			return i;
		}
		if(i == ((d*10+c)*(a*10+b))){
			return i;
		}
		if(i == ((d*10+c)*(b*10+a))){
			return i;
		}
		if(i == ((d*10+a)*(c*10+b))){
			return i;
		}
		if(i == ((d*10+a)*(b*10+c))){
			return i;
		}
		
		return 0;
	}
}


/*
 运行结果：
1260
1395
1435
1530
1827
2187
6880
 */