class Solution {
public:
    int minimumDeletions(string word, int k) {
        vector<int> freq(26, 0);
        for (char c : word) freq[c - 'a']++;
        int res = word.size();
        for (int j = 0; j < 26; j++) {
            int mn = freq[j], cnt = 0;
            for (int i : freq) {
                if (i > mn + k) 
                    cnt += i - (mn + k);
                else if (i < mn) 
                    cnt += i;
            }
            res = min(res, cnt);
        }
        return res;
    }
};