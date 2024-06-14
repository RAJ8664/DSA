package string_algo;
import java.util.ArrayList;
public class Template {
    public static void main(String[] args) {

    }

    //Get the Largest PalindromicPrefix of a string;
    static String getLargestPalindromicPrefix(String s) {
        //use --> getLargestPalindromicPrefix(s + "?" + reverse(s));
        int n = s.length();
        int[] LPS = new int[n];
        int j = 0, i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j+1;
                j++; i++;
            } else {
                if (j == 0) {
                    LPS[i] = 0; i++;
                }
                else j = LPS[j-1];
            }
        }
        int len = LPS[n-1];
        if (len > 0) return s.substring(0, len);
        else return "";
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

    //length of longest proper suffix and prefixes that match with each other;
    static void FILL_LPS (String s, int LPS[]) {
        LPS[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int j = LPS[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = LPS[j - 1];
            if (s.charAt(i) == s.charAt(j))  LPS[i] = j + 1;
            else LPS[i] = 0;
        }
    }

    //counts number of occurence of substring of length i which is a prefix of s;
    static int[] count(String s) {
        int n = s.length();
        int LPS[] = new int[n];
        FILL_LPS(s, LPS);
        int[] occ = new int[n + 1];
        for (int i = 0; i < n; i++) occ[LPS[i]]++;
        for (int i = n - 1; i > 0; i--) occ[LPS[i - 1]] += occ[i];
        for (int i = 0; i <= n; i++) occ[i]++;
        return occ;
    }
}
