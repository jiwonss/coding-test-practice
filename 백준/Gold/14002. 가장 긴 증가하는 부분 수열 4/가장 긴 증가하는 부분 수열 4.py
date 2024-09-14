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

    max_len = max(dp)
    result = []
    for i in range(N - 1, -1, -1):
        if dp[i] == max_len:
            result.append(A[i])
            max_len -= 1
    result.reverse()

    print(max(dp))
    print(*result)


if __name__ == "__main__":
    solve()
