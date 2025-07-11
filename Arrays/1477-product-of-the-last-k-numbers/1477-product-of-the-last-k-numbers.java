class ProductOfNumbers {
    static ArrayList<Integer> res; 
    public ProductOfNumbers() {
        res = new ArrayList<>();
    }
    public void add(int num) {
        res.add(num);
    }
    public int getProduct(int k) {
        int sum = 1;
        int len = res.size() - 1;
        while (k > 0) {
            sum = sum * res.get(len--);
            k--;
        }
        return sum;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */