class Solution {
    public String solution(String s) {
        String[] num = s.split(" ");
        
        int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            int n = Integer.parseInt(num[i]);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}