class Solution {
    boolean solution(String s) {
        String lower = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < lower.length(); i++) {
            if (lower.charAt(i) == 'p') {
                pCnt += 1;
            } 
            if (lower.charAt(i) == 'y') {
                yCnt += 1;
            }
        }
        
        if (pCnt == yCnt) {
            return true;            
        }
        return false;
    }
}