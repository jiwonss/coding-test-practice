from sys import stdin

input = stdin.readline


def solve():
    dp = [0, 1, 2, 4]
    for _ in range(4, 1000001):
        dp.append((dp[-1] + dp[-2] + dp[-3]) % 1000000009)

    T = int(input())
    for _ in range(T):
        n = int(input())
        print(dp[n])


if __name__ == "__main__":
    solve()
