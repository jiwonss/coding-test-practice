import java.util.*;

class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        int size = arr.length;
        for (int a : arr) {
            sum += a;
        }
        return (double) sum / size;
    }
}