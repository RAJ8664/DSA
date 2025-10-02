class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int freq[] = new int[26];
        for (int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 0 && freq[i] != 0) even.add(freq[i]);
            else odd.add(freq[i]);
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < odd.size(); i++) {
            for (int j = 0; j < even.size(); j++) {
                maxi = Math.max(maxi, odd.get(i) - even.get(j));
            }
        }
        return maxi;
    }
}