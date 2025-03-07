class Solution {
    public int[] solution(int n, long left, long right) {
        int cnt = (int) (right - left + 1);
        int[] answer = new int[cnt];
        int idx = 0;
        for (long i = left; i < right + 1; i++) {
            answer[idx++] = (int) Math.max((int) (i / n), i % n) + 1;
        }
        return answer;
    }
}