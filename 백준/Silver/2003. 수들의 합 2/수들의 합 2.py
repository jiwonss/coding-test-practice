from sys import stdin
input = stdin.readline


def solve():
    N, M = map(int, input().split())
    A = [0] + list(map(int, input().split()))

    prefix = [0] * (N + 1)
    for i in range(1, N + 1):
        prefix[i] = prefix[i - 1] + A[i]

    start, end, result = 0, 0, 0
    while end <= N:
        total = prefix[end] - prefix[start]

        if total >= M:
            start += 1
            if total == M:
                result += 1
        else:
            end += 1

    print(result)


if __name__ == "__main__":
    solve()
