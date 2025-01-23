class Solution {
    public int solution(int[][] sizes) {
        int w, h, temp;
        w = 0; h = 0; temp = 0;
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            w = Math.max(w, size[0]);
            h = Math.max(h, size[1]);
        }
        return w * h;
    }
}