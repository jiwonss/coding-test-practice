class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        
        while (start < end) {
            long mid = (start + end) / 2;
            
            long cnt = 0;
            for (int t : times) {
                cnt += mid / t;
            }
            
            if (cnt < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}