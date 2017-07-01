package p68;
/**
 * 旧式for循环的用法，（我第一次见）
 * */
public class ForEachString {
	public static void main(String [] args){
		for(char c: "helo, my name is sss".toCharArray()){
			System.out.println(c+" ");
		}
	}
}


/*运行结果：
h
e 
l 
o 
, 
  
m 
y 
  
n 
a 
m 
e 
  
i 
s 
  
s 
s 
s  
 */