package ProxyDesign;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

class Message{
    public void send(){
        System.out.println("【消息发送】");
    }
}
class CGlibProxy implements MethodInterceptor { //拦截器配置
    private Object target; //保存真实主体对象
    public CGlibProxy(Object target){
        this.target = target;
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnData = null;
        if(this.connect()){
            returnData = method.invoke(this.target, args);
            this.close();
        }
        return returnData;
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
public class DynamicProxyCGlib {
    public static void main(String[] args) {
        //通过一系列CGlib处理创建代理对象
        Message realObject = new Message(); //真实主体对象
        Enhancer enhancer = new Enhancer(); //负责代理操作的程序类
        enhancer.setSuperclass(realObject.getClass()); //假定一个父类
        enhancer.setCallback(new CGlibProxy(realObject)); //设置代理类
        Message proxyObject = (Message) enhancer.create(); //创建代理对象
        proxyObject.send();
    }
}
