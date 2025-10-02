class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
	    return diffWaysToCompute(expression, new HashMap<>());
    }
    private List<Integer> diffWaysToCompute(String expression, Map<String, List<Integer>> map) {
        if (map.containsKey(expression)) return map.get(expression);
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (!hasOperator(expression))
            values.add(Integer.parseInt(expression));
        else
            for (int i = 0; i < expression.length(); i++) {
                char symbol = expression.charAt(i);
                if (!Character.isDigit(symbol)) {
                    List<Integer> leftParts = diffWaysToCompute(expression.substring(0, i), map);
                    List<Integer> rightParts = diffWaysToCompute(expression.substring(i + 1), map);
                    for (int l : leftParts)
                        for (int r : rightParts)
                            switch (symbol) {
                                case '+' -> values.add(l + r);
                                case '-' -> values.add(l - r);
                                case '*' -> values.add(l * r);
                            }
                }
            }
        return map.compute(expression, (k,v) -> values);
    }
    private boolean hasOperator(String expression) {
        for (var i = 0; i < expression.length(); i++)
            switch (expression.charAt(i)) {
                case '+', '-', '*' -> {
                    return true;
                }
            }
        return false;
    }
}