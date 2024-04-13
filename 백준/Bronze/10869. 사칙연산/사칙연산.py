from sys import stdin
input = stdin.readline


def solve():
    A, B = map(int, input().split())
    print(A + B)
    print(A - B)
    print(A * B)
    print(A // B)
    print(A % B)


if __name__ == "__main__":
    solve()
