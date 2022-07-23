package ProxyDesign;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage1{    //业务接口
    public void send(); //业务方法
}
class MessageReal1 implements IMessage1{ //业务接口真实实现
    @Override
    public void send() {
        System.out.println("【发送消息】");
    }
}
class MLDNProxy implements InvocationHandler{
    private Object target; //接收真实业务对象

    /**
     * 进行真实业务对象与代理业务对象之间的绑定处理
     * @param target 真实业务对象
     * @return       返回Proxy生成的代理对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //在发送消息前后可能有一些处理，比如connect和close
    public boolean connect(){
        System.out.println("【消息代理】进行消息发送通道的连接");
        return true;
    }
    public void close(){
        System.out.println("【消息代理】关闭消息通道");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*****【执行方法】" + method);
        Object returnData = null;
        if(this.connect()){
            returnData = method.invoke(this.target, args);
            this.close();
        }
        return returnData;
    }
}

public class DynamicProxy {
    public static void main(String[] args) {
        IMessage1 msg = (IMessage1) new MLDNProxy().bind(new MessageReal1());
        msg.send();
    }
}
