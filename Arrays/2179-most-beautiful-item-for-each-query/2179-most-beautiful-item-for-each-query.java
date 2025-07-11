class Solution {
    static class Pair {
        int price;
        int beauty;
        public Pair(int price, int beauty) {
            this.price = price;
            this.beauty = beauty;
        }
        @Override
        public String toString() {
            return "(" + price + " " + beauty + ")";
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 = Integer.compare(first.price, second.price);
            return op1;
        }
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        ArrayList<Pair> res = new ArrayList<>();
        for (int currItem[] : items) {
            res.add(new Pair(currItem[0] , currItem[1]));
        }
        Collections.sort(res, new custom_sort());
        int maxBeautyPref[] = new int[n + 1];
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < res.size(); i++) {
            maxi = Math.max(maxi, res.get(i).beauty);
            maxBeautyPref[i] = maxi;
        }
        int answer[] = new int[queries.length];
        int k = 0;
        for (int current_query : queries) {
            answer[k++] = binary_search(res, current_query, maxBeautyPref);
        }
        return answer;
    }

    static int binary_search(ArrayList<Pair> res, int current_price, int maxBeautyPref[]) {
        int n = res.size();
        int maxi = 0;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (res.get(mid).price > current_price) high = mid - 1;
            else if (res.get(mid).price <= current_price) {
                maxi = Math.max(maxi, maxBeautyPref[mid]);
                low = mid + 1;
            }
        }
        return maxi;
    }
}