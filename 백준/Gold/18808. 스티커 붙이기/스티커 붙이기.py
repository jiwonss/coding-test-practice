from sys import stdin
input = stdin.readline


def rotate_sticker(sticker):
    n, m = len(sticker), len(sticker[0])
    temp = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            temp[i][j] = sticker[n - j - 1][i]
    return temp


def check_sticker_fit(sticker, x, y):
    n, m = len(sticker), len(sticker[0])
    for i in range(n):
        for j in range(m):
            if sticker[i][j] == 0:
                continue
            if labtop[x + i][y + j]:
                return 0
    return 1


def attach_sticker_to_laptop(sticker, x, y):
    n, m = len(sticker), len(sticker[0])
    for i in range(n):
        for j in range(m):
            if sticker[i][j]:
                labtop[x + i][y + j] = 1


def attach_sticker(sticker):
    cnt = 0
    while cnt < 4:
        n, m = len(sticker), len(sticker[0])
        for i in range(N - n + 1):
            for j in range(M - m + 1):
                if check_sticker_fit(sticker, i, j):
                    attach_sticker_to_laptop(sticker, i, j)
                    return
        sticker = rotate_sticker(sticker)
        cnt += 1


def solve():
    global N, M, K, labtop

    N, M, K = map(int, input().split())

    labtop = [[0] * M for _ in range(N)]

    for _ in range(K):
        R, C = map(int, input().split())
        sticker = [list(map(int, input().split())) for _ in range(R)]
        attach_sticker(sticker)

    result = sum([sum(x) for x in labtop])
    print(result)


if __name__ == "__main__":
    solve()
