from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    while N != 1:
        for k in range(2, N + 1):
            if N % k == 0:
                print(k)
                N //= k
                break


if __name__ == "__main__":
    solve()
