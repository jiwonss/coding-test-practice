class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = ' '; int[] cnt = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt[0] == cnt[1]) {
                answer += 1;
                x = c;
            }
            if (c == x) {
                cnt[0] += 1;
            } else {
                cnt[1] += 1;
            }
        }
        return answer;
    }
}