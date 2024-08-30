from sys import stdin
input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        N = int(input())
        stock_price = list(map(int, input().split()))

        max_price, result = stock_price[-1], 0
        for i in range(N - 2, -1, -1):
            max_price = max(max_price, stock_price[i])
            result += max_price - stock_price[i]
        print(result)


if __name__ == "__main__":
    solve()
