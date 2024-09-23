from sys import stdin

input = stdin.readline


def solve():
    T, W = map(int, input().split())
    plum_tree = [0] + [int(input()) for _ in range(T)]

    dp = [[0] * (W + 1) for _ in range(T + 1)]
    dp[1][0], dp[1][1] = plum_tree[1] % 2, plum_tree[1] // 2

    for t in range(2, T + 1):
        for w in range(W + 1):
            div, mod = divmod(plum_tree[t], 2)
            dp[t][w] = max(dp[t - 1][: w + 1]) + (mod if w % 2 == 0 else div)

    print(max(dp[T]))


if __name__ == "__main__":
    solve()
