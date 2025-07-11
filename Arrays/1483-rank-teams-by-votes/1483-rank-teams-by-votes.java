class Solution {
    static class Pair {
        char ch;
        int votes;
        int freq[] = new int[30];
        public Pair(char ch, int votes, int freq[]) {
            this.ch = ch;
            this.votes = votes;
            this.freq = freq;
        }
    }
    static class custom_sort implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int temp1[] = new int[30];
            int temp2[] = new int[30];
            temp1 = first.freq;
            temp2 = second.freq;
            for (int i = 0; i < 30; i++) {
                if (temp1[i] == temp2[i]) continue;
                if (temp1[i] > temp2[i]) return -1;
                return 1;
            }
            return Integer.compare(first.ch, second.ch);
        }
    }
    public String rankTeams(String[] votes) {
        int n = votes.length;
        HashSet<Character> set = new HashSet<>();
        int score[] = new int[30];
        int freq[][] = new int[30][30];
        for (int i = 0; i < n; i++) {
            String current = votes[i];
            int it = 1;
            for (int j = current.length() - 1; j >= 0; j--) {
                freq[current.charAt(j) - 'A'][j + 1]++;
                score[current.charAt(j) - 'A'] += it;
                it++;
                set.add(current.charAt(j));
            }
        }
        ArrayList<Pair> res = new ArrayList<>();
        for (Character x : set) res.add(new Pair(x, score[x - 'A'], freq[x - 'A']));
        Collections.sort(res, new custom_sort());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < res.size(); i++) ans.append(res.get(i).ch);
        return ans.toString();
    }
}