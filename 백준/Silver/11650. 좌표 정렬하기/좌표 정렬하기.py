from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    point = []
    for _ in range(N):
        x, y = map(int, input().split())
        point.append([x, y])

    result = sorted(point, key=lambda x: (x[0], x[1]))
    for r in result:
        print(*r)


if __name__ == "__main__":
    solve()
