import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> product = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            product.put(want[i], product.getOrDefault(want[i], 0) + number[i]);
        }
        
        int answer = 0;
        Map<String, Integer> mart = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            mart.put(discount[i], mart.getOrDefault(discount[i], 0) + 1);
        }
        if (product.equals(mart)) answer++;
        
        for (int i = 10; i < discount.length; i++) {
            if (mart.get(discount[i - 10]) == 1) {
                mart.remove(discount[i - 10]);
            } else {
                mart.put(discount[i - 10], mart.get(discount[i - 10]) - 1);
            }
            mart.put(discount[i], mart.getOrDefault(discount[i], 0) + 1);
            
            if (product.equals(mart)) answer++;
        }
        return answer;
    }
}