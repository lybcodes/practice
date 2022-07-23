package Alibaba;

public class Main6 {

    public static void main(String[] args) {
        int[] A = {50000, 25000, 90000, 99999, 39999, 78989};

        int n = A.length;
        int position1 = 0;
        int min = 0;

        for(int i = 0; i < n; i++){
            if(A[i] < A[min]){
                min = i;
            }
            position1 = min;
        }

        int ans = 200000;

        for(int i = 0; i < n; i++){
            if(Math.abs(position1 - i) > 1){
                int num = A[position1] + A[i];
                if(num < ans){
                    ans = num;
                }
            }
        }

        int t = 0;
        if(position1 != 0 && position1 != n-1){
            t = A[position1 - 1] + A[position1 + 1];
        }

        if(t < ans){
            System.out.println(t);
        }
        else{
            System.out.println(ans);
        }

    }
}
