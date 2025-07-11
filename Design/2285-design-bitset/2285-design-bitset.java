
import java.util.HashSet;

class Bitset {
    private int n;
    private HashSet<Integer> set;
    private HashSet<Integer> unSet;
    public Bitset(int size) {
        set = new HashSet<>();
        unSet = new HashSet<>();
        this.n = size;
        for (int i = 0; i < n; i++)
            unSet.add(i);
    }

    public void fix(int idx) {
        if (unSet.contains(idx))
            unSet.remove(idx);
        if (!set.contains(idx))
            set.add(idx);
    }

    public void unfix(int idx) {
        if (set.contains(idx))
            set.remove(idx);
        if (!unSet.contains(idx))
            unSet.add(idx);
    }

    public void flip() {
        HashSet<Integer> temp = set;
        set = unSet;
        unSet = temp;
    }

    public boolean all() {
        return set.size() == n;
    }

    public boolean one() {
        return set.size() >= 1;
    }

    public int count() {
        return set.size();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (set.contains(i))
                res.append("1");
            else
                res.append("0");
        }
        return res.toString();
    }
}

/**
    Your Bitset object will be instantiated and called as such:
    Bitset obj = new Bitset(size);
    obj.fix(idx);
    obj.unfix(idx);
    obj.flip();
    boolean param_4 = obj.all();
    boolean param_5 = obj.one();
    int param_6 = obj.count();
    String param_7 = obj.toString();
*/