import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        int[] answer = {0, 0, 0, 0};
        answer[0] = Collections.min(x);
        answer[1] = Collections.min(y);
        answer[2] = Collections.max(x) + 1;
        answer[3] = Collections.max(y) + 1;
        return answer;
    }
}