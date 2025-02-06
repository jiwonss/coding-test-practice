import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        List<List<Integer>> keypad = new ArrayList<>();
        keypad.add(List.of(1, 4, 7, -1));
        keypad.add(List.of(2, 5, 8, 0));
        keypad.add(List.of(3, 6, 9, -1));
        
        StringBuilder sb = new StringBuilder();
        int[] left = {0, 3}; int[] right = {2, 3};
        int idx, leftDist, rightDist;
        for (int n : numbers) {
            if (keypad.get(0).indexOf(n) != -1) {
                sb.append("L");
                left[0] = 0; left[1] = keypad.get(0).indexOf(n);
            }
            if (keypad.get(2).indexOf(n) != -1) {
                sb.append("R");
                right[0] = 2; right[1] = keypad.get(2).indexOf(n);
            }
            if (keypad.get(1).indexOf(n) != -1) {
                idx = keypad.get(1).indexOf(n);
                leftDist = Math.abs(1 - left[0]) + Math.abs(left[1] - idx);
                rightDist = Math.abs(1 - right[0]) + Math.abs(right[1] - idx);
                if (leftDist == rightDist) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left[0] = 1; left[1] = idx;
                    } else {
                        sb.append("R");
                        right[0] = 1; right[1] = idx;
                    }
                } else if (leftDist < rightDist) {
                    sb.append("L");
                    left[0] = 1; left[1] = idx;
                } else {
                    sb.append("R");
                    right[0] = 1; right[1] = idx;
                }
            }
        }
        return sb.toString();
    }
}