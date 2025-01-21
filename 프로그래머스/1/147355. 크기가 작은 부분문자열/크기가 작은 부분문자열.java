class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n, m;
        long intT, intP;
        n = t.length(); m = p.length(); intP = Long.parseLong(p);
        for (int i = 0; i < n - m + 1; i++) {
            intT = Long.parseLong(t.substring(i, i + m));
            if (intT <= intP) {
                answer += 1;
            } 
        }
        return answer;
    }
}