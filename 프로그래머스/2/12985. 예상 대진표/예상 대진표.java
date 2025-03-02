class Solution
{
    public int solution(int n, int a, int b)
    {
        int xor = (a - 1) ^ (b - 1);
        return Integer.toBinaryString(xor).length();
    }
}