from sys import stdin
input = stdin.readline


def solve():
    X = int(input())

    cnt = 0
    while X > 0:
        X -= cnt
        cnt += 1

    t = cnt + X - 1
    n, d = t, cnt - t
    print(f'{n}/{d}' if cnt % 2 else f'{d}/{n}')


if __name__ == "__main__":
    solve()
