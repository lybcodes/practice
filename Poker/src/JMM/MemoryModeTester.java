package JMM;

import java.util.Random;

public class MemoryModeTester {
    int x, y, x_read, y_read;

    void randomSleep(){
        try {
            Thread.sleep(new Random().nextInt(30));
        } catch (InterruptedException e) {
            //e.printStackTrace();
            //catch里面尽量对异常能处理就处理，像这种系统自动生成的打印Trace并不是最好的处理办法
            //这里我们把它包装到一个运行时异常中去,因为RuntimeException可以抛出去
            throw new RuntimeException(e);
        }
    }

    Thread createThread1(){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                randomSleep();
                x = 1;
                y_read = y;
            }
        });
    }
    Thread createThread2(){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                randomSleep();
                y = 1;
                x_read = x;
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            MemoryModeTester tester = new MemoryModeTester();
            Thread thread1 = tester.createThread1();
            Thread thread2 = tester.createThread2();

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println(String.format("(%d, %d)", tester.x_read, tester.y_read));

            if(tester.x_read == 0 && tester.y_read == 0){
                throw new RuntimeException("What?");
            }
        }
    }
}
