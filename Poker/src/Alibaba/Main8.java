//package Alibaba;
//
//import java.util.*;
//
//public class Main8 {
//
//    public static void main(String[] args)  {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.r
//        LinkedList<Object> d = new LinkedList<>();
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-->0){
//            String s = sc.nextLine();
//            String[] sb = s.trim().split(" ");
//            String num = sb[0];
//            int k = Integer.parseInt(sb[sb.length - 1]);
//            int n = num.length();
//            Queue<Integer>[] pos = new Queue[10];
//            for (int i = 0; i < 10; ++i) {
//                pos[i] = new LinkedList<Integer>();
//            }
//            for (int i = 0; i < n; ++i) {
//                pos[num.charAt(i) - '0'].offer(i + 1);
//            }
//            StringBuffer ans = new StringBuffer();
//            BIT bit = new BIT(n);
//            for (int i = 1; i <= n; ++i) {
//                for (int j = 0; j < 10; ++j) {
//                    if (!pos[j].isEmpty()) {
//                        int behind = bit.query(pos[j].peek() + 1, n);
//                        int dist = pos[j].peek() + behind - i;
//                        if (dist <= k) {
//                            bit.update(pos[j].poll());
//                            ans.append(j);
//                            k -= dist;
//                            break;
//                        }
//                    }
//                }
//            }
//            System.out.println(ans.toString());
//        }
//
//    }
//
//    static class BIT {
//        int n;
//        int[] tree;
//
//        public BIT(int n) {
//            this.n = n;
//            this.tree = new int[n + 1];
//        }
//
//        public static int lowbit(int x) {
//            return x & (-x);
//        }
//
//        public void update(int x) {
//            while (x <= n) {
//                ++tree[x];
//                x += lowbit(x);
//            }
//        }
//
//        public int query(int x) {
//            int ans = 0;
//            while (x > 0) {
//                ans += tree[x];
//                x -= lowbit(x);
//            }
//            return ans;
//        }
//
//        public int query(int x, int y) {
//            return query(y) - query(x - 1);
//        }
//
//
//    }
//}
