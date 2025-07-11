class Solution {
    static int mod = (int)(1e9 + 7);
    static long[] factorials = new long[5000];
    static long[] invFactorials = new long[5000];
    static class Tuple {
        int first, second,third;
        public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
        @Override
        public String toString() {
            return "(" + first + " " + second + " " + third + ")";
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tuple current = (Tuple)(obj);
            return current.first == first && current.second == second && current.third == third;
        }
        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }
    public int threeSumMulti(int[] arr, int target) {
        precompFacts();
        int n = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) map.put(ele, map.getOrDefault(ele, 0) + 1);
        HashSet<Tuple> set = new HashSet<>();
        HashSet<Tuple> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int req = target - arr[i];
            int low = i + 1, high = n - 1;
            while (low < high) {
                if (arr[low] + arr[high] == req) {
                    res.add(new Tuple(arr[i] , arr[low], arr[high]));
                    low++;
                    high--;
                } 
                else if (arr[low] + arr[high] < req) low++;
                else high--;
            }
        }
        long count = 0;
        for (Tuple current: res) {
            int first = current.first;
            int second = current.second;
            int third = current.third;
            if (first == second && second == third) {
                long current_count = Math.max(1, nCk(map.getOrDefault(first, 0), 3));
                count = add(count, current_count);
            }
            else if (first == second && second != third) {
                long current_count = map.getOrDefault(third, 0);
                current_count = mul(current_count, Math.max(1, nCk(map.getOrDefault(first, 0), 2)));
                count = add(count, current_count);
            }
            else if (second == third) {
                long current_count = map.getOrDefault(first, 0);
                current_count = mul(current_count, Math.max(1, nCk(map.getOrDefault(second, 0), 2)));
                count = add(count, current_count);
            }
            else {
                long current_count = map.getOrDefault(first, 0);
                current_count = mul(current_count, map.getOrDefault(second, 0));
                current_count = mul(current_count, map.getOrDefault(third, 0));
                count = add(count, current_count); 
            }
        }
        return (int)(count);
    }
    private static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--) invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }
    private static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }
    private static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    private static long mul(long a, long b) {return (long) ((long) ((a % mod) * 1L * (b % mod)) % mod);}
    private static long add(long a, long b) {a += b; if (a >= mod) a-= mod; return a;}
}
