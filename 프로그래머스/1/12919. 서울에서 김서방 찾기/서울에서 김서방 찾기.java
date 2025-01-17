class Solution {
    public String solution(String[] seoul) {
        int x = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                x = i; 
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ").append(String.valueOf(x)).append("에 있다");
        return sb.toString();
    }
}