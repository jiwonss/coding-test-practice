from sys import stdin
input = stdin.readline


def solve():
    N, K = map(int, input().split())
    coin = [int(input()) for _ in range(N)]

    result = 0
    for c in coin[::-1]:
        if c > K:
            continue
        result += K // c
        K %= c
    print(result)


if __name__ == "__main__":
    solve()
