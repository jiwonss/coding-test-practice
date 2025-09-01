from sys import stdin
from copy import deepcopy

input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    [[0, 1, 2, 3]],
]


def count(office):
    cnt = 0
    for i in range(N):
        cnt += office[i].count(0)
    return cnt


def mark(office, d, x, y):
    for i in d:
        _x, _y = x, y
        while True:
            nx, ny = _x + dx[i], _y + dy[i]

            if not (0 <= nx < N and 0 <= ny < M) or office[nx][ny] == 6:
                break

            if office[nx][ny] == 0:
                office[nx][ny] = 7

            _x, _y = nx, ny
    return office


def dfs(office, k):
    global result

    if k == len(cctv):
        result = min(result, count(office))
        return

    x, y, n = cctv[k]
    for d in mode[n]:
        copy_office = mark(deepcopy(office), d, x, y)
        dfs(copy_office, k + 1)


def solve():
    global N, M, cctv, result

    N, M = map(int, input().split())

    office, cctv = [], []
    for x in range(N):
        office.append(list(map(int, input().split())))
        for y in range(M):
            if office[x][y] in [0, 6]:
                continue
            cctv.append([x, y, office[x][y]])

    result = N * M
    dfs(office, 0)
    print(result)


if __name__ == "__main__":
    solve()
