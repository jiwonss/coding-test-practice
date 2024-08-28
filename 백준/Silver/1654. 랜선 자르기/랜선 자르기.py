from sys import stdin
input = stdin.readline


def solve():
    K, N = map(int, input().split())
    lan = [int(input()) for _ in range(K)]

    start, end = 1, max(lan)
    while start <= end:
        mid = (start + end) // 2

        cnt = sum([lan[i] // mid for i in range(K)])
        if cnt >= N:
            start = mid + 1
        else:
            end = mid - 1
    print(end)


if __name__ == "__main__":
    solve()
