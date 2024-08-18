from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    k = 2
    while k * k <= N:
        while N % k == 0:
            print(k)
            N //= k
        k += 1

    if N > 1:
        print(N)


if __name__ == "__main__":
    solve()
