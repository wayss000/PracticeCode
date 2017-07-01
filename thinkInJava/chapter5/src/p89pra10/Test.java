package p89pra10;
/**
 * 编写具有finalize()的方法,并在该方法中打印消息
 * 
 * */
public class Test {
	public static void main(String [] args){
		Book novel = new Book(true);
		novel.checkIn();
		new Book(true);
		System.gc();
		
		Book a = null;
		a.checkIn();
//		System.out.println(a.toString());
	}
}


class Book{//书类,借出,还入
	boolean checkedOut = false;
	
	Book(boolean checkOut){
		checkedOut = checkOut;
	}
	
	void checkIn(){
		checkedOut = false;
	}
	
	protected void finalize(){
		if(checkedOut){
			System.out.println("Error:Checked Out");
		}
	}
}

/*
执行结果:
Error:Checked Out
*/


/* 
之所以使用finalize()方法,可能是分配内存时,采用了类似C语言中的做法
 */