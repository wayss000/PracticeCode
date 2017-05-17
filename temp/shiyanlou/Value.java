/**
 * eclipse 可以通过sourse自动生成hashCode和equals方法，比自己实现的要好。
 */
public class Value {
    private int i;
    private String s;
    
    public Value(){
        
    }
    public Value(int i,String s){
        this.i = i;
        this.s = s;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        result = prime * result + ((s == null) ? 0 : s.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Value other = (Value) obj;
        if (i != other.i)
            return false;
        if (s == null) {
            if (other.s != null)
                return false;
        } else if (!s.equals(other.s))
            return false;
        return true;
    }
    
    //我的实现,当s为null时，有bug
/*    public boolean equals(Object o){
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
    }*/
}
