package ThreadDemo;

/**
 * 为什么避免了死锁的发生?
 * 线程 1 先获得到 resource1 的监视器锁,这时候线程 2 就获取不到了。然后线程 1 再去获取
 * resource2 的监视器锁，可以获取到。然后线程 1 释放了对 resource1、resource2 的监视器锁的
 * 占用，线程 2 获取到就可以执行了。
 * 这样就破坏了破坏循环等待条件，因此避免了死锁。
 */
public class DeadLockDemo1 {
    private static Object resource1 = new Object();//资源1
    private static Object resource2 = new Object();//资源2

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");

                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程1").start();

        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");

                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程2").start();
    }
}
