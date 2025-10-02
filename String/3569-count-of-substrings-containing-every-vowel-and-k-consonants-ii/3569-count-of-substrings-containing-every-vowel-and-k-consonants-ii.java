class Solution {
    public long countOfSubstrings(String word, int k) {
        return countOfSubstringHavingAtleastXConsonants(word, k)
                - countOfSubstringHavingAtleastXConsonants(word, k + 1);
    }
    public long countOfSubstringHavingAtleastXConsonants(String word, int k) {
        int start = 0 , end = 0, consonants = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        long res = 0;
        while (end < word.length()) {
            char currChar = word.charAt(end);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            if (!isVowel(currChar)) consonants++;
            while (start < word.length() && satisfied(map) && consonants >= k) {
                res += word.length() - end;
                char startCh = word.charAt(start);
                map.put(startCh, map.getOrDefault(startCh, 0) - 1);
                if (map.get(startCh) == 0) {
                    map.remove(startCh);
                }
                if (!isVowel(startCh)) consonants--;
                start++;
            }
            end++;
        }
        return res;
    }
    private boolean satisfied(HashMap<Character, Integer> map) {
        int count = 0;
        if (map.getOrDefault('a' , 0) > 0) count++;
        if (map.getOrDefault('e' , 0) > 0) count++;
        if (map.getOrDefault('i' , 0) > 0) count++;
        if (map.getOrDefault('o' , 0) > 0) count++;
        if (map.getOrDefault('u' , 0) > 0) count++;
        return count == 5; 
    }
    private boolean isVowel(char current) {
        return current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u';
    }

}