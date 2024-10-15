from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    P = [0] + list(map(int, input().split()))

    dp = [0] * (N + 1)

    dp[1] = P[1]
    for i in range(2, N + 1):
        for j in range(1, i + 1):
            if dp[i] < dp[i - j] + P[j]:
                dp[i] = dp[i - j] + P[j]

    result = dp[N]
    print(result)


if __name__ == "__main__":
    solve()
