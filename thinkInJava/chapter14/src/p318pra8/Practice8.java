package p318pra8;

/**
 * 写一个方法,接受任意对象最为参数,并能够递归打印出该对象所在的继承体系中的所有类
 * @author SSS
 *
 */


class A{}

class B extends A{}

class C extends B{}

class D extends C{}

public class Practice8 {

    public static void main(String[] args) {
        myFunction(D.class);
    }
    
    /**
     * 
     * @param Class
     */
    public static void myFunction(Class c){
        System.out.println(c.getName());
        Class fatherClass = c.getSuperclass();
        if(fatherClass != null){
            myFunction(fatherClass);
        }
    }
}

/*
 * 运行结果:
p318pra8.D
p318pra8.C
p318pra8.B
p318pra8.A
java.lang.Object
 * 
 * getSuperclass()方法的作用是:
 * 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class
 * 
 * /
 */