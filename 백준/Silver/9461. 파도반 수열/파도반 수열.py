from sys import stdin
input = stdin.readline


def solve():
    dp = [0, 1, 1]
    for i in range(3, 101):
        dp.append(dp[i - 3] + dp[i - 2])

    T = int(input())
    for _ in range(T):
        N = int(input())
        print(dp[N])


if __name__ == "__main__":
    solve()
