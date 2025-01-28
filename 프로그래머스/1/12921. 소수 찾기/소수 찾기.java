class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n + 1; i++) {
            if (check(i)) answer += 1;
        }
        return answer;
    }
    
    public boolean check(int n) {
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}