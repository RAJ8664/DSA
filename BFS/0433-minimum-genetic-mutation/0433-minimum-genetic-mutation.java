class Solution {
    static class Pair {
        String s;
        int count;
        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
        @Override
        public String toString() {
            return "(" + s + " " + count + ")";
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair current = (Pair)(obj);
            return current.s == s && current.count == count;
        }
        @Override
        public int hashCode() {
            return Objects.hash(s, count);
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.length() != endGene.length()) return -1;
        HashSet<String> set = new HashSet<>();
        for (String x : bank) set.add(x);
        if (!set.contains(endGene)) return -1;
        HashSet<String> vis = new HashSet<>();
        vis.add(startGene);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startGene, 0));
        int mini = Integer.MAX_VALUE;
        while (q.size() > 0) {
            Pair current = q.poll();
            if (vis.contains(current)) continue;
            if (current.s.equals(endGene)) {
                mini = Math.min(mini, current.count);
                continue;
            }
            char new_current[] = current.s.toCharArray();
            String temp = "ACGT";
            for (int i = 0; i < current.s.length(); i++) {
                char c = current.s.charAt(i);
                for (int j = 0; j < temp.length(); j++) {
                    new_current[i] = temp.charAt(j);
                    String store = "";
                    for (int x = 0; x < new_current.length; x++) store += new_current[x];
                    if (set.contains(store)) {
                        if (!vis.contains(store)) q.offer(new Pair(store, current.count + 1));
                        vis.add(store);
                    }
                    new_current[i] = c;
                }
            }
        }
        if (mini == Integer.MAX_VALUE) return -1;
        return mini;
    }
}