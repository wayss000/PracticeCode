package p174pra7;
/**
 * 修改第八章练习9中的Rodent,使其成为一个接口.
 * */
public interface RodentInterface {
	static int ref = 0;
	
	public void addRef();
	public void dispose();
	public void name();
}
