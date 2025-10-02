class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            String current = words[i];
            if(isvowel(current.charAt(0)) && isvowel(current.charAt(current.length() - 1))) arr[i] = 1;
            else arr[i] = 0;
        }
        int sum = 0;
        int pre[] = new int[n];
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            pre[i] = sum;
        }
        int res[] = new int[queries.length];
        int k = 0;
        for(int current[] : queries) {
            int l = current[0], r = current[1];
            if(l == 0) res[k++] = pre[r];
            else res[k++] = pre[r] - pre[l - 1];
        }
        return res;
    }
    private boolean isvowel(char current) {
        if ((current == 'a') || (current == 'e') || (current == 'i' ) || (current == 'o')  || (current == 'u')) return true;
        return false;
    }
}