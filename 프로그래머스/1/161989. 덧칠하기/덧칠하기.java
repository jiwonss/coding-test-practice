class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = section[0];
        for (int s : section) {
            if (idx <= s) {
                idx = s + m;
                answer += 1;
            }
        }
        return answer;
    }
}