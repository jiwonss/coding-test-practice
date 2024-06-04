n = int(input())
w = [0] + [int(input()) for _ in range(n)]

if n == 1:
    print(w[1])
    exit()

dp = [0] * (n + 1)

dp[1], dp[2] = w[1], w[1] + w[2]
for i in range(3, n + 1):
    dp[i] = max(dp[i - 1], dp[i - 3] + w[i - 1] + w[i], dp[i - 2] + w[i])

print(dp[n])
