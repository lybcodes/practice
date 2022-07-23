package DesignMode.FactoryAndReflect;

import java.lang.reflect.InvocationTargetException;

interface IMessage2{
    public void send();
}
class NetMessage2 implements IMessage2{
    @Override
    public void send() {
        System.out.println("【网络消息发送】");
    }
}
class CloudMessage1 implements IMessage2{
    @Override
    public void send() {
        System.out.println("【云消息发送】");
    }
}
interface IService{
    public void service();
}
class HouseService implements IService{
    @Override
    public void service() {
        System.out.println("【住房服务】");
    }
}
class Factory1{
    private Factory1(){} //工厂没有实例化的意义，所以构造方法私有化

    /**
     * 获取接口实例化对象，使用泛型T，返回接口实例化对象不具体指定，由外部决定，<T>为泛型标记，不写的话不知道T是泛型
     * @param className 接口的子类
     * @param clazz     描述的是一个接口的类型
     * @param <T>       如果子类存在则返回指定接口实例化对象
     * @return
     */
    public static <T> T getInstance(String className, Class<T> clazz){
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
public class FactoryByReflect {
    public static void main(String[] args) {
        IService service = Factory1.getInstance("HouseService", IService.class);
        service.service();
        IMessage msg = Factory1.getInstance("NetMessage", IMessage.class);
        msg.send();
    }
}
