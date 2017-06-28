### 线程中断状态练习说明

1. 两个单例模式的对象
2. 均被两个线程调用
3. 代码输出结果表示，同一个对象在不同的线程具有不同的线程中断状态

Main
	->Thread(111)->Object(BBB)->Object(AAA)
	->Thread(222)->Object(BBB)->Object(AAA)
	
对象AAA中打印的线程状态是线程独立的