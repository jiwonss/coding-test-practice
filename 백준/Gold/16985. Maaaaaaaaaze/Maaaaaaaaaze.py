from sys import stdin
from collections import deque
input = stdin.readline

dx, dy, dz = [1, 0, -1, 0, 0, 0], [0, 1, 0, -1, 0, 0], [0, 0, 0, 0, 1, -1]


def rotate(arr):
    temp = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            temp[i][j] = arr[N - j - 1][i]
    return temp


def out_of_bounds(x, y, z):
    return not (0 <= x < N and 0 <= y < N and 0 <= z < N)


def bfs(start, end, maze):
    global result

    q = deque()
    visited = [[[0] * N for _ in range(N)] for _ in range(N)]

    sz, sx, sy = start
    visited[sz][sx][sy] = 1
    q.append([sx, sy, sz, 0])

    while q:
        x, y, z, cnt = q.popleft()
        if [z, x, y] == end:
            return cnt
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if out_of_bounds(nx, ny, nz):
                continue
            if visited[nz][nx][ny] or maze[nz][nx][ny] == 0:
                continue
            visited[nz][nx][ny] = 1
            q.append([nx, ny, nz, cnt + 1])
    return -1


def stack(k, arr, visited, selected):
    global result

    if k == N:
        maze = []
        for i in range(N):
            x, y = selected[i]
            maze.append(board[x][y])

        cnt = -1
        if maze[0][0][0] and maze[4][4][4]:
            cnt = bfs([0, 0, 0], [4, 4, 4], maze)

        if cnt != -1:
            result = min(result, cnt)
        return

    for i in range(N):
        if visited[i]:
            continue
        visited[i] = 1
        selected.append(arr[i])
        stack(k + 1, arr, visited, selected)
        selected.pop()
        visited[i] = 0


def select(k, arr):
    if k == N:
        stack(0, arr, [0] * N, [])
        return

    for i in range(4):
        if is_selected[k][i]:
            continue
        is_selected[k][i] = 1
        arr.append([k, i])
        select(k + 1, arr)
        arr.pop()
        is_selected[k][i] = 0


def solve():
    global N, board, is_selected, result

    N = 5
    temp = [list(map(int, input().split())) for _ in range(N * N)]

    if sum([sum(t) for t in temp]) == 5 ** 3:
        print(12)
        return

    split_temp = []
    for i in range(N):
        start, end = i * N, i * N + N
        split_temp.append(temp[start:end])

    board = [[] for _ in range(N)]
    for i in range(N):
        board[i].append(split_temp[i])
        for _ in range(3):
            split_temp[i] = rotate(split_temp[i])
            board[i].append(split_temp[i])

    is_selected = [[0] * 4 for _ in range(N)]
    result = 1e9
    select(0, [])
    print(result if result != 1e9 else -1)


if __name__ == "__main__":
    solve()
