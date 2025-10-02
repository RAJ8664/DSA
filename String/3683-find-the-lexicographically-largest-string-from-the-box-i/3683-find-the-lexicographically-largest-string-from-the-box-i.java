import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private ArrayList<String> ans;

    public String answerString(String word, int numFriends) {
        int n = word.length();
        ans = new ArrayList<>();
        if (numFriends == 1)
            return word;
        int ind = -1;
        int count = 0;
        char ch = 'a';
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) > ch) {
                ch = word.charAt(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == ch)
                idx.add(i);
        }
        for (int ele : idx)
            solve(ele, word, numFriends);
        Collections.sort(ans);
        if (ans.size() == 0)
            return "";
        return ans.get(ans.size() - 1);
    }

    private void solve(int ind, String word, int numFriends) {
        int n = word.length();
        int count_prev = ind;
        StringBuilder res = new StringBuilder();
        if (count_prev >= numFriends) {
            for (int i = ind; i < n; i++)
                res.append(word.charAt(i));
            ans.add(res.toString());
        } else {
            int req = numFriends - count_prev - 1;
            for (int i = n - 1 - req; i >= ind; i--) {
                res.append(word.charAt(i));
            }
            ans.add(res.reverse().toString());
        }
    }
}