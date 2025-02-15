class Solution {
    public int solution(int n, int w, int num) {
        int div = (int) (num - 1) / w;
        int mod = (num - 1) % w;
        int x = 0;
        if (div % 2 == 0) {
            x = w - mod;
        } else {
            x = mod + 1;
        }
        
        int temp = x * 2 - 1;
        int[] step = {temp, w * 2 - temp};
        
        int answer = 0;
        while (num < n) {
            if (div % 2 == 0) {
                num += step[0];
            } else {
                num += step[1];
            }
            div++; answer++;
        }
        
        if (num == n) answer++;
        return answer;
    }
}