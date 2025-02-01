class Solution {
    
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[h][w].equals(board[nx][ny])) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}