package DesignMode.HandleChain1;

public class Application {
    private Handler diamond60, diamond270, rareDiamond;//责任链上的对象

    public void createChain(){ //建立责任链
        diamond60 = new Diamond60DrawAPrize();
        diamond270 = new Diamond270DrawFivePrizes();
        rareDiamond = new RareCrystalOfKings();
        diamond60.setNextHandler(diamond270);
        diamond270.setNextHandler(rareDiamond);
    }

    public void responseClient(int number){ //响应用户的请求
        diamond60.handleRequest(number);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.createChain();
        application.responseClient(60);
        System.out.println("--------------------");
        application.responseClient(270);
        System.out.println("--------------------");
        application.responseClient(201);
        System.out.println("--------------------");
    }
}
