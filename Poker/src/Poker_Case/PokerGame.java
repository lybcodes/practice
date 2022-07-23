package Poker_Case;

interface IMessage {
    public void send(String str);
}
public class PokerGame {
    public static void main(String[] args) {
        IMessage msg = (str) -> {
            System.out.println("消息发送：" + str);
        };
        msg.send("www");
    }
}
