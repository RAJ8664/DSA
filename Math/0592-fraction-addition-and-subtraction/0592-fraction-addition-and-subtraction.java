import java.util.ArrayList;

class Solution {
    public String fractionAddition(String expression) {
        String s = "";
        if (expression.charAt(0) == '-')
            s = expression;
        else
            s = "+" + expression;

        int n = s.length();
        ArrayList<Integer> numerator = new ArrayList<>();
        ArrayList<Integer> denominator = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n) {
            i = j;
            if (i >= n)
                break;
            boolean positive = true;
            if (s.charAt(i) == '-')
                positive = false;

            j++;
            int dig = 0;
            while (j < n && s.charAt(j) != '/')
                dig = dig * 10 + s.charAt(j++) - '0';
            if (positive)
                numerator.add(dig);
            else
                numerator.add(-dig);
            dig = 0;
            j++;
            while (j < n && (s.charAt(j) != '+' && s.charAt(j) != '-'))
                dig = dig * 10 + s.charAt(j++) - '0';
            denominator.add(dig);
        }

        int lcm = lcm(denominator);
        long sum = 0;
        for (int x = 0; x < numerator.size(); x++)
            sum += numerator.get(x) * lcm / denominator.get(x);

        String ans = "";
        ans += sum + "/" + lcm;
        ans = reduce(ans);
        return ans;
    }

    String reduce(String fraction) {
        String[] parts = fraction.split("/");
        int num = Integer.parseInt(parts[0]);
        int den = Integer.parseInt(parts[1]);
        if (num == 0)
            return "0/1";
        int gcd = gcd(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;
        if (den < 0) {
            num = -num;
            den = -den;
        }
        return num + "/" + den;
    }

    private int lcm(ArrayList<Integer> numbers) {
        return numbers.stream().reduce(
                   1, (x, y) -> (x * y) / gcd(x, y));
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}