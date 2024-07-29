from sys import stdin
input = stdin.readline


def solve():
    n = int(input())
    score = [0] + [int(input()) for _ in range(n)]

    if n < 2:
        print(score[n])
        return

    dp = [[0, 0] for _ in range(n + 1)]
    dp[1] = [score[1], 0]
    dp[2] = [score[2], score[1] + score[2]]

    for i in range(3, n + 1):
        dp[i][0] = max(dp[i - 2]) + score[i]
        dp[i][1] = dp[i - 1][0] + score[i]
    print(max(dp[n]))


if __name__ == "__main__":
    solve()
