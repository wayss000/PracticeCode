package pers.wayss.allTest;

public class TestException {

    public static void main(String[] args) {
        new TestException().fun1();
    }
    
    public void fun1(){
        fun2();
    }
    
    public void fun2(){
        fun3();
    }
    
    public void fun3(){
        int [] arr = {1,2};
        System.out.println(arr[2]);
    }

}
