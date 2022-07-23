//package DesignMode;
//
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * 饿汉式
// */
//public class Singleton{
//    private Singleton(){};
//    private static Singleton instance = new Singleton();
//    public static Singleton getInstance(){
//        return instance;
//    }
//}
//
///**
// * 懒汉式
// */
//public class Singleton{
//    private Singleton(){};
//    private static Singleton instanece;
//    public static synchronized Singleton getInstace(){
//        if(instance == null){
//            return new Singleton();
//        }
//    }
//}
//
///**
// * 双重校验
// * 双重检查锁，因为会有两次检查
// * instance == null，一次是在同步块外，一次是在同步块内。为什么在同步块内还要再检验一次？
// * 因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
// */
//public class Singleton{
//    private Singleton(){};
//    private static Singleton instance;
//    private static Singleton getInstance(){
//        if(instance == null){
//            synchronized (Singleton.class){
//                if(instance == null){
//                //** instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
//                  *  1.给 instance 分配内存
//                  *  2.调用 Singleton 的构造函数来初始化成员变量
//                  *  3.将instance对象指向分配的内存空间（执行完这步 instance 就为非null了）
//                  */
//                    return new Singleton();
//                }
//            }
//        }
//    }
//}
//
///**
// * 静态内部类
// */
//public class Singleton{
//    private Singleton(){};
//
//    private class SingletonHandler{
//        private static Singleton instance = new Singleton();
//    }
//
//    public static Singleton getInstance(){
//        return SingletonHandler.instance;
//    }
//}
//
///**
// * 枚举类
// */
//public enum Singleton{
//    INSTANCE;
//}



