class Solution {
    public String solution(String s, int n) {
        char[] c = s.toCharArray();
        int lower = (int) 'a';
        int upper = (int) 'A';
        for (int i = 0; i < s.length(); i++) {
            int k = (int) c[i];
            if (Character.isLowerCase(c[i])) {
                c[i] = (char) ((k - lower + n) % 26 + lower);
            }
            if (Character.isUpperCase(c[i])) {
                c[i] = (char) ((k - upper + n) % 26 + upper);
            }
        }
        return String.valueOf(c);
    }
}