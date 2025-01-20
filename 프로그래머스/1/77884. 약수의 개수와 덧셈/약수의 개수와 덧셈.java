class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int n = left; n < right + 1; n++) {
            if (getDivisorCount(n) % 2 == 0) {
                answer += n;
            } else {
                answer -= n;
            }
        }
        return answer;
    }
    
    public int getDivisorCount(int n) {
        int cnt = 0;
        for (int i = 1; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                cnt += 1;
                if (i * i != n) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}