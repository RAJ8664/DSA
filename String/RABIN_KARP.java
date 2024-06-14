package string_algo;

import java.util.ArrayList;
import java.util.Scanner;

public class RABIN_KARP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        char txt[] = s.toCharArray();
        char pat[] = t.toCharArray();
        ArrayList<Integer> res = Rabin_Karp(pat, txt);
        System.out.println(res);
    }

    public static ArrayList<Integer> Rabin_Karp(char pat[], char txt[]){
        int q = Integer.MAX_VALUE;
        int M = pat.length;
        int N = txt.length;
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        int d = 256;

        ArrayList<Integer> res = new ArrayList<>();
        if(txt.length < pat.length) {
            res.add(-1);
            return res;
        }

        for (i = 0; i < M - 1; i++) h = (h * d) % q;
        for (i = 0; i < M; i++) {
            p = (d * p + pat[i]) % q;
            t = (d * t + txt[i]) % q;
        }

        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt[i + j] != pat[j]) break;
                }
                if (j == M) res.add(i);
            }
            if (i < N - M) {
                t = (d * (t - txt[i] * h) + txt[i + M]) % q;
                if (t < 0) t += q;
            }
        }

        if(res.size() == 0) res.add(-1);
        return res;
    }

}
