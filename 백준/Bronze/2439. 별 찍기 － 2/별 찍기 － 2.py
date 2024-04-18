from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    for i in range(N):
        print(' ' * (N - i - 1) + '*' * (i + 1))


if __name__ == "__main__":
    solve()
