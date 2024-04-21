from sys import stdin
input = stdin.readline


def solve():
    N = int(input())
    for i in range(N, 0, -1):
        print('*' * i)


if __name__ == "__main__":
    solve()
