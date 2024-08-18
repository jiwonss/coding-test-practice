from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    if N == 1:
        return

    k, root = 2, N ** 0.5
    while N != 1 or k < root:
        while N % k == 0:
            print(k)
            N //= k
        else:
            k += 1


if __name__ == "__main__":
    solve()
