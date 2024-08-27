from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < N)


def check():
    q = deque()
    visited = [[0] * N for _ in range(N)]

    idx = arr[0]
    i, j = idx // N, idx % N

    visited[i][j] = 1
    q.append([i, j])

    cnt = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if out_of_bounds(nx, ny) or visited[nx][ny]:
                continue
            next_idx = nx * 5 + ny
            if next_idx in arr:
                cnt += 1
                visited[nx][ny] = 1
                q.append([nx, ny])
    return cnt


def form(k, idx, y_cnt):
    global result

    if y_cnt > 3 or (N * N) - idx < 7 - k:
        return

    if k == 7:
        if check() == 7:
            result += 1
        return

    x, y = idx // N, idx % N
    if chart[x][y] == 'S':
        arr[k] = idx
        form(k + 1, idx + 1, y_cnt)
    else:
        arr[k] = idx
        form(k + 1, idx + 1, y_cnt + 1)
    form(k, idx + 1, y_cnt)


def solve():
    global N, chart, arr, result

    N = 5
    chart = [list(input().strip()) for _ in range(N)]

    arr, result = [0] * 7, 0
    form(0, 0, 0)
    print(result)


if __name__ == "__main__":
    solve()
