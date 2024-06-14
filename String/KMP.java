package string_algo;

import java.util.ArrayList;

public class KMP {
    //Find all the indexes where pattern string exist in text string;
    public static void main(String[] args) {

    }

    static ArrayList<Integer> KMP(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        ArrayList<Integer> res = new ArrayList<>();
        int lps[] = new int[M];
        int j = 0;
        FILL_LPS(pat, lps);
        int i = 0;
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                res.add(i - j);
                j = lps[j - 1];
            }
            else if (i < N
                    && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return res;
    }

    static void FILL_LPS (String s, int LPS[]) {
        LPS[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int j = LPS[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = LPS[j - 1];
            if (s.charAt(i) == s.charAt(j))  LPS[i] = j + 1;
            else LPS[i] = 0;
        }
    }
}
