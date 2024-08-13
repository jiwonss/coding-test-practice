from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    point = list(map(int, input().split()))

    x = sorted(set(point))
    result = {x[i]: i for i in range(len(x))}

    for p in point:
        print(result[p], end=' ')


if __name__ == "__main__":
    solve()
