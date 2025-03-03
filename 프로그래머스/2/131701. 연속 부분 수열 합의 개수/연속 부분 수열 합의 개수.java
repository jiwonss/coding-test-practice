import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for (int size = 1; size < n + 1; size++) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += elements[i];
            }
            set.add(sum);
            for (int i = 0; i < n; i++) {
                sum -= elements[i];
                sum += elements[(i + size) % n];
                set.add(sum);
            }
        }
        return set.size();
    }
}