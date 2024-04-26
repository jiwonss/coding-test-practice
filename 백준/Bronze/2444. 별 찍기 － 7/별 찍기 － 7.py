from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    for i in range(2 * N - 1):
        if i <= N - 1:
            print((' ' * (N - i - 1)) + ('*' * (2 * i + 1)))
        else:
            print(' ' * (i - N + 1) + ('*' * (2 * (2 * (N - 1) - i) + 1)))


if __name__ == "__main__":
    solve()
