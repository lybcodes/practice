package DesignMode.HandleChain1;

public class Diamond270DrawFivePrizes implements Handler{
    private Handler handler;

    @Override
    public void handleRequest(int number) {
        if (number == 270){
            String random, random1, random2, random3, random4 = "";
            String[] doc = {"白起", "夏侯惇", "甄姬", "金币288","小喇叭5","铭文碎片1600", "铭文碎片400","铭文碎片100", "铭文碎片25", "爱心气球（3日）", "亲密玫瑰","钻石48","龙域领主体验卡"};
            int index = (int)(Math.random() * doc.length);
            random = doc[index];
            System.out.println(random);
            int index1 = (int)(Math.random() * doc.length);
            random1 = doc[index1];
            System.out.println(random1);
            int index2 = (int)(Math.random() * doc.length);
            random2 = doc[index2];
            System.out.println(random2);
            int index3 = (int)(Math.random() * doc.length);
            random3 = doc[index3];
            System.out.println(random3);
            int index4 = (int)(Math.random() * doc.length);
            random4 = doc[index4];
            System.out.println(random4);
        }else{
            handler.handleRequest(number);
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
