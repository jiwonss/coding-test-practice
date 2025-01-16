import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> number = new ArrayList<>();
        while (n > 0) {
            number.add((int) (n % 10));
            n /= 10;
        }
        number.sort((a, b) -> a - b);
        
        long answer = 0;
        long digits = 1;
        for (int i = 0; i < number.size(); i++) {
            answer += number.get(i) * digits;
            digits *= 10;
        }
        return answer;
    }
}