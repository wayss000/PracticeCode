
public class SingleBBBObj {
    private static SingleBBBObj singleBBBObj = new SingleBBBObj();
    
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
