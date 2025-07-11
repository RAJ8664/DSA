import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;

class Solution {
    static class custom_sort implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return Integer.compare(second, first);
        }
    }
    public static long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new custom_sort());
        for (int ele : nums) pq.offer(ele);
        long sum = 0;
        while (k > 0) {
            sum += pq.peek();
            int ele = pq.poll();
            if (ele % 3 == 0) pq.offer(ele / 3);
            else pq.offer((ele / 3) + 1);
            k--;					
        }
        return sum;	
    }
}

public class Main {
    static Reader sc = new Reader();
    static PrintWriter out = new PrintWriter(System.out);
    static Debug dbg = new Debug();
    static int mod = (int) (1000000007); //998244353 1000000007;
    static long hash_mod = 92233720368547753L;
    static ArrayList<ArrayList<Integer>> adj;

    /***Code Starts From Here***/
    public static void main(String[] args) throws IOException {
        READING(); /*→→→[■□□□□□□□□□] →→→ [■■■■□□□□□□] →→→  [■■■■■■■□□□] →→→ [■■■■■■■■■□]*/ ERROR();
        //preprocess();
        int t = 1;
        //int t = sc.nextInt();
        while (t-->0) Attack();
        sc.close();
        out.flush();
    }

    public static void Attack() throws IOException {
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	int arr[] = new int[n];
    	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    	Solution sol = new Solution();
    	long res = sol.maxKelements(arr, k);
        out.println(res);
    }

    /**Code Ends Here (No Need To Scroll Down)**/
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        BufferedReader reader;
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
        public String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) <= ' ') ;
            do {sb.append((char) c);}
            while ((c = read()) > ' ');
            return sb.toString();
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
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
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
                // Mark all the muresiples greater than or equal
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

    static long Div(long x, long y) {return mul(x, modinv(y));}
    static long LCM(long a, long b) {return (a / GCD(a, b)) * b;}
    static long modinv(long x) {return fast_pow(x, mod - 2, mod);}
    static long add(long a, long b) {a += b; if (a >= mod) a-= mod; return a;}
    static long mod(long a, long b) {long r = a % b;return r < 0 ? r + b : r;}    
    static long GCD(long x, long y) {if(y == 0) return x;return GCD(y, x % y);}
    static long sub(long x, long y) {long z = x - y; if (z < 0)  z += mod;return z;}
    static long mul(long a, long b) {return (long) ((long) ((a % mod) * 1L * (b % mod)) % mod);}
    public static void READING(){if(System.getProperty("ONLINE_JUDGE") == null){try{sc = new Reader("input.txt");out = new PrintWriter("output.txt");}catch (Exception e){}}}
    public static void ERROR() {try {PrintStream fileOut = new PrintStream(new FileOutputStream("dbg.txt", false), true, "UTF-8");System.setErr(fileOut);} catch (FileNotFoundException | UnsupportedEncodingException e) {e.printStackTrace();}}

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
            Unique_Pair current = (Unique_Pair) (o);
            return first == current.first && second == current.second;
        }
        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
        @Override
        public String toString() {
            return "(" + first + " " + second + ")";
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
        static int muresiplier = 43;
        static final Random rnd = new Random();
        static final int mod1 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int mod2 = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();
        static final int invMuresiplier1 = BigInteger.valueOf(muresiplier).modInverse(BigInteger.valueOf(mod1)).intValue();
        static final int invMuresiplier2 = BigInteger.valueOf(muresiplier).modInverse(BigInteger.valueOf(mod2)).intValue();
        public Hashing(String s) {
            n = s.length();
            hash1 = new long[n + 1]; hash2 = new long[n + 1];
            inv1 = new long[n + 1]; inv2 = new long[n + 1];
            inv1[0] = 1; inv2[0] = 1;
            long p1 = 1; long p2 = 1;
            for (int i = 0; i < n; i++) {
                hash1[i + 1] = (hash1[i] + s.charAt(i) * p1) % mod1;
                p1 = p1 * muresiplier % mod1;
                inv1[i + 1] = inv1[i] * invMuresiplier1 % mod1;
                hash2[i + 1] = (hash2[i] + s.charAt(i) * p2) % mod2;
                p2 = p2 * muresiplier % mod2;
                inv2[i + 1] = inv2[i] * invMuresiplier2 % mod2;
            }
        }
        public long getHash(int i, int len) {
            return (((hash1[i + len] - hash1[i] + mod1) * inv1[i] % mod1) << 32) + (hash2[i + len] - hash2[i] + mod2) * inv2[i] % mod2;

        }
        public long getHashbounds(int x, int y) {
            return getHash(x, y - x + 1);
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
            if (frequency.get(elem) == 0) {
                set.remove(elem);
                frequency.remove(elem);
            }
            size--;
        }
        public boolean contains(T elem) {
            return set.contains(elem);
        }
        
        @Override
        public String toString() {
            String current = "(";
            for(T ele : set) {
                int freq = frequency.get(ele);
                for(int i = 0; i < freq; i++) {
                    if(current.length() == 1) current += ele;
                    else current += "," + ele;
                }
            }
            current += ")";
            return current;
        }
        
        //Returns the count of the specified element in this muresiset
        public int count(T element) {return frequency.getOrDefault(element, 0);}
        // Returns the total number of elements in the muresiset (including duplicates)
        public int size() {int size = 0; for(int count : frequency.values()) size += count; return size;}
        // Returns the smallest element in this muresiset greater than or equal to the given element, or null if there is no such element
        public T ceiling(T element) {return frequency.ceilingKey(element);}
        // Returns the greatest element in this muresiset less than or equal to the given element, or null if there is no such element
        public T floor(T element) {return frequency.floorKey(element);}
        // Returns the smallest element in this muresiset strictly greater than the given element, or null if there is no such element
        public T higher(T element) {return frequency.higherKey(element);}
        // Returns the greatest element in this muresiset strictly less than the given element, or null if there is no such element
        public T lower(T element) { return frequency.lowerKey(element);}
    }

    static class MultiTreeSet<E> { 
        TreeMap<E, Integer> freqTreeMap = new TreeMap<E, Integer>();
        int size;
        public MultiTreeSet() {}
        public MultiTreeSet(Collection<? extends E> c) {
            for (E element : c) add(element);
        }
        public int size() {return size;}
        public void add(E element) {
            Integer freq = freqTreeMap.get(element);
            if(freq==null) freqTreeMap.put(element, 1);
            else freqTreeMap.put(element,freq + 1);
            ++size;
        }
        public void remove(E element) {
            Integer freq = freqTreeMap.get(element);
            if(freq!=null) {
                if(freq == 1) freqTreeMap.remove(element);
                else freqTreeMap.put(element, freq-1);--size;
            }
        }
        public int get(E element) {
            Integer freq = freqTreeMap.get(element);
            if(freq == null) return 0;
            return freq;
        }
        public boolean contains(E element) {return get(element) > 0;}
        @Override 
        public String toString() {
            String current = "( ";
            for(E ele : freqTreeMap.keySet()){
                int freq = freqTreeMap.get(ele);
                for(int i = 0; i < freq; i++){
                    current += ele + " ";
                }
            }
            current += ")";
            return current;
        }
        public boolean isEmpty() {return size == 0;}
        public E first() {return freqTreeMap.firstKey();}
        public E last() {return freqTreeMap.lastKey();}
        public E ceiling(E element) {return freqTreeMap.ceilingKey(element);}
        public E floor(E element) {return freqTreeMap.floorKey(element);}
        public E higher(E element) {return freqTreeMap.higherKey(element);}
        public E lower(E element) {return freqTreeMap.lowerKey(element);}
    }
    
    static class Debug {
        public static boolean LOCAL = getLocal();
        public static boolean getLocal() {
            try {
                return System.getProperty("LOCAL") == null;
            }catch(SecurityException e) {
                return false;
            }
        }
        public static <T> String ts(T t) {
            if(t==null) {
                return "null";
            }
            if(t instanceof Iterable) {
                return ts((Iterable<?>) t);
            }else if(t instanceof int[]) {
                String s = Arrays.toString((int[]) t);
                return "{"+s.substring(1, s.length()-1)+"}";
            }else if(t instanceof long[]) {
                String s = Arrays.toString((long[]) t);
                return "{"+s.substring(1, s.length()-1)+"}";
            }else if(t instanceof char[]) {
                String s = Arrays.toString((char[]) t);
                return "{"+s.substring(1, s.length()-1)+"}";
            }else if(t instanceof double[]) {
                String s = Arrays.toString((double[]) t);
                return "{"+s.substring(1, s.length()-1)+"}";
            }else if(t instanceof boolean[]) {
                String s = Arrays.toString((boolean[]) t);
                return "{"+s.substring(1, s.length()-1)+"}";
            }else if(t instanceof Object[]) {
                return ts((Object[]) t);
            }
            return t.toString();
        }
        private static <T> String ts(T[] arr) {
            StringBuilder ret = new StringBuilder();
            ret.append("{");
            boolean first = true;
            for(T t: arr) {
                if(!first) ret.append(", ");
                first = false;
                ret.append(ts(t));
            }
            ret.append("}");
            return ret.toString();
        }
        private static <T> String ts(Iterable<T> iter) {
            StringBuilder ret = new StringBuilder();
            ret.append("{");
            boolean first = true;
            for(T t: iter) {
                if(!first) ret.append(", ");
                first = false;
                ret.append(ts(t));
            }
            ret.append("}");
            return ret.toString();
        }
        public static void print(Object... o) {
            if(LOCAL) {
                System.err.print("Line #"+Thread.currentThread().getStackTrace()[2].getLineNumber()+": [");
                for(int i = 0; i<o.length; i++) {
                    if(i!=0) System.err.print(", ");
                    System.err.print(ts(o[i]));
                }
                System.err.println("]");
            }
        }
    }
}