from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    for i in range(N - 1, -1, -1):
        print((' ' * (N - i - 1)) + ('*' * (2 * i + 1)))


if __name__ == "__main__":
    solve()
