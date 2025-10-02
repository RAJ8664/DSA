class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        Set<String> vis = new HashSet<>();
        List<String> res = new ArrayList<>();
        boolean flag = true;
        while (flag == true) {
            flag = false;
            for (int i = 0; i < recipes.length; i++) {
                if (vis.contains(recipes[i])) continue;
                boolean current = true;
                for (String ingredient : ingredients.get(i)) {
                    if (!set.contains(ingredient)) {
                        current = false;
                        break;
                    }
                }
                if (current) {
                    res.add(recipes[i]);
                    set.add(recipes[i]);
                    vis.add(recipes[i]);
                    flag = true;  
                }
            }

        }
        return res;
    }
}
