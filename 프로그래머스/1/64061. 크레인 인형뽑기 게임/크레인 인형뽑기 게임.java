import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            int j = move - 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][j]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][j]);
                    }
                    board[i][j] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}