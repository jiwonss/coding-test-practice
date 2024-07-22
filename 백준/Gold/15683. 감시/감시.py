from sys import stdin
from copy import deepcopy
input = stdin.readline

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],
    [[0, 1, 2, 3]]
]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def count_blind_spots(office):
    cnt = 0
    for i in range(N):
        cnt += office[i].count(0)
    return cnt


def mark(office, direction, x, y):
    for d in direction:
        _x, _y = x, y
        while True:
            nx = _x + dx[d]
            ny = _y + dy[d]

            if out_of_bounds(nx, ny) or office[nx][ny] == 6:
                break

            if office[nx][ny] == 0:
                office[nx][ny] = 7
            _x, _y = nx, ny
    return office


def watch(office, k):
    global result

    if k == len(cctv):
        result = min(result, count_blind_spots(office))
        return

    n, x, y = cctv[k]
    for i in mode[n]:
        copy_office = mark(deepcopy(office), i, x, y)
        watch(copy_office, k + 1)


def solve():
    global N, M, office, cctv, result
    N, M = map(int, input().split())

    office, cctv = [], []
    for i in range(N):
        office.append(list(map(int, input().split())))
        for j in range(M):
            t = office[i][j]
            if 0 < t < 6:
                cctv.append([t, i, j])

    result = N * M
    watch(office, 0)
    print(result)


if __name__ == "__main__":
    solve()
