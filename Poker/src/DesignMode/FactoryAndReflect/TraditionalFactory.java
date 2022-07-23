package DesignMode.FactoryAndReflect;

interface IMessage1{
    public void send();
}
class NetMessage1 implements IMessage1{
    @Override
    public void send() {
        System.out.println("【网络消息发送】");
    }
}
class CloudMessage implements IMessage1{
    @Override
    public void send() {
        System.out.println("【云消息发送】");
    }
}
// 标准工厂设计模式
class Factory{
    private Factory(){} //工厂没有实例化的意义，所以构造方法私有化
    public static IMessage1 getInstance(String className){
        if("netmessage1".equalsIgnoreCase(className)){
            return new NetMessage1();
        }else if("cloudmessage".equalsIgnoreCase(className)){
            return new CloudMessage();
        }
        return null;
    }
}
public class TraditionalFactory {
    public static void main(String[] args) {
        IMessage1 msg = Factory.getInstance("netmessage1");
        msg.send();
    }
}
