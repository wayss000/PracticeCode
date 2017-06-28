import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo<E> {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final List<E> list = new ArrayList<>();

    public void set(E o) {
        writeLock.lock();
        try {
            list.add(o);
            System.out.println("Adding element by thread" + Thread.currentThread().getName());
        } finally {
            writeLock.unlock();
        }
    }

    public E get(int i) {
        readLock.lock();
        try {
            System.out.println("Printing elements by thread" + Thread.currentThread().getName());
            return list.get(i);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo<String> threadSafeArrayList = new ReadWriteLockDemo<>();
        threadSafeArrayList.set("1");
        threadSafeArrayList.set("2");
        threadSafeArrayList.set("3");
        System.out.println("Printing the First Element : " + threadSafeArrayList.get(1));
    }
}

/* 
 * 读写锁的用法
 * readLock = readWriteLock.readLock();   
 * writeLock = readWriteLock.writeLock(); 
 * 
 * 读锁用于get方法
 * 写锁用于set方法
 * 
 * 用读锁来锁定读操作，用写锁来锁定写操作，
 * 这样写操作和写操作之间会互斥，
 * 读操作和写操作之间会互斥，
 * 但读操作和读操作就不会互斥。
 * 
 */