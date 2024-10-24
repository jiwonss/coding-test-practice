class Solution {
    public int solution(int n) {
        int answer = n + 1;
        String curBinary = Integer.toBinaryString(n);
        int curBinaryCnt = count(curBinary);
        while (true) {
            String nxtBinary = Integer.toBinaryString(answer);
            int nxtBinaryCnt = count(nxtBinary);
            
            if (curBinaryCnt == nxtBinaryCnt) {
                break;
            }
            answer++;
        }
        return answer;
    }
    
    public int count(String binary) {
        int cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
    
}