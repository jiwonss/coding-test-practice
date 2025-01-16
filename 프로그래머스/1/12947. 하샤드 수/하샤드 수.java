class Solution {
    public boolean solution(int x) {
        int n = x;
        int harshad = 0;
        while (n > 0) {
            harshad += n % 10;
            n /= 10;
        }
        return (x % harshad == 0)? true : false;
    }
}