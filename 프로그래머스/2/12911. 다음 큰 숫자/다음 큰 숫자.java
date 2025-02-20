class Solution {
    public int solution(int n) {
        int cnt = count(Integer.toBinaryString(n)); 
        for (int x = n + 1; x < 1000001; x++) {
            if (count(Integer.toBinaryString(x)) == cnt) {
                return x;
            }
        }
        return -1;
    }
    
    public int count(String binary) {
        int cnt = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') cnt++;
        }
        return cnt;
    }
}