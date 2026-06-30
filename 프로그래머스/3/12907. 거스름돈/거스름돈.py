def solution(n, money):
    dp = [0] * (n + 1)
    dp[0] = 1
    for coin in money:
        for i in range(coin, n + 1):
            dp[i] += dp[i - coin]
    return dp[n]