class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        while (!s.equals("1")) {
            int[] cnt = new int[2];
            for (char c : s.toCharArray()) {
                if (c == '0') cnt[0]++;
                else cnt[1]++;
            }
            
            s = Integer.toBinaryString(cnt[1]);
            
            answer[0]++;
            answer[1] += cnt[0];
        }
        return answer;
    }
}