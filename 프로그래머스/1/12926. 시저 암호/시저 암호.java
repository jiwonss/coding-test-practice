class Solution {
    public String solution(String s, int n) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(c[i])) {
                c[i] = (char) ((((int) c[i] - (int) 'a') + n) % 26 + (int) 'a');
            }
            if (Character.isUpperCase(c[i])) {
                c[i] = (char) ((((int) c[i] - (int) 'A') + n) % 26 + (int) 'A');
            }
        }
        return String.valueOf(c);
    }
}