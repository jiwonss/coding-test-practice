from sys import stdin

input = stdin.readline


def solve():
    N, M = map(int, input().split())
    height = list(map(int, input().split()))

    start, end, result = 0, max(height), 0
    while start <= end:
        mid = (start + end) // 2

        cut = 0
        for h in height:
            v = h - mid
            if v > 0:
                cut += v
            if cut > M:
                break

        if cut < M:
            end = mid - 1
        else:
            result = mid
            start = mid + 1
    print(result)


if __name__ == "__main__":
    solve()
