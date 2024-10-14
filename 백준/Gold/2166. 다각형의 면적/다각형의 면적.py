from sys import stdin

input = stdin.readline


def solve():
    N = int(input())
    coords = [list(map(int, input().split())) for _ in range(N)]

    sum1, sum2 = 0, 0
    for i in range(N):
        x1, y1 = coords[i]
        x2, y2 = coords[(i + 1) % N]
        sum1 += x1 * y2
        sum2 += y1 * x2

    result = abs(sum1 - sum2) / 2
    print(result)


if __name__ == "__main__":
    solve()
