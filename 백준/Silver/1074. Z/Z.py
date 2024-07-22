from sys import stdin
input = stdin.readline


def z(N, r, c):
    if N == 0:
        return 0

    half = 1 << (N - 1)
    if r < half and c < half:
        return z(N - 1, r, c)
    elif r < half and c >= half:
        return (half ** 2) + z(N - 1, r, c - half)
    elif r >= half and c < half:
        return 2 * (half ** 2) + z(N - 1, r - half, c)
    else:
        return 3 * (half ** 2) + z(N - 1, r - half, c - half)


def solve():
    N, r, c = map(int, input().split())
    print(z(N, r, c))


if __name__ == "__main__":
    solve()
