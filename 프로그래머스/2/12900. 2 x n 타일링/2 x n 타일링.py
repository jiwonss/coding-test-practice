def solution(n):
    dp = [0, 1, 2]
    for i in range(3, n + 1):
        dp.append((dp[i - 1] + dp[i - 2]) % 1000000007)
    return dp[n]