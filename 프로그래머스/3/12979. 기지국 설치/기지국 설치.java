class Solution {
    public int solution(int n, int[] stations, int w) {
        int idx, location, answer;
        idx = 0; location = 1; answer = 0;
        while (location <= n) {
            if (idx < stations.length && location >= stations[idx] - w) {
                location = stations[idx] + w + 1;
                idx++;
            } else {
                location += 2 * w + 1;
                answer++;
            }
        }
        return answer;
    }
}