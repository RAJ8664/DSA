class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>(); 
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<>(); 
        for (int i = 0 ; i < n; i++) {
            prerequisitesMap.put(i, new HashSet<>());
            adj.put(i, new HashSet<>());
        }
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();            
            Set<Integer> set = adj.get(node);
            for (int next : set) {
                prerequisitesMap.get(next).add(node);
                prerequisitesMap.get(next).addAll(prerequisitesMap.get(node));
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] pair : queries) {
            Set<Integer> set = prerequisitesMap.get(pair[1]);
            if (set.contains(pair[0])) res.add(true);
            else res.add(false);
        }
        return res;
    }
}