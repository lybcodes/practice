//package ThreadDemo;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class CountDownLatchExample {
//    private static final int threadCount = 6;//处理文件的数量
//
//    public static void main(String[] args) throws InterruptedException {
//        //创建一个具有固定数量的线程池对象
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
//        for(int i = 0; i < threadCount; i++){
//            threadPool.execute(()->{
//                try{
//                    //处理文件的逻辑操作
//                    //...
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }finally {
//                    //表示一个文件已完成
//                    countDownLatch.countDown();
//                }
//            });
//        }
//        countDownLatch.await();
//        threadPool.shutdown();
//        System.out.println("finish");
//    }
//}
