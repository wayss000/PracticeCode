/**
 * 补全 IntegerExt 类的静态方法 getInstance(int i)，
 * 对参数在 -128 （包含）到 127 （包含）之间的实例使用常量池，
 * 范围之外的不使用。
 * @author Wayss
 * Create time 2017-06-29
 *
 */
public class IntegerExt {
    private static final int MINNUMBER = -128;
    private static final int MAXNUMBER = 127;
    private int i;
    private IntegerExt(int i){
        this.i = i;
    }
    public int toIntValue(){
        return i;
    }
    public static IntegerExt getInstance(int i){
        if(i >= MINNUMBER && i <= MAXNUMBER){
            return cache[i];
        }
        return new IntegerExt(i);
    }
    
    //构造常量池
    private static final IntegerExt[] cache = new IntegerExt[MAXNUMBER - MINNUMBER + 1];
    static {
        for(int j = 0,k = MINNUMBER ; j < cache.length; j++ ){
            cache[j] = new IntegerExt(k++);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IntegerExt other = (IntegerExt) obj;
        if (i != other.i)
            return false;
        return true;
    }
}
