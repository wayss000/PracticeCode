package p318pra10;

/**
 * 写个程序,让它能判断char数组究竟是个基本类型,还是一个对象
 * 
 * @author SSS
 *
 */


public class Practice10 {
    
    public static void main(String [] args){
        char [] cs = new char[5];
        boolean b = judgePrimitive(cs.getClass());
        System.out.println("char [] cs : " + b);
        
        b = judgePrimitive(char.class);
        System.out.println("char : " + b);

        b = judgePrimitive(void.class);
        System.out.println("void : " + b);
    }
    
    public static boolean judgePrimitive(Class c){
        return c.isPrimitive();
    }
}

/*
 * 
 * isPrimitive()
 * 判定指定的 Class 对象是否表示一个基本类型
 * 
 * 运行结果:
 * 
char [] cs : false
char : true
void : true

 * 
 * 可见:数组就对象,不是基本类型
 * 基本类型有8个,外加void,它们可以返回true,其余全是false
 * 
 */


