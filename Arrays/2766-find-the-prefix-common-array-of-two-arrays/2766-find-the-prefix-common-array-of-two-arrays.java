class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            set1.add(A[i]); set2.add(B[i]);
            int count = 0;
            for (int j = 1; j <= 50; j++) if (set1.contains(j) && set2.contains(j)) count++;
            res[i] = count;
        }   
        return res;
    }
}