import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");

        List<Integer> number = new ArrayList();
        for (String a : arr) {
            number.add(Integer.parseInt(a));
        }
        
        Collections.sort(number);
        
        String min = String.valueOf(number.get(0));
        String max = String.valueOf(number.get(number.size() - 1));
        String answer = min + " " + max;
        
        return answer;
    }
}