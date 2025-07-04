class Solution {
    public int solution(int storey) {
        if (storey < 10) {
            return Math.min(storey, 11 - storey);
        }
        int div, mod;
        div = (int) storey / 10; mod = storey % 10;
        return Math.min(mod + solution(div), 10 - mod + solution(div + 1));
    }
}