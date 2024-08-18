from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    A = list(map(int, input().split()))

    dp = [1] * N
    for i in range(1, N):
        for j in range(i):
            if A[i] <= A[j]:
                continue
            dp[i] = max(dp[j] + 1, dp[i])

    print(max(dp))


if __name__ == "__main__":
    solve()
