package DesignMode.HandleChain1;


/**
 * 职责链模式的应用一：王者荣耀夺宝商店
 */
public interface Handler {
    public abstract void handleRequest(int number);

    public abstract void setNextHandler(Handler handler);
}
