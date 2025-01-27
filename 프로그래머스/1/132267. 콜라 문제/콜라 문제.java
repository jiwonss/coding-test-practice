class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int div, mod;
        while (n >= a) {
            div = (int) n / a;
            mod = n % a;
            answer += (div * b);
            n = (div * b) + mod;
        }
        return answer;
    }
}