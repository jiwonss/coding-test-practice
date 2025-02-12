import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int w = park.length;
        int h = park[0].length();
        
        Map<String, int[]> map = new HashMap<>();
        map.put("N", new int[]{-1, 0});
        map.put("S", new int[]{1, 0});
        map.put("W", new int[]{0, -1});
        map.put("E", new int[]{0, 1});
        
        int[] answer = {0, 0};
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        int x, y, nx, ny;
        for (String route : routes) {
            String[] temp = route.split(" ");
            String op = temp[0]; int n = Integer.parseInt(temp[1]);
            x = answer[0]; y = answer[1];
            boolean check = false;
            for (int i = 0; i < n; i++) {
                nx = x + map.get(op)[0];
                ny = y + map.get(op)[1];
                if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                    check = true;
                    break;
                }
                if (park[nx].charAt(ny) == 'X') {
                    check = true;
                    break;
                }
                x = nx; y = ny;
            }
            if (!check) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}