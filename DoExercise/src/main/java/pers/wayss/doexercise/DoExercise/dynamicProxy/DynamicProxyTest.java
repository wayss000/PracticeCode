package pers.wayss.doexercise.DoExercise.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理练习代码
 * @author Wayss
 * Create Time : 2017年7月5日
 *
 */
public class DynamicProxyTest {
    public static void main(String [] args){
        //普通的显示定义，然后调用执行的方法
        InterfaceImpl intfa = new InterfaceImpl();
        intfa.function();
        
        //Java动态代理方式，先通过Proxy.newProxyInstance()创建动态代理。
        Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(intfa));
        proxy.function();
        
        //动态代理的好处是：当Interface有多个实现时，
        //通过动态代理的方式只需要改Proxy.newProxyInstance()中InvocationHandler的参数即可，
        //避免了大量修改代码的发生
        
    }
}

//接口
interface Interface{
    void function();
}

//接口的实现
class InterfaceImpl implements Interface{

    public void function() {
        System.out.println("interface method implemented.");
    }
    
}

//Handler类
class DynamicProxyHandler implements InvocationHandler{

    private Object obj;
    public DynamicProxyHandler(Object obj){
        this.obj = obj;
    }
    
    //必须实现InvocationHandler接口的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
    
}

