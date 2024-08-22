from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    T, P = [], []
    for i in range(N):
        a, b = map(int, input().split())
        T.append(a)
        P.append(b)

    dp = [P[i] for i in range(N)] + [0]
    for i in range(N - 1,  -1, -1):
        if i + T[i] > N:
            dp[i] = dp[i + 1]
        else:
            dp[i] = max(dp[i + 1], P[i] + dp[i + T[i]])
    print(dp[0])


if __name__ == "__main__":
    solve()
