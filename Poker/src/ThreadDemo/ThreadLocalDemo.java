package ThreadDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 假设有一个需求 在多线程我们有一个需求，那就是在多线程环境下，去格式化时间为指定格式yyyy-MM-dd HH:mm:ss
 * 在线程少的情况下是没有问题的，我们在每个线程里调用date方法，也就是在每个线程里都执行了创建SimpleDateFormat对象，
 * 每个对象在各自的线程里面执行格式化时间，
 *
 * 但是假如有1000个线程需要格式化时间，那么需要调用1000次date方法，
 * 也就是需要创建1000个作用一样的SimpleDateFormat对象，这样是不是太浪费内存了？也给GC带来压力？
 */

public class ThreadLocalDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalDemo().date(10);
                System.out.println(date);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalDemo().date(1000);
                System.out.println(date);
            }
        }).start();
    }

    private String date(int i) {
        //参数的单位是毫秒，从1970.1.1 00：00：00计时
        Date date = new Date(1000 * i);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
