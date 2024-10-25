import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i, j, k;
        for (int a = 0; a < commands.length; a++) {
            int[] command = commands[a];
            i = command[0] - 1; j = command[1] - 1; k = command[2] - 1;
            int[] arr = new int[j - i + 1];
            for (int idx = i; idx < j + 1; idx++) {
                arr[idx - i] = array[idx];
            }
            Arrays.sort(arr);
            answer[a] = arr[k];
        }
        return answer;
    }
}