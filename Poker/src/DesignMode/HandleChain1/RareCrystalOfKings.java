package DesignMode.HandleChain1;

public class RareCrystalOfKings implements Handler{
    private Handler handler;


    @Override
    public void handleRequest(int number) {
        if(number == 201){
            System.out.println("稀有水晶");
        }else{
            handler.handleRequest(number);
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
