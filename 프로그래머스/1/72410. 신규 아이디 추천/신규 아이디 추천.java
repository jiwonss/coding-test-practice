class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        
        // 4단계
        if (new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 5단계
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        
        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }
        
        // 7단계
        if (new_id.length() <= 2) {
            while (new_id.length() != 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        return new_id;
    }
}