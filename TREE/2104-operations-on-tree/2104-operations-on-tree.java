import java.util.*;
class LockingTree {
    private ArrayList<ArrayList<Integer>> adj;
    private int par[];
    private int map[];
    public LockingTree(int[] parent) {
        int n = parent.length;
        par = new int[n + 1]; par[0] = -1;
        adj = new ArrayList<>();
        map = new int[n + 1];
        Arrays.fill(map, -1);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int p = par[i] = parent[i];
            adj.get(p).add(i);
        }
    }
    public boolean lock(int num, int user) {
        if (map[num] == -1) {
            map[num] = user;
            return true;
        }   
        return false;
    }
    public boolean unlock(int num, int user) {
        if (map[num] == user) {
            map[num] = -1;
            return true;
        }
        return false;
    }
    public boolean upgrade(int num, int user) {
        if (check(num, user)) {
            doUpgrade(num, user);
            return true;
        }
        return false;
    }
    private boolean check(int node, int user) {
        if (map[node] != -1) return false;
        int boolVal1[] = new int[1];
        int boolVal2[] = new int[1];
        checkDescendant(node, boolVal1);
        checkAncestor(node, boolVal2);
        return boolVal1[0] == 1 && boolVal2[0] == 1;
    }
    private void doUpgrade(int node, int user) {
        map[node] = user;
        unLockAll(node);
    }
    private void unLockAll(int node) {
        for (int v : adj.get(node)) {
            if (v != par[v]) {
                map[v] = -1;
                unLockAll(v);
            }
        }
    }
    private void checkDescendant(int node, int[] boolVal) {
        for (int v : adj.get(node)) {
            if (v != par[v]) {
                if (map[v] != -1) {
                    boolVal[0] = 1;
                    return;
                }
                checkDescendant(v, boolVal);
            }
        }
    }
    private void checkAncestor(int node, int[] boolVal) {
        node = par[node];
        boolVal[0] = 1;
        while (node != -1) {
            if (map[node] != -1) {
                boolVal[0] = 0;
                return;
            } 
            node = par[node];
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */