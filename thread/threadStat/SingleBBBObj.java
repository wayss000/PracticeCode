
public class SingleBBBObj {
    private static SingleBBBObj singleBBBObj = new SingleBBBObj();
    //B对象的单例中有一个A对象的单例
    private SingleAAAObj singleAAAObj = SingleAAAObj.getInstance();
    
    private SingleBBBObj(){}
    
    public static SingleBBBObj getInstance(){
        return singleBBBObj;
    }

    public SingleAAAObj getSingAAAObj() {
        return singleAAAObj;
    }

    public void setSingAAAObj(SingleAAAObj singAAAObj) {
        this.singleAAAObj = singAAAObj;
    }
    
}
