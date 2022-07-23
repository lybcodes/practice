package ProxyDesign;

/**
 * 代理设计模式的核心是有真实业务实现类与代理业务实现类，
 * 并且代理类要完成比真实业务更多的处理操作。
 * 所有的代理设计模式如果按照设计要求来讲，必须是基于接口的设计，也就是说需要首先定义出核心接口的组成。
 * 下面模拟一个消息发送的代理操作结构。
 */
interface IMessage{ //传统（静态）代理设计必须有接口
    public void send(); //业务方法
}
class MessageReal implements IMessage{
    @Override
    public void send() {
        System.out.println("【发送消息】");
    }
}
class MessageProxy implements IMessage{ //代理类
    private IMessage message; //代理对象，一定是业务接口实例
    public MessageProxy(IMessage message){
        this.message = message;
    }
    @Override
    public void send() {
        if(this.connect()){
            this.message.send();//发送消息
            this.close();
        }
    }
    //在发送消息前后可能有一些处理，比如connect和close
    public boolean connect(){
        System.out.println("【消息代理】进行消息发送通道的连接");
        return true;
    }
    public void close(){
        System.out.println("【消息代理】关闭消息通道");
    }
}
public class StaticProxy {
    public static void main(String[] args) {
        IMessage msg = new MessageProxy(new MessageReal());
        msg.send();
    }
}
