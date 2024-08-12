from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    lope = sorted([int(input()) for _ in range(N)])

    result = 0
    for i in range(1, N + 1):
        result = max(result, lope[N - i] * i)
    print(result)


if __name__ == "__main__":
    solve()
