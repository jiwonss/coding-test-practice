from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def roll(i, x, y):
    cnt = 0
    while board[x + dx[i]][y + dy[i]] != '#' and board[x][y] != 'O':
        x += dx[i]
        y += dy[i]
        cnt += 1
    return [x, y, cnt]


def tilt(rx, ry, bx, by):
    q = deque()
    visited = [[[[0] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]

    q.append([rx, ry, bx, by, 1])
    visited[rx][ry][bx][by] = 1

    while q:
        rx, ry, bx, by, cnt = q.popleft()

        if cnt > 10:
            return -1

        for i in range(4):
            nrx, nry, rcnt = roll(i, rx, ry)
            nbx, nby, bcnt = roll(i, bx, by)

            if board[nbx][nby] == 'O':
                continue
            if board[nrx][nry] == 'O':
                return cnt

            if [nrx, nry] == [nbx, nby]:
                if rcnt > bcnt:
                    nrx, nry = nrx - dx[i], nry - dy[i]
                else:
                    nbx, nby = nbx - dx[i], nby - dy[i]

            if visited[nrx][nry][nbx][nby]:
                continue

            visited[nrx][nry][nbx][nby] = 1
            q.append([nrx, nry, nbx, nby, cnt + 1])
    return -1


def solve():
    global N, M, board

    N, M = map(int, input().split())

    board = []
    rx, ry, bx, by = 0, 0, 0, 0
    for i in range(N):
        board.append(list(input().strip()))
        for j in range(M):
            if board[i][j] == 'R':
                rx, ry = i, j
            if board[i][j] == 'B':
                bx, by = i, j

    print(tilt(rx, ry, bx, by))


if __name__ == "__main__":
    solve()
