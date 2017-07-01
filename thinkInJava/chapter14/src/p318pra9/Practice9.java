package p318pra9;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 修改练习8,让练习8中的方法试用Class.getDeclaredFields()来打印一个类中的域相关信息
 * @author SSS
 *
 */


class A{
    public Map map;
}

class B extends A{
    public int a;
}

class C extends B{
    private int a;
}

class D extends C{
    public int a;
    public int b;
    private int c;
    public void fun(){}
}

public class Practice9 {

    public static void main(String[] args) {
        myFunction(D.class);
    }
    
    /**
     * 
     * @param Class
     */
    public static void myFunction(Class c){
        Field [] fields = c.getDeclaredFields();
        System.out.println(c.getName() + ":");
        for(Field f : fields){
            System.out.println(f.getName());
        }
        Class fatherClass = c.getSuperclass();
        if(fatherClass != null){
            myFunction(fatherClass);
        }
    }
}

/*
 * 运行结果:
p318pra9.D:
a
b
c
p318pra9.C:
a
p318pra9.B:
a
p318pra9.A:
map
java.lang.Object:
 
 
 getDeclaredFields()方法会返回此类的所有属性信息,包括私有或者公有
 *
 */
