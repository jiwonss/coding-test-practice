from sys import stdin

input = stdin.readline


def solve():
    n, m = map(int, input().split())
    status = sorted(list(map(int, input().split())))

    for _ in range(m):
        v = status[0] + status[1]
        status[0] = v
        status[1] = v
        status.sort()

    result = sum(status)
    print(result)


if __name__ == "__main__":
    solve()
