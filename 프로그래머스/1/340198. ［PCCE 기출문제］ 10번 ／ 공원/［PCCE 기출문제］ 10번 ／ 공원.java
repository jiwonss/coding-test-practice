class Solution {
    
    int n, m, answer;
    
    public int solution(int[] mats, String[][] park) {
        n = park.length; m = park[0].length;

        answer = -1;
        for (int mat : mats) {
            spread(park, mat);
        }
        return answer;
    }
    
    public boolean spread(String[][] park, int mat) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!park[i][j].equals("-1")) continue;
                if (check(park, mat, i, j)) {
                    answer = Math.max(answer, mat);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean check(String[][] park, int mat, int i, int j) {
        for (int x = i; x < i + mat; x++) {
            for (int y = j; y < j + mat; y++) {
                if (x >= n || y >= m || !park[x][y].equals("-1")) {
                    return false;
                }    
            }
        }
        return true;
    }
    
}