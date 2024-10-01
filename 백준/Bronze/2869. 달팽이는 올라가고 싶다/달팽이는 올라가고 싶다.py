from sys import stdin

input = stdin.readline


def solve():
    A, B, V = map(int, input().split())

    print((V - B - 1) // (A - B) + 1)


if __name__ == "__main__":
    solve()
