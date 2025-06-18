import java.util.*;

class Solution {
    
    List<int[]> result = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return result.toArray(new int[result.size()][]);
    }
    
    public void hanoi(int n, int start, int end, int mid) {
        if (n == 1) {
            result.add(new int[]{start, end});
            return;
        }
        
        hanoi(n - 1, start, mid, end);
        result.add(new int[]{start, end});
        hanoi(n - 1, mid, end, start);
    } 
}