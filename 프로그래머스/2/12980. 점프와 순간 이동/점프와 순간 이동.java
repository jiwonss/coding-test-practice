import java.util.*;

public class Solution {
    public int solution(int n) {
        String bin = Integer.toBinaryString(n);
        int answer = 0;
        for (char c : bin.toCharArray()) {
            if (c == '1') answer++;
        }
        return answer;
    }
}