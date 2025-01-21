class Solution {
    public int[] solution(int n, int m) {
        int a, b;
        if (n > m) {
            a = n; b = m;
        } else {
            a = m; b = n;
        }
        
        int[] answer = {gcd(a, b), lcm(a, b)};
        return answer;
    }
    
    public int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}