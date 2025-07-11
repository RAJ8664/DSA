class CustomStack {
    static int max;
    static int arr[];
    static int right;
    public CustomStack(int maxSize) {
        right = 0;
        max = maxSize;
        arr = new int[max];
    }
    
    public void push(int x) {
        if (right == max) return;
        arr[right] = x;
        right++;
    }
    
    public int pop() {
        if (right == 0) return -1;
        int ele = arr[right - 1];
        right--;
        return ele;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k , right); i++) arr[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */