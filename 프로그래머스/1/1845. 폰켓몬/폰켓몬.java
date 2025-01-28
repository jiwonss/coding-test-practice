import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(n / 2, set.size());
    }
}