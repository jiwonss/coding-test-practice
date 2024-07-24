from sys import stdin, maxsize
input = stdin.readline


def solve():
    N, M = map(int, input().split())
    A = sorted(list(int(input()) for _ in range(N)))

    left, right, result = 0, 0, maxsize
    while right < N:
        diff = A[right] - A[left]
        if diff == M:
            result = M
            break
        if diff > M:
            result = min(result, diff)
            left += 1
        else:
            right += 1
    print(result)


if __name__ == "__main__":
    solve()
