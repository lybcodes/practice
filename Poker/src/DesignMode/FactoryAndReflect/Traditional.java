package DesignMode.FactoryAndReflect;

interface IMessage{
    public void send();
}
class NetMessage implements IMessage{
    @Override
    public void send() {
        System.out.println("【网络消息发送】");
    }
}

public class Traditional {
    public static void main(String[] args) {
        IMessage msg = new NetMessage();//直接实例化一定会有耦合问题
    }
}
