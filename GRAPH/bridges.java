import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static Reader sc = new Reader();
    //static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    //static Debugger debug = new Debugger();
    //static Debug debug = new Debug();
    static int mod = (int) (1e9 + 7);
    //static int mod = 998244353;
    //static long hash_mod = 92233720368547753L;
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<Pair> bridges;
    static int timer = 0;

    /***Code Starts From Here***/
    public static void main(String[] args) throws IOException {
        //int t = 1;
        int t = sc.nextInt();
        while (t-- > 0) {
            Attack();
        }
        sc.close();
        out.flush();
    }

    public static void Attack() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        adj = new ArrayList<>();
        Graph g = new Graph(n + 1);
        for(int i = 0; i <= n + 1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
            g.addEdge(u , v);
        }
        
        bridges = new ArrayList<>();
        int time[] = new int[n + 1];
        int outt[] = new int[n + 1];
        int vis[] = new int[n + 1];
        dfs(1, -1, time, vis, outt);
    
        g.bridge();

        long total = n * 1L *(n - 1) / 2;
        long mini = total;
        for(Pair curr : bridges) {
            int u = curr.u;
            int v = curr.v;
            long l = 0L;
            long r  = 0L;
            if(time[v] > time[u]) {
                l = (outt[v] - time[v] + 1) / 2;
                r = n - l;
            }
            else {
                l = (outt[u] - time[u] + 1) / 2;
                r = n - l;
            }
            long to_sub = (l * 1L * (l - 1) / 2) + (r * 1L *(r - 1) / 2);
            mini = Math.min(mini, Math.min(total , to_sub));
        }
        out.println(mini); 
    }
        
    static void dfs(int u , int par, int time[], int vis[], int outt[]) {
        vis[u] = 1;
        time[u] = timer++;
        for(int v : adj.get(u)) {
            if(vis[v] == 0) {
                dfs(v, u , time, vis, outt);
            }
        }
        outt[u] = timer;
        timer++;
    }
    
    static class Graph{ 
        private int V; 
        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;
        @SuppressWarnings("unchecked")Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)  adj[i] = new LinkedList();
        }
    
        void addEdge(int v, int w) {
            adj[v].add(w);  
            adj[w].add(v);  
        }

        void bridgeUtil(int u, boolean visited[], int disc[],int low[], int parent[]) {
            visited[u] = true;
            disc[u] = low[u] = ++time;
            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext()) {
                int v = i.next();  
                if(!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);
    
                    low[u]  = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]) bridges.add(new Pair(u , v));
                        
                }
                else if (v != parent[u]) low[u]  = Math.min(low[u], disc[v]);
                    
            }
        }
    
        void bridge() {
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];

            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
                visited[i] = false;
            }
            for (int i = 0; i < V; i++)
                if (visited[i] == false)  bridgeUtil(i, visited, disc, low, parent);        
        }
    }
    
    static class Pair {
        int u;
        int v;
        public Pair(int u , int v) {
            this.u = u;
            this.v = v;
        }
    }
  

    /**Code Ends Here (No Need To Scroll Down)**/
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {ret = ret * 10 + c - '0';}
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {ret = ret * 10L + c - '0';}
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {ret = ret * 10 + c - '0';}
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
            if (neg) return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
        public char[] next() throws IOException {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) <= ' ') ;
            do {sb.append((char) c);}
            while ((c = read()) > ' ');
            return sb.toString().toCharArray();
        }
        public int nextInt2() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {ret = ret * 10 + c - '0';}
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }

    static long fast_pow(long a, long p, long mod) {
        long res = 1;
        while (p > 0) {
            if (p % 2 == 0) {
                a = ((a % mod) * (a % mod)) % mod;
                p /= 2;
            }
            else {
                res = ((res % mod) * (a % mod)) % mod;
                p--;
            }
        }
        return res;
    }
    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }

    //Factorials and Inverse Factorials;
    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];
    static boolean[] isPrime;
    static int[] smallestFactorOf;
    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }
    static long nCk(int n, int k) {
        //use precompFacts first;
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    //Prime Generator;
    static void Generate_Primes(int upto) {
        // Sieve of Eratosthenes:
        isPrime = new boolean[upto + 1];
        smallestFactorOf = new int[upto + 1];
        Arrays.fill(smallestFactorOf, 1);
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;
        for (long i = 2; i < upto + 1; i++) {
            if (isPrime[(int) i]) {
                smallestFactorOf[(int) i] = (int) i;
                // Mark all the multiples greater than or equal
                // to the square of i to be false.
                for (long j = i; j * i < upto + 1; j++) {
                    if (isPrime[(int) j * (int) i]) {
                        isPrime[(int) j * (int) i] = false;
                        smallestFactorOf[(int) j * (int) i] = (int) i;
                    }
                }
            }
        }
    }

    static long modinv(long x) {return fast_pow(x, mod - 2, mod);}
    static long add(long a, long b) {a += b; if (a >= mod) a-= mod; return a;}
    static long mul(long a, long b) {return (long) ((long) ((a % mod) * 1L * (b % mod)) % mod);}
    static long Div(long x, long y) {return mul(x, modinv(y));}
    static long mod(long a, long b) {long r = a % b;return r < 0 ? r + b : r;}
    static long sub(long x, long y) {long z = x - y; if (z < 0)  z += mod;return z;}
    static long GCD(long x, long y) {if(y == 0) return x;return GCD(y, x % y);}
    static long LCM(long a, long b) {return (a / GCD(a, b)) * b;}


    public static void sort(int[] arr) {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<>();
        for (Integer x : arr) ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);
    }
    public static void sort(long[] arr) {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Long> ls = new ArrayList<>();
        for (Long x : arr) ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);
    }

    static class Unique_Pair {
        int first;
        int second;
        Unique_Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Unique_Pair pair = (Unique_Pair) o;
            return first == pair.first && second == pair.second;
        }
        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    static class MultiSet<T> {
        TreeMap<T, Integer> frequency;
        TreeSet<T> set;
        int size;
        public MultiSet() {
            set = new TreeSet<>();
            frequency = new TreeMap<>();
            size = 0;
        }
        public MultiSet(Comparator<T> cmp) {
            set = new TreeSet<>(cmp);
            frequency = new TreeMap<>(cmp);
            size = 0;
        }
        public void add(T elem) {
            if (frequency.get(elem) == null || frequency.get(elem) == 0) {
                frequency.put(elem, 0);
                set.add(elem);
            }
            frequency.put(elem, frequency.get(elem) + 1);
            size++;
        }
        public void remove(T elem) {
            if (!set.contains(elem)) return;
            frequency.put(elem, frequency.get(elem) - 1);
            if (frequency.get(elem) == 0) set.remove(elem);
            size--;
        }
        public boolean contains(T elem) {
            return set.contains(elem);
        }
    }

    @SuppressWarnings("serial")
    static class CountMap<T> extends TreeMap<T, Integer>{
        CountMap() {}
        CountMap(T[] arr) {this.putCM(arr);}
        public Integer putCM(T key) {
            if (super.containsKey(key)) return super.put(key, super.get(key) + 1);
            else return super.put(key, 1);
        }
        public Integer removeCM(T key) {
            Integer count = super.get(key);
            if (count == null) return -1;
            if (count == 1) return super.remove(key);
            else  return super.put(key, super.get(key) - 1);
        }
        public Integer getCM(T key) {
            Integer count = super.get(key);
            if (count == null) return 0;
            return count;
        }
        public void putCM(T[] arr) {
            for (T ele : arr) this.putCM(ele);
        }
    }

    static class DSU {
        int[] Parent, Group_Size;
        int Number_of_Nodes, Number_of_Groups, Max_Group;
        public DSU(int Number_of_Nodes) {
            this.Number_of_Nodes = Number_of_Nodes;
            Parent = new int[Number_of_Nodes + 1];
            Group_Size = new int[Number_of_Nodes + 1];
            Number_of_Groups = Number_of_Nodes;
            Max_Group = 1;
            for (int i = 1; i <= Number_of_Nodes; i++) {
                Parent[i] = i;
                Group_Size[i] = 1;
            }
        }
        public int Leader(int x) {
            return Parent[x] = (Parent[x] == x ? x : Leader(Parent[x]));
        }
        public boolean Is_same_Group(int x, int y) {
            return Leader(x) == Leader(y);
        }
        public void unite(int x, int y) {
            int leader1 = Leader(x);
            int leader2 = Leader(y);
            if (leader1 != leader2) {
                Number_of_Groups--;
                if (Group_Size[leader1] < Group_Size[leader2]) {
                    int temp = leader1;
                    leader1 = leader2;
                    leader2 = temp;
                }
                Parent[leader2] = leader1;
                Group_Size[leader1] += Group_Size[leader2];
                Max_Group = Math.max(Max_Group, Group_Size[leader1]);
            }
        }
        public int getSize(int x) {
            return Group_Size[Leader(x)];
        }
    }

    static class Hashing {
        long[] hash1, hash2;
        long[] inv1, inv2;
        int n;
        static int multiplier = 43;
        static final Random rnd = new Random();
        static final int mod1 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int mod2 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int invMultiplier1 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod1)).intValue();
        static final int invMultiplier2 = BigInteger.valueOf(multiplier).modInverse(BigInteger.valueOf(mod2)).intValue();
        public Hashing(String s) {
            n = s.length();
            hash1 = new long[n + 1];hash2 = new long[n + 1];
            inv1 = new long[n + 1];inv2 = new long[n + 1];
            inv1[0] = 1;inv2[0] = 1;
            long p1 = 1;long p2 = 1;
            for (int i = 0; i < n; i++) {
                hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % mod1;
                p1 = p1 * multiplier % mod1;
                inv1[i + 1] = inv1[i] * invMultiplier1 % mod1;
                hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % mod2;
                p2 = p2 * multiplier % mod2;
                inv2[i + 1] = inv2[i] * invMultiplier2 % mod2;
            }
        }
        public long getHash(int i, int len) {
            return (((hash1[i + len] - hash1[i] + mod1) * inv1[i] % mod1) << 32) + (hash2[i + len] - hash2[i] + mod2) * inv2[i] % mod2;

        }
        public long getHashbounds(int x, int y) {
            return getHash(x,y-x+1);
        }
    }

    static class Trie {
        class Node {
            Node[] children;
            boolean isEnd;
            Node() {
                children = new Node[26];
            }
        }
        Node root;
        Trie() {
            root = new Node();
        }
        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }
        public boolean find(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null)  return false;
                curr = curr.children[ch - 'a'];
            }
            return curr.isEnd;
        }
    }
}
