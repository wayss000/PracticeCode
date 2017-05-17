
public class Value {
    private int i;
    private String s;
    
    public Value(){
        
    }
    public Value(int i,String s){
        this.i = i;
        this.s = s;
    }
    
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(o instanceof Value){
            if(this.i == ((Value)o).i && this.s.equals(((Value)o).s)){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }
}
