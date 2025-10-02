class TrieNode {
    public int freq;
    public TrieNode[] children;

    public TrieNode() {
        freq = 0;
        children = new TrieNode[26];
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        TrieNode root = new TrieNode();
        for(String w: words) {
            TrieNode curr = root;
            for(char c: w.toCharArray()) {
                if(curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
                curr.freq++;
            }
        }
        for(int i = 0; i < n; i++) {
            TrieNode curr = root;
            for(char c: words[i].toCharArray()) {
                curr = curr.children[c - 'a'];
                ans[i] += curr.freq;
            }
        }
        return ans;
    }
}