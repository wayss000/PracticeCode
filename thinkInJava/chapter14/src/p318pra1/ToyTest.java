package p318pra1;
/**
 * 去掉书上示例代码Toy的默认构造函数,解释发生的事
 * 
 * */

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name:" + cc.getName() + 
                "is interface?[" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    
    public static void main (String [] args){
        Class c = null;
        try{
            c = Class.forName("p318pra1.FancyToy");
        } catch (ClassNotFoundException e){
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        }catch(InstantiationException e){
            System.out.println("cannot instantiate");
            System.exit(1);
        }catch(IllegalAccessException e){
            System.out.println("cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){ super(1); }
}

/*
 * Class.newInstance()方法:创建此 Class 对象所表示的类的一个新实例
 *有构造函数时:
 *在代码: obj = up.newInstance();
 *可以生成obj对象,
 *
 *没有构造函数时:
 *不能生成对象,抛出InstantiationException异常.
 *
 */
