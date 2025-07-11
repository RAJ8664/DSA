class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        while (right < n) {
            set.add(nums[right]);
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (left <= right && Math.abs(set.first() - set.last()) > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) set.remove(nums[left]);
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }

    static Debug dbg = new Debug();
    static class Debug {
        public static boolean LOCAL = true;
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
                System.out.print("Line #"+Thread.currentThread().getStackTrace()[2].getLineNumber()+": [");
                for(int i = 0; i<o.length; i++) {
                    if(i!=0) System.out.print(", ");
                    System.out.print(ts(o[i]));
                }
                System.out.println("]");
            }
        }
    }
}