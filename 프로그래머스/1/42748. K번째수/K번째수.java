import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i, j, k;
        int idx = 0;
        for (int[] command : commands) {
            i = command[0]; j = command[1]; k = command[2];
            List<Integer> list = new ArrayList<>();
            for (int a = i - 1; a < j; a++) {
                list.add(array[a]);
            }
            Collections.sort(list);
            answer[idx++] = list.get(k - 1);
        }
        return answer;
    }
}