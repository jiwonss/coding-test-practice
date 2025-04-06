import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] strNumbers = new String[n];
        for (int i = 0; i < n; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, (a, b) -> (b + b + b).compareTo(a + a + a));
        
        if (strNumbers[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String str : strNumbers) {
            sb.append(str);
        }
        return sb.toString();
    }
}