from sys import stdin
input = stdin.readline


def count(n):
    cnt = 0
    for l in L:
        cnt += l // n
    return cnt


def solve():
    global N, L

    M, N = map(int, input().split())
    L = list(map(int, input().split()))

    start, end, result = 1, max(L), 0
    while start <= end:
        mid = (start + end) // 2

        if count(mid) < M:
            end = mid - 1
        else:
            result = mid
            start = mid + 1

    print(result)


if __name__ == "__main__":
    solve()