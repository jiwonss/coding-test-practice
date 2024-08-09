from sys import stdin
input = stdin.readline


def solve():
    N, M = map(int, input().split())

    num = [0] + list(map(int, input().split()))
    for i in range(1, N + 1):
        num[i] += num[i - 1]

    for _ in range(M):
        i, j = map(int, input().split())
        result = num[j] - num[i - 1]
        print(result)


if __name__ == "__main__":
    solve()
