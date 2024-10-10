from sys import stdin

input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        H, W, N = map(int, input().split())

        div, mod = divmod(N, H)
        result = 0
        if mod:
            result = mod * 100 + div + 1
        else:
            result = H * 100 + div
        print(result)


if __name__ == "__main__":
    solve()
