class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        for (int i = 1; i < (int) Math.sqrt(yellow) + 1; i++) {
            int w = (int) yellow / i; int h = i;
            if (yellow % h == 0 && 2 * (w + h) == brown - 4) {
                answer[0] = w + 2; answer[1] = h + 2;
                return answer;
            }
        }
        return answer;
    }
}