class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        int vis[] = new int[n + 1];
        vis[id] = 1;
        ArrayList<Integer> q = new ArrayList<>();
        q.add(id);
        for (int i = 0; i < level; i++) {
            ArrayList<Integer> current_q = new ArrayList<>();
            for (int u : q) {
                for (int v : friends[u]) {
                    if (vis[v] == 0) {
                        vis[v] = 1;
                        current_q.add(v);
                    }
                }
            }
            q = current_q;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int p : q) {
            for (String v : watchedVideos.get(p)) map.put(v, map.getOrDefault(v, 0) + 1);
        }
        List<String> res = new ArrayList<>(map.keySet());
        res.sort((a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);
            if (fa != fb) return fa - fb;
            return a.compareTo(b);
        });
        return res;
    }
}