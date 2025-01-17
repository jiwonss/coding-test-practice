class Solution {
    public int solution(int num) {
        int cnt = 0;
        long n = num;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n *= 3;
                n += 1;
            }
            
            cnt += 1;
            if (cnt == 500) return -1;
        }
        return cnt;
    }
}