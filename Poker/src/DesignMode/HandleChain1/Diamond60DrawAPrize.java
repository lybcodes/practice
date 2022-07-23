package DesignMode.HandleChain1;

public class Diamond60DrawAPrize implements Handler{
    private Handler handler;//存放当前处理者的后继Handler接口变量


    @Override
    public void handleRequest(int number) {
        if(number == 60){ //60钻石抽一次
            String random = "";
            String[] doc = {"白起", "夏侯惇", "甄姬", "金币288","小喇叭5","铭文碎片1600", "铭文碎片400","铭文碎片100", "铭文碎片25", "爱心气球（3日）", "亲密玫瑰","钻石48","龙域领主体验卡"};
            int index = (int)(Math.random() * doc.length); //随机选一个
            random = doc[index];
            System.out.println(random);
        }else{
            handler.handleRequest(number); //将请求传给下一个处理者
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
