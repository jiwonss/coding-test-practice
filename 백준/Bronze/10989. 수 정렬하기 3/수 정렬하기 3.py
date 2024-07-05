from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    result = [0] * 10001
    for _ in range(N):
        t = int(input())
        result[t] += 1

    for i in range(1, 10001):
        for _ in range(result[i]):
            print(i)


if __name__ == "__main__":
    solve()
