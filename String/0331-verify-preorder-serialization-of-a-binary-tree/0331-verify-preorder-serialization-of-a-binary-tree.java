class Solution {
    public boolean isValidSerialization(String preorder) {
        int count = 1;
        String nodes[] = preorder.split(",");
        for (String temp : nodes) {
            if (count <= 0) return false;
            if (temp.equals("#")) count--;
            else count++;
        }
        return count == 0;
    }
}