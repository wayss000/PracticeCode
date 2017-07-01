package p318pra7;

/**
 * 从命令行输入对象名,进行对象创建
 * @author SSS
 *
 */

class Candy{
    static{
        System.out.println("Loading Candy");
    }
}
class Gum{
    static{
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}


public class SweetShop {

    public static void main(String[] args) {
        System.out.println("inside main");
//        new Candy();
        try{
            //args[0] is from command
            Class.forName(args[0]);
        }catch(ClassNotFoundException e){
            System.out.println("not found Candy");
        }
        
        System.out.println("After creating Candy");
        try{
            Class.forName("Gum");
        }catch(ClassNotFoundException e){
            System.out.println("not found Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }

}


/*
*备注:注释掉的是书上例子的代码.
*
*/

