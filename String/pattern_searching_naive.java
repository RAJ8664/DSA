package string_algo;
import java.util.Scanner;

public class pattern_searching_naive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.next();
        String pat = sc.next();
        int res = solve(txt , pat);
        System.out.println(res);
    }

    static int solve(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        for(int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for(int j = 0; j < m; j++) {
                if(pat.charAt(j) != txt.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) return i;
        }
        return -1;
    }
}
