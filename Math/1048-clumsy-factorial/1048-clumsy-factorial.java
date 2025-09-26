class Solution {
    public int clumsy(int n) {
        char operation[] = {'*', '/', '+', '-'};
        int current_operation = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int current_res = n;
        for (int i = n - 1; i >= 1; i--) {
            if (operation[current_operation] == '*') current_res *= i;
            else if (operation[current_operation] == '/') current_res /= i;
            else if (operation[current_operation] == '+') {
                if (res.size() > 0) current_res -= i;
                else current_res += i;
            }
            else {
                res.add(current_res);
                current_res = i;
            }
            current_operation++;
            current_operation %= 4;
        }
        res.add(current_res);
        if (res.size() == 0) return current_res;
        int ans = res.get(0);
        for (int i = 1; i < res.size(); i++) ans -= res.get(i);
        return ans;
    }
}