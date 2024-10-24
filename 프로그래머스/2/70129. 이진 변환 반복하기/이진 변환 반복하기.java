class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        while (true) {
            if (s.length() == 1) {
                break;
            }
            
            int cnt0 = 0, cnt1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    cnt0 += 1;
                } else {
                    cnt1 += 1;
                }
            }
            answer[1] += cnt0;
            
            s = Integer.toBinaryString(cnt1);
            answer[0] += 1;
        }
        return answer;
    }
}