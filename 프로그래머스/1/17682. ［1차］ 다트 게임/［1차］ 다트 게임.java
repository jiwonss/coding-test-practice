import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        Map<String, Integer> map = new HashMap<>();
        map.put("S", 1); map.put("D", 2); map.put("T", 3);
        map.put("*", 2); map.put("#", -1);
        
        Pattern pattern = Pattern.compile("(\\d+)([SDT])([*#])?");
        Matcher matcher = pattern.matcher(dartResult);
        
        int idx = 0;
        String score, bonus, option;
        int[] result = new int[3];
        while (matcher.find()) {
            score = matcher.group(1); bonus = matcher.group(2); option = matcher.group(3);
            
            if (idx > 0 && option != null && option.equals("*")) {
                result[idx - 1] *= 2;
            }
 
            result[idx] = (int) Math.pow(Integer.parseInt(score), map.get(bonus));
            if (option != null) {
                result[idx] *= map.get(option);
            }
            idx += 1;
        }
        
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += result[i];
        }
        return answer;
    }
}