class Solution {
    public long solution(int a, int b) {
        long min, max;
        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        
        long answer = 0;
        for (long i = min; i < max + 1; i++) {
            answer += i;
        }
        return answer;
    }
}