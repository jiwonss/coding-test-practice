class Solution {
    int solution(int[][] land) {
        int n  = land.length; int m = land[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                int max = 0;
                for (int k = 0; k < m; k++) {
                    if (j == k) continue;
                    max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] +=  max;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, land[n - 1][i]);
        }
        return answer;
    }
}