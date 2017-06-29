
public class SingleAAAObj {

    //创建 SingleObject 的一个对象
    private static SingleAAAObj instance = new SingleAAAObj();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleAAAObj(){}

    //获取唯一可用的对象
    public static SingleAAAObj getInstance(){
       return instance;
    }

    public void showThreadStatus(){
        //打印对象hashcode，确定是同一个对象
        System.out.println(this);
        System.out.println(Thread.currentThread().getName() + "SingleObject isInterrupted:" + Thread.currentThread().isInterrupted());
    }
 }