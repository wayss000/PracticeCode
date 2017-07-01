package p318pra2;
/**
 * 在练习1的基础上,新增一个接口,观察输出,看看能否输出这个类
 * 
 * */

interface HasBatteries2{}
interface Waterproof2{}
interface Shoots2{}

//this interface is new
interface NewInterface2{}

public class ToyTest2 {
    static void printInfo(Class cc){
        System.out.println("Class name:" + cc.getName() + 
                " is interface?[" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    
    public static void main (String [] args){
        Class c = null;
        try{
            c = Class.forName("p318pra2.FancyToy2");
        } catch (ClassNotFoundException e){
            System.out.println("Can't find FancyToy2");
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

class Toy2{
    Toy2(){}
    Toy2(int i){}
}

class FancyToy2 extends Toy2 implements HasBatteries2,Waterproof2,Shoots2,NewInterface2{
    FancyToy2(){ super(1); }
}

/*
 *答案是可以的,我新建了个NewInterface2接口,这段代码的输出比上一个多个接口
 *
 */
