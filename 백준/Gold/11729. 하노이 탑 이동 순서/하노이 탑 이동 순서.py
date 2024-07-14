from sys import stdin
input = stdin.readline


def hanoi(a, b, n):
    if n == 1:
        print(a, b)
        return
    hanoi(a, 6 - a - b, n - 1)
    print(a, b)
    hanoi(6 - a - b, b, n - 1)


def solve():
    N = int(input())

    print((1 << N) - 1)
    hanoi(1, 3, N)


if __name__ == "__main__":
    solve()
