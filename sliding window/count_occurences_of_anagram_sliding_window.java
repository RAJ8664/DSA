import java.util.HashMap;

public class count_occurences_of_anagram_sliding_window {
    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String t = "for";
        System.out.println(optimal_approach(s,t));
    }

    //optimal approach using sliding window;
    public static int optimal_approach(String s, String t){
        int n = s.length();
        int n1 = t.length();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i = 0; i < n1; i++){
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0) + 1);
        }
        for(int i = 0; i < n1; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        int count = 0;
        if(map.equals(map1)){
            count++;
        }
        int start = 0;
        for(int i = n1; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
            char ch1 = s.charAt(start);
            map.put(ch1,map.getOrDefault(ch1, 0) - 1);
            if(map.get(ch1) <=0){
                map.remove(ch1);
            }
            if(map1.equals(map)){
                count++;
            }
            start++;
        }
        return count;
    }
}
