class Solution {
    static class custom_sort implements Comparator<String> {
        @Override
        public int compare(String first, String second) {
            String a = first + second;
            String b = second + first;
            return b.compareTo(a);
        }
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        ArrayList<String> res = new ArrayList<>();
        for (int ele : nums) res.add(String.valueOf(ele));
        Collections.sort(res, new custom_sort());
        if (res.size() > 0 && res.get(0).equals("0")) return "0";
        String ans = "";
        for (String temp : res) ans += temp;
        return ans;
    }
}