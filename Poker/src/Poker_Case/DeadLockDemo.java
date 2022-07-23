package Poker_Case;

/**
 * 线程 1 通过 synchronized (resource1) 获得 resource1 的监视器锁，然后通过
 * Thread.sleep(1000); 让线程 1 休眠 1s 为的是让线程 2 得到执⾏然后获取到 resource2 的监视器
 * 锁。线程 1 和线程 2 休眠结束了都开始企图请求获取对方的资源，然后这两个线程就会陷入互相
 * 等待的状态，这也就产生了死锁。这个例子符合产生死锁的四个必要条件。
 * 1. 互斥条件：该资源任意一个时刻只由一个线程占⽤。
 * 2. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * 3. 不剥夺条件:线程已获得的资源在末使用完之前不能被其他线程强行剥夺，只有自己使用完毕
 * 后才释放资源。
 * 4. 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 */

public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程1").start();

        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程2").start();
    }
}
