from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    for i in range(N):
        print((' ' * i) + ('*' * (N - i)))


if __name__ == "__main__":
    solve()
