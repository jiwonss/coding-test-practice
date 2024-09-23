from sys import stdin

input = stdin.readline


def check():
    for n in range(N):
        p = n
        for h in range(H):
            if ladder[h][p]:
                p += 1
            elif p > 0 and ladder[h][p - 1]:
                p -= 1
        if n != p:
            return 0
    return 1


def add(k, sh, sn):
    global result

    if check():
        result = min(result, k)
        return

    if k == 3 or k >= result:
        return

    for h in range(sh, H):
        for n in range(sn if h == sh else 0, N - 1):
            if ladder[h][n] or (n > 0 and ladder[h][n - 1]) or ladder[h][n + 1]:
                continue
            ladder[h][n] = 1
            add(k + 1, h, n + 2)
            ladder[h][n] = 0
        sn = 0


def solve():
    global N, M, H, ladder, result

    N, M, H = map(int, input().split())

    ladder = [[0] * N for _ in range(H)]
    for _ in range(M):
        a, b = map(int, input().split())
        ladder[a - 1][b - 1] = 1

    result = 4
    add(0, 0, 0)
    print(result if result < 4 else -1)


if __name__ == "__main__":
    solve()
