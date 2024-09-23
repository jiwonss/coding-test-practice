from sys import stdin

input = stdin.readline


def check():
    for n in range(N):
        t = n
        for h in range(H):
            if ladder[h][t][0]:
                t -= 1
            elif ladder[h][t][1]:
                t += 1
        if n != t:
            return 0
    return 1


def add(k, sh, sn):
    global result

    if k >= result:
        return

    if check():
        result = min(result, k)
        return

    if k == 3:
        return

    for h in range(sh, H):
        for n in range(sn if h == sh else 0, N - 1):
            if sum(ladder[h][n]):
                continue
            ladder[h][n][1], ladder[h][n + 1][0] = 1, 1
            add(k + 1, h, n + 2)
            ladder[h][n][1], ladder[h][n + 1][0] = 0, 0


def solve():
    global N, M, H, ladder, result

    N, M, H = map(int, input().split())

    ladder = [[[0, 0] for _ in range(N)] for _ in range(H)]
    for _ in range(M):
        a, b = map(int, input().split())
        ladder[a - 1][b - 1][1] = 1
        ladder[a - 1][b][0] = 1

    result = 4
    add(0, 0, 0)
    print(result if result != 4 else -1)


if __name__ == "__main__":
    solve()
