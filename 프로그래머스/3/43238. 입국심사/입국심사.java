class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 10000000000L * 100000L;
        
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