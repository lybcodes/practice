package PDD;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.printf("%.0f\n", slice(m + 1, n));
        }
    }

    public static double slice(int m, int n) {
        if (n == 1) {
            return m;
        }
        double temp = slice(m, n / 2);
        return ((n % 2 == 0 ? 1 : m) * temp * temp) % 1000000007;
    }
}
