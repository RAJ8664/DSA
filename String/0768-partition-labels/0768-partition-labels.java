class Solution {
    public  List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int first[] = new int[30];
        int last[] = new int[30];
        Arrays.fill(first, -1); Arrays.fill(last, -1);
        for(int i = 0; i < n; i++) {
            if(first[s.charAt(i) - 'a'] == -1) first[s.charAt(i) - 'a'] = i;
            else last[s.charAt(i) - 'a'] = i;
        }
        for(int i = n - 1; i >= 0; i--) {
            if(last[s.charAt(i) - 'a'] == -1) last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        while(true) {
            int j = last[s.charAt(start) - 'a'];
            int lastj = start;
            while(start < j) {
                start++;
                j = Math.max(j , last[s.charAt(start) - 'a']);
            }
            res.add(j - lastj + 1);
            start = j + 1;
            if(start >= n) break;
        }
        return res;
    }
}