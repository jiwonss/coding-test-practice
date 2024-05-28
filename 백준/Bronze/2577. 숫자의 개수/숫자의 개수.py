from sys import stdin
input = stdin.readline


def solve():
    num = [0] * 10

    A, B, C = [int(input().strip()) for _ in range(3)]

    result = str(A * B * C)
    for r in result:
        num[int(r)] += 1

    for n in num:
        print(n)


if __name__ == "__main__":
    solve()
