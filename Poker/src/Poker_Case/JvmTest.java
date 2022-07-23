package Poker_Case;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JvmTest {
//    public static void main(String[] args) {
//        byte[] allocation1, allocation2, allocation3;
//        allocation1 = new byte[13000 * 1024];
//        allocation2 = new byte[99000 * 1024];
//        allocation3 = new byte[990000 * 1024];
//    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        Iterator it = list.iterator();
        while(it.hasNext()){
            int i = (int) it.next();
            list.add(i);
        }
    }
}
