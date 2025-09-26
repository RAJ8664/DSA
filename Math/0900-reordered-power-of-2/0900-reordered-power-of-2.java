class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);
        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf((int)(1 << i)).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2)) return true;
        }
        return false;
    }
}