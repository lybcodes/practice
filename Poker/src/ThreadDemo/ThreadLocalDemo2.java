package ThreadDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 假设有一个需求 在多线程我们有一个需求，那就是在多线程环境下，去格式化时间为指定格式yyyy-MM-dd HH:mm:ss
 * 在线程少的情况下是没有问题的，我们在每个线程里调用date方法，也就是在每个线程里都执行了创建SimpleDateFormat对象，
 * 每个对象在各自的线程里面执行格式化时间，
 *
 * 但是假如有1000个线程需要格式化时间，那么需要调用1000次date方法，
 * 也就是需要创建1000个作用一样的SimpleDateFormat对象，这样是不是太浪费内存了？也给GC带来压力？
 *
 * 于是可以联想到，1000个线程来共享一个SimpleDateFormat对象，这样SimpleDateFormat对象只需要创建一次即可
 *
 * 发现执行结果中有很多重复的时间格式化内容，这是为什么呢？
 *
 * 这是因为SimpleDateFormat是一个线程不安全的类，其实例对象在多线程环境下作为共享数据，会发生线程不安全问题。
 * 可以使用锁，但是更好的方式是利用ThreadLocal
 * 我们使用ThreadLocal的目的是为了避免创建1000个SimpleDateFormat对象，且在不使用锁的情况下保证线程安全
 */

public class ThreadLocalDemo2 {

    public static ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++){
            int final1 = i;
            THREAD_POOL.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalDemo2().date(final1);
                    System.out.println(date);
                }
            });
        }
        //关闭线程池，此种关闭方式不再接受新的任务提交，等待现有队列中的任务全部执行完毕之后关闭
        THREAD_POOL.shutdown();
    }

    private String date(int i) {
        //参数的单位是毫秒，从1970.1.1 00：00：00计时
        Date date = new Date(1000 * i);
        ThreadSafeDateFormatter.dateFormatThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        SimpleDateFormat dateFormat = ThreadSafeDateFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }

    /**
     * 使用到了ThreadLocal，将SimpleDateFormat对象用ThreadLocal包装了一层，
     * 使得多个线程内部都有一个SimpleDateFormat对象副本，每个线程使用自己的SimpleDateFormat，这样就不会产生线程安全问题了。
     */
    static class ThreadSafeDateFormatter{
        /**
         * 注释掉的是另一种写法 这样些就不需要在data方法里面这句了ThreadSafeDateFormatter.dateFormatThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
         */
//        public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
//            @Override
//            protected SimpleDateFormat initialValue(){
//                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            }
//        };
        public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>();

    }
}
