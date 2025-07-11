class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int sum = 0, count = 0;
        for (int ele : skill) sum += ele;
        if (sum % (n / 2) != 0) return -1;
        long ans = 0;
        int req = sum / ( n / 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : skill) map.put(ele, map.getOrDefault(ele, 0) + 1);
        for (int i = 0; i < n; i++) {
            int current = skill[i];
            if (map.getOrDefault(current, 0) <= 0) continue;
            int current_req = req - current;
            if (current_req < 0) continue;
            if (map.getOrDefault(current_req , 0) > 0) {
                count++;
                map.put(current_req, map.getOrDefault(current_req , 0) - 1);
                map.put(current, map.getOrDefault(current, 0) - 1);
                ans += (current * current_req);
            }
        }
        if (count == n / 2) return ans;
        return -1;
    }
}