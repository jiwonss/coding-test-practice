from sys import stdin

input = stdin.readline


def rotate(sticker):
    r, c = len(sticker), len(sticker[0])
    temp = [[0] * r for _ in range(c)]
    for x in range(c):
        for y in range(r):
            temp[x][y] = sticker[r - y - 1][x]
    return temp


def attach(sticker, x, y):
    r, c = len(sticker), len(sticker[0])
    for i in range(r):
        for j in range(c):
            if sticker[i][j]:
                laptop[x + i][y + j] = 1


def check(sticker, x, y):
    r, c = len(sticker), len(sticker[0])
    for i in range(r):
        for j in range(c):
            if sticker[i][j] == 0:
                continue
            if laptop[x + i][y + j]:
                return False
    return True


def attemp(sticker):
    cnt = 0
    while cnt < 4:
        r, c = len(sticker), len(sticker[0])
        for x in range(N - r + 1):
            for y in range(M - c + 1):
                if check(sticker, x, y):
                    attach(sticker, x, y)
                    return
        sticker = rotate(sticker)
        cnt += 1


def solve():
    global N, M, laptop

    N, M, K = map(int, input().split())

    laptop = [[0] * M for _ in range(N)]
    for _ in range(K):
        R, C = map(int, input().split())
        sticker = [list(map(int, input().split())) for _ in range(R)]
        attemp(sticker)

    result = sum([sum(x) for x in laptop])
    print(result)


if __name__ == "__main__":
    solve()
