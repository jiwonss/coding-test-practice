class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        int match_cnt = 0; int zero_cnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero_cnt += 1;
                continue;
            }
            for (int num : win_nums) {
                if (lotto == num) {
                    match_cnt += 1;
                }
            }
        }
        
        int[] answer = {rank[match_cnt + zero_cnt], rank[match_cnt]};
        return answer;
    }
}