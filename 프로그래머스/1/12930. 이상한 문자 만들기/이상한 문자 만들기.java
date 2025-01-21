class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == ' ') {
                idx = 0;
                continue;
            }
            if (idx % 2 == 0) {
                c[i] = Character.toUpperCase(c[i]);
            } else {
                c[i] = Character.toLowerCase(c[i]);
            }
            idx += 1;
        }
        
        String answer = String.valueOf(c);
        return answer;
    }
}