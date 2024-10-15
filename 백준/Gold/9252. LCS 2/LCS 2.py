from sys import stdin

input = stdin.readline


def solve():
    A = list(input().strip())
    B = list(input().strip())

    N, M = len(A), len(B)

    dp = [[0] * 1001 for _ in range(1001)]
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if A[i - 1] == B[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])

    print(dp[N][M])
    if dp[N][M]:
        result = []
        x, y = N, M
        while x > 0 and y > 0:
            if A[x - 1] == B[y - 1]:
                result.append(A[x - 1])
                x -= 1
                y -= 1
            elif dp[x][y - 1] <= dp[x - 1][y]:
                x -= 1
            else:
                y -= 1
        print("".join(result[::-1]))


if __name__ == "__main__":
    solve()
