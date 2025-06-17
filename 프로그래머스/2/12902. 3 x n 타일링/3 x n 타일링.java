class Solution {
    
    int MOD = 1000000007;
    
    public int solution(int n) {
        if (n % 2 != 0) return 0;
        long a = 1, b = 1;
        for (int i = 0; i < n / 2; i++) {
            long temp = a;
            a = b;
            b = ((4 * b - temp) % MOD + MOD) % MOD;
        }
        return (int) b;
    }
}