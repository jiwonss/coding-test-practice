class Solution {
    public int solution(int n) {
        String result = "";
        while (n != 0) {
            result += String.valueOf(n % 3);
            n /= 3;
        }
        
        int answer = 0;
        int length = result.length(); int num = 0;
        for (int i = 0; i < length; i++) {
            num = result.charAt(length - i - 1) - '0';
            answer += (int) Math.pow(3, i) * num;
        }
        return answer;
    }
}