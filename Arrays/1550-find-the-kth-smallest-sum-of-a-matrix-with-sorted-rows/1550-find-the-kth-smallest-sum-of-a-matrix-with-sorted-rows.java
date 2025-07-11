import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        List<Integer> curr = new ArrayList<>();
        for (int val : mat[0])
            curr.add(val);
        for (int i = 1; i < n; i++)
            curr = mergeKSmallest(curr, mat[i], k);
        return curr.get(k - 1);
    }

    private ArrayList<Integer> mergeKSmallest(List<Integer> a, int[] b, int k) {
        int m = a.size(), n = b.length;
        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        Set<String> visited = new HashSet<>();

        pq.offer(new int[] {a.get(0) + b[0], 0, 0});
        visited.add("0,0");

        while (!pq.isEmpty() && res.size() < k) {
            int[] top = pq.poll();
            int sum = top[0], i = top[1], j = top[2];
            res.add(sum);

            if (i + 1 < m && visited.add((i + 1) + "," + j)) {
                pq.offer(new int[] {a.get(i + 1) + b[j], i + 1, j});
            }
            if (j + 1 < n && visited.add(i + "," + (j + 1))) {
                pq.offer(new int[] {a.get(i) + b[j + 1], i, j + 1});
            }
        }

        return res;
    }
}